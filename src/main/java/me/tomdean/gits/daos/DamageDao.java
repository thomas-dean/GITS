package me.tomdean.gits.daos;

import me.tomdean.gits.models.Damage;

import java.util.List;

public interface DamageDao {
    List<Damage> findAll();
    Damage findById(Long id);
    Damage findBySeverity(String severity);
}
