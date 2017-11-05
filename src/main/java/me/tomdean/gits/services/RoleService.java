package me.tomdean.gits.services;

import me.tomdean.gits.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);
    Role findByRole(String role);
}
