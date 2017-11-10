package me.tomdean.gits.services;

import me.tomdean.gits.daos.CleanupEffortDao;
import me.tomdean.gits.models.CleanupEffort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("cleanupEffortService")
@Transactional
public class CleanupEffortServiceImpl implements CleanupEffortService {
    @Autowired
    private CleanupEffortDao cleanupEffortDao;

    @Override
    public List<CleanupEffort> findAll() {
        return cleanupEffortDao.findAll();
    }

    @Override
    public CleanupEffort findById(Long id) {
        return cleanupEffortDao.findById(id);
    }

    @Override
    public CleanupEffort findByEffort(String effort) {
        return cleanupEffortDao.findByEffort(effort);
    }
}
