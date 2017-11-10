package me.tomdean.gits.daos;

import me.tomdean.gits.models.CleanupEffort;

import java.util.List;

public interface CleanupEffortDao {
    List<CleanupEffort> findAll();
    CleanupEffort findById(Long id);
    CleanupEffort findByEffort(String effort);
}
