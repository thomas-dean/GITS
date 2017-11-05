package me.tomdean.gits.services;

import me.tomdean.gits.daos.RoleDao;
import me.tomdean.gits.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public Role findByRole(String role) {
        return roleDao.findByRole(role);
    }
}
