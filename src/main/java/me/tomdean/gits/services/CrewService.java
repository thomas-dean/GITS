package me.tomdean.gits.services;

import me.tomdean.gits.models.Crew;

import java.util.List;

public interface CrewService {
    void save(Crew crew);
    void delete(Crew crew);
    Crew findById(Long id);
    Crew findByCrewId(String crewId);
    List<Crew> findAll();
}
