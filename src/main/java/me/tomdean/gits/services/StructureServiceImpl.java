package me.tomdean.gits.services;

import me.tomdean.gits.daos.StructureDao;
import me.tomdean.gits.models.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("structureService")
@Transactional
public class StructureServiceImpl implements StructureService {
    @Autowired
    private StructureDao structureDao;

    @Override
    public List<Structure> findAll() {
        return structureDao.findAll();
    }

    @Override
    public Structure findById(Long id) {
        return structureDao.findById(id);
    }

    @Override
    public Structure findByType(String type) {
        return structureDao.findByType(type);
    }
}
