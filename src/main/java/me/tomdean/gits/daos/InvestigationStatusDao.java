package me.tomdean.gits.daos;

import me.tomdean.gits.models.InvestigationStatus;

import java.util.List;

public interface InvestigationStatusDao {
    List<InvestigationStatus> findAll();
    InvestigationStatus findById(Long id);
    InvestigationStatus findByStatus(String status);
}
