package com.crm.backend.repository;

import com.crm.backend.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository  extends JpaRepository<Lead,Long> {
    List<Lead> findByAssignedTo(Long assignedTo);
    List<Lead> findByStatus(Lead.LeadStatus status);
    List<Lead> findByAssignedToAndStatus(
            Long assignedTo,
            Lead.LeadStatus status
    );
    long countByStatus(Lead.LeadStatus status);
}
