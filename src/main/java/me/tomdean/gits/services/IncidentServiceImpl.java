package me.tomdean.gits.services;

import me.tomdean.gits.daos.IncidentDao;
import me.tomdean.gits.models.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("incidentService")
@Transactional
public class IncidentServiceImpl implements IncidentService {
    @Autowired
    private IncidentDao incidentDao;

    @Override
    public void save(Incident incident) {
        incidentDao.save(incident);
    }

    @Override
    public void delete(Incident incident) {
        incidentDao.delete(incident);
    }

    @Override
    public List<Incident> findAll() {
        return incidentDao.findAll();
    }

    @Override
    public Incident findById(Long id) {
        return incidentDao.findById(id);
    }
}
