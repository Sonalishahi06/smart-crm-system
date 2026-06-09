package com.crm.backend.service;

import com.crm.backend.dto.LeadRequest;
import com.crm.backend.dto.LeadResponse;
import com.crm.backend.entity.Lead;
import com.crm.backend.entity.User;
import com.crm.backend.exception.UnauthorizedLeadCreationException;
import com.crm.backend.exception.UserNotFoundException;
import com.crm.backend.repository.LeadRepository;
import com.crm.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LeadService {
    private final LeadRepository leadRepository;
    private final UserRepository userRepository;

    public LeadResponse createLead(LeadRequest request) {
        Authentication auth =
                SecurityContextHolder.getContext()
                        .getAuthentication();

        String email = auth.getName();

        User currentUser =
                userRepository.findByEmail(email);

        if (!"ADMIN".equals(currentUser.getRole())) {
            throw new UnauthorizedLeadCreationException(
                    "Only ADMIN can create leads");
        }
        User assignedUser = userRepository
                .findById(request.getAssignedTo())
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Assigned user not found"));

        if (!"USER".equals(assignedUser.getRole())) {
            throw new RuntimeException(
                    "Lead can only be assigned to employees");
        }

        Lead lead = new Lead();

        lead.setName(request.getName());
        lead.setEmail(request.getEmail());
        lead.setPhone(request.getPhone());
        lead.setSource(request.getSource());
        lead.setAssignedTo(request.getAssignedTo());

        if (request.getStatus() == null) {
            lead.setStatus(Lead.LeadStatus.NEW);
        } else {
            lead.setStatus(request.getStatus());
        }

        Lead savedLead = leadRepository.save(lead);

        return LeadResponse.builder()
                .id(savedLead.getId())
                .name(savedLead.getName())
                .email(savedLead.getEmail())
                .phone(savedLead.getPhone())
                .source(savedLead.getSource())
                .status(savedLead.getStatus())
                .assignedTo(savedLead.getAssignedTo())
                .createdAt(savedLead.getCreatedAt())
                .build();
    }

    public List<LeadResponse> getLeads(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        User user=userRepository.findByEmail(email);
        List<Lead> leads;
        if("ADMIN".equals(user.getRole())){
            leads = leadRepository.findAll();
        }
        else {
            leads = leadRepository.findByAssignedTo(user.getId());
        }
       return leads.stream()
               .map(this::mapToResponse)
               .toList();
    }
    private LeadResponse mapToResponse(Lead lead) {

        return LeadResponse.builder()
                .id(lead.getId())
                .name(lead.getName())
                .email(lead.getEmail())
                .phone(lead.getPhone())
                .source(lead.getSource())
                .status(lead.getStatus())
                .assignedTo(lead.getAssignedTo())
                .createdAt(lead.getCreatedAt())
                .build();
    }

}
