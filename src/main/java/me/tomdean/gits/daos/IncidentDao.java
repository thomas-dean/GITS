package me.tomdean.gits.daos;

import me.tomdean.gits.models.Incident;

import java.util.List;

public interface IncidentDao {
    void save(Incident incident);
    void delete(Incident incident);
    List<Incident> findAll();
    Incident findById(Long id);
}
