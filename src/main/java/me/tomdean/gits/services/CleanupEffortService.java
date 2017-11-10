package me.tomdean.gits.services;

import me.tomdean.gits.models.CleanupEffort;

import java.util.List;

public interface CleanupEffortService {
    List<CleanupEffort> findAll();
    CleanupEffort findById(Long id);
    CleanupEffort findByEffort(String effort);
}
