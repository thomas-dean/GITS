package me.tomdean.gits.daos;

import me.tomdean.gits.models.Structure;

import java.util.List;

public interface StructureDao {
    List<Structure> findAll();
    Structure findById(Long id);
    Structure findByType(String type);
}
