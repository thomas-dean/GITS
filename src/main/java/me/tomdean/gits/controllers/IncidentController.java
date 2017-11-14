package me.tomdean.gits.controllers;

import me.tomdean.gits.exception.BadRequestException;
import me.tomdean.gits.exception.ResourceNotFoundException;
import me.tomdean.gits.models.*;
import me.tomdean.gits.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/incidents")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private UserService userService;
    @Autowired
    private CleanupEffortService cleanupEffortService;
    @Autowired
    private CrewService crewService;
    @Autowired
    private DamageService damageService;
    @Autowired
    private InvestigationStatusService investigationStatusService;
    @Autowired
    private StructureService structureService;
    @Autowired
    private ImageFormatService imageFormatService;

    @RequestMapping(method = RequestMethod.GET)
    public String incidentsPage(ModelMap model) {
        List<Incident> allIncidents = incidentService.findAll();

        model.addAttribute("incidents", allIncidents);
        return "incidents";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(Principal principal,
                                 @RequestParam String dateOnSite,
                                 @RequestParam String cleanupEffort,
                                 @RequestParam String structure,
                                 @RequestParam String damage,
                                 @RequestParam String address,
                                 @RequestParam String nearestCrossStreets,
                                 @RequestParam double latitude,
                                 @RequestParam double longitude,
                                 @RequestParam String moniker,
                                 @RequestParam String crewId,
                                 @RequestParam String supervisor,
                                 @RequestParam List<MultipartFile> images) {
        InvestigationStatus investigationStatus =
                investigationStatusService.findByStatus(InvestigationStatusType.NEW.getStatus());
        Structure savedStructure;
        savedStructure = structureService.findByType(structure);
        if (savedStructure == null) {
            throw new BadRequestException("Unknown structure type: " + structure);
        }
        CleanupEffort savedCleanupEffort;
        savedCleanupEffort = cleanupEffortService.findByEffort(cleanupEffort);
        if (savedCleanupEffort == null) {
            throw new BadRequestException("Unknown cleanup effort: " + cleanupEffort);
        }
        Damage savedDamage;
        savedDamage = damageService.findBySeverity(damage);
        if (savedDamage == null) {
            throw new BadRequestException("Unknown damage severity: " + damage);
        }
        Crew crew;
        crew = crewService.findByCrewId(crewId);
        if (crew == null) {
            crew = new Crew();
            crew.setCrewId(crewId);
            crew.setSupervisor(supervisor);
            crewService.save(crew);
        } else {
            if (!crew.getSupervisor().equals(supervisor)) {
                /* You gave me a different supervisor than what I have on record */
                throw new BadRequestException("Supervisor does not match");
            }
        }
        Incident incident = new Incident();
        incident.setSubmitter(userService.findByUserName(principal.getName()));
        incident.setSuspects(new HashSet<>());
        incident.setStructure(savedStructure);
        incident.setAddress(address);
        incident.setNearestCrossStreets(nearestCrossStreets);
        incident.setMoniker(moniker);
        incident.setLatitude(latitude);
        incident.setLongitude(longitude);
        incident.setInvestigationStatus(investigationStatus);
        incident.setEffort(savedCleanupEffort);
        incident.setCrew(crew);
        Date parsedDateOnSite;
        try {
            parsedDateOnSite = new SimpleDateFormat("yyyy-MM-dd").parse(dateOnSite);
        } catch (ParseException e) {
            throw new BadRequestException("Could not parse date: " + dateOnSite);
        }
        incident.setDateOnSite(parsedDateOnSite);
        incident.setAmountOfDamage(savedDamage);
        Set<Image> imageSet = images.stream().map(f -> {
            Image i = new Image();
            try {
                String extension = FilenameUtils.getExtension(f.getOriginalFilename());
                ImageFormat format = imageFormatService.findByFormat(extension);
                if (imageFormatService.getMediaType(format) == null) {
                    throw new BadRequestException("Cannot convert file type to known media type: " + extension);
                }
                i.setFormat(format);
                i.setData(f.getBytes());
            } catch (IOException e) {
                throw new BadRequestException(f.getOriginalFilename() + ": Error saving file");
            }
            imageService.save(i);
            return i;
        }).collect(Collectors.toSet());
        incident.setImages(imageSet);
        /* TODO: have service return the saved object so we can add the resource location to the 201 response */
        incidentService.save(incident);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newIncidentPage(ModelMap model) {
        List<String> cleanupEfforts = cleanupEffortService.findAll().stream().
                map(CleanupEffort::getEffort).collect(Collectors.toList());
        List<String> damages = damageService.findAll().stream().
                map(Damage::getDamage).collect(Collectors.toList());
        List<String> structures = structureService.findAll().stream()
                .map(Structure::getStructure).collect(Collectors.toList());

        model.addAttribute("cleanupEfforts", cleanupEfforts);
        model.addAttribute("damages", damages);
        model.addAttribute("structures", structures);
        return "new_incident";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String incidentPage(@PathVariable Long id, ModelMap model) throws Exception {
        Incident incident = incidentService.findById(id);
        if (incident == null) {
            throw new ResourceNotFoundException();
        }

        model.addAttribute("incident", incident);
        return "incident";
    }

    @RequestMapping(path = "/images/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws Exception {
        Image image = imageService.findById(id);
        if (image == null) {
            throw new ResourceNotFoundException();
        }

        return ResponseEntity
                .ok()
                .contentType(imageFormatService.getMediaType(image.getFormat()))
                .body(image.getData());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(BadRequestException e) {
        return e.getMessage();
    }
}
