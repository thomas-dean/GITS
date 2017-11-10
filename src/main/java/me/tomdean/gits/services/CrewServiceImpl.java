package me.tomdean.gits.services;

import me.tomdean.gits.daos.CrewDao;
import me.tomdean.gits.models.Crew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("crewService")
@Transactional
public class CrewServiceImpl implements CrewService {
    @Autowired
    private CrewDao crewDao;

    @Override
    public void save(Crew crew) {
        crewDao.save(crew);
    }

    @Override
    public void delete(Crew crew) {
        crewDao.delete(crew);
    }

    @Override
    public Crew findById(Long id) {
        return crewDao.findById(id);
    }

    @Override
    public Crew findByCrewId(String crewId) {
        return crewDao.findByCrewId(crewId);
    }

    @Override
    public List<Crew> findAll() {
        return crewDao.findAll();
    }
}
