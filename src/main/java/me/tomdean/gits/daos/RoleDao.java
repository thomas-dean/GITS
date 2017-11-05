package me.tomdean.gits.daos;

import me.tomdean.gits.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();
    Role findByRole(String role);
    Role findById(Long id);
}
