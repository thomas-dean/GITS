package me.tomdean.gits.services;

import me.tomdean.gits.models.Damage;

import java.util.List;

public interface DamageService {
    List<Damage> findAll();
    Damage findById(Long id);
    Damage findBySeverity(String severity);
}
