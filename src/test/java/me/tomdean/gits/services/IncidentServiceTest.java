package me.tomdean.gits.services;

import me.tomdean.gits.GitsApplication;
import me.tomdean.gits.models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitsApplication.class)
public class IncidentServiceTest {
    @Autowired
    private IncidentService incidentService;
    @Autowired
    private DamageService damageService;
    @Autowired
    private CrewService crewService;
    @Autowired
    private CleanupEffortService cleanupEffortService;
    @Autowired
    private InvestigationStatusService investigationStatusService;
    @Autowired
    private StructureService structureService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    private Crew savedCrew;
    private Incident savedIncident;
    private User lawEnforcementUser;
    private User submitterUser;

    @Before
    public void setUp() throws Exception {
        savedCrew = new Crew();
        savedCrew.setCrewId("F12B5");
        savedCrew.setSupervisor("Jane Smith");

        crewService.save(savedCrew);

        Set<Role> lawEnforcementRoles = new HashSet<>();
        lawEnforcementRoles.add(roleService.findByRole(RoleType.USER.getRoleType()));
        lawEnforcementRoles.add(roleService.findByRole(RoleType.LAW_ENFORCEMENT.getRoleType()));

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.findByRole(RoleType.USER.getRoleType()));

        lawEnforcementUser = new User();
        lawEnforcementUser.setPassword("password");
        lawEnforcementUser.setUserName("the_law");
        lawEnforcementUser.setEmployeeNumber(113355);
        lawEnforcementUser.setJobTitle("Officer");
        lawEnforcementUser.setRoles(lawEnforcementRoles);

        userService.save(lawEnforcementUser);

        submitterUser = new User();
        submitterUser.setPassword("password");
        submitterUser.setUserName("on_looker");
        submitterUser.setEmployeeNumber(115577);
        submitterUser.setJobTitle("Submitter");
        submitterUser.setRoles(userRoles);

        userService.save(submitterUser);

        savedIncident = new Incident();
        savedIncident.setAddress("123 Fake street");
        savedIncident.setAmountOfDamage(damageService.findBySeverity(DamageType.MEDIUM.getDamage()));
        savedIncident.setCrew(savedCrew);
        savedIncident.setDateCleanedUp(new GregorianCalendar(2017, 10, 20).getTime());
        savedIncident.setDateCreated(new GregorianCalendar(2017, 10, 10).getTime());
        savedIncident.setDateOnSite(new GregorianCalendar(2017, 10, 9).getTime());
        savedIncident.setEffort(cleanupEffortService.findByEffort(CleanupEffortType.HIGH.getEffort()));
        savedIncident.setInvestigationStatus(
                investigationStatusService.findByStatus(InvestigationStatusType.IN_PROCESS.getStatus()));
        savedIncident.setImages(new HashSet<>());
        savedIncident.setLatitude(32.7157);
        savedIncident.setLongitude(117.1611);
        savedIncident.setLawEnforcementOfficial(lawEnforcementUser);
        savedIncident.setMoniker("Some guy");
        savedIncident.setNearestCrossStreets("Main and 1st");
        savedIncident.setStructure(structureService.findByType(StructureType.FED_GOV.getStructure()));
        savedIncident.setSubmitter(submitterUser);
        savedIncident.setSuspects(new HashSet<>());

        incidentService.save(savedIncident);
    }

    @After
    public void tearDown() throws Exception {
        incidentService.delete(savedIncident);
        crewService.delete(savedCrew);
        userService.delete(lawEnforcementUser);
        userService.delete(submitterUser);
    }

    @Test
    public void shouldFindAllIncidents() throws Exception {
        List<Incident> allIncidents = incidentService.findAll();
        assertThat(allIncidents.size(), is(1));
        for (Incident i: allIncidents) {
            assertThat(savedIncident, is(i));
        }
    }

    @Test
    public void shouldFindSpecificIncident() throws Exception {
        assertThat(savedIncident, is(incidentService.findById(savedIncident.getId())));
    }

}