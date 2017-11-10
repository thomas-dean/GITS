package me.tomdean.gits.services;

import me.tomdean.gits.models.Structure;

import java.util.List;

public interface StructureService {
    List<Structure> findAll();
    Structure findById(Long id);
    Structure findByType(String type);
}
