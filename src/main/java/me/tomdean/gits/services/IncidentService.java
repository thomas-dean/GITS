package me.tomdean.gits.services;

import me.tomdean.gits.models.Incident;

import java.util.List;

public interface IncidentService {
    void save(Incident incident);
    void delete(Incident incident);
    List<Incident> findAll();
    Incident findById(Long id);
}
