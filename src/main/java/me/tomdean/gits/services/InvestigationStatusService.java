package me.tomdean.gits.services;

import me.tomdean.gits.models.InvestigationStatus;

import java.util.List;

public interface InvestigationStatusService {
    List<InvestigationStatus> findAll();
    InvestigationStatus findById(Long id);
    InvestigationStatus findByStatus(String status);
}
