package me.tomdean.gits.services;

import me.tomdean.gits.daos.InvestigationStatusDao;
import me.tomdean.gits.models.InvestigationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("investigationStatusService")
@Transactional
public class InvestigationStatusServiceImpl implements InvestigationStatusService {
    @Autowired
    private InvestigationStatusDao investigationStatusDao;

    @Override
    public List<InvestigationStatus> findAll() {
        return investigationStatusDao.findAll();
    }

    @Override
    public InvestigationStatus findById(Long id) {
        return investigationStatusDao.findById(id);
    }

    @Override
    public InvestigationStatus findByStatus(String status) {
        return investigationStatusDao.findByStatus(status);
    }
}
