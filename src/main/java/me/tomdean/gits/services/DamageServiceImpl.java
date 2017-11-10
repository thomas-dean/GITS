package me.tomdean.gits.services;

import me.tomdean.gits.daos.DamageDao;
import me.tomdean.gits.models.Damage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("damageService")
@Transactional
public class DamageServiceImpl implements DamageService {
    @Autowired
    private DamageDao damageDao;

    @Override
    public List<Damage> findAll() {
        return damageDao.findAll();
    }

    @Override
    public Damage findById(Long id) {
        return damageDao.findById(id);
    }

    @Override
    public Damage findBySeverity(String severity) {
        return damageDao.findBySeverity(severity);
    }
}
