package com.crm.backend.controller;

import com.crm.backend.dto.LeadRequest;
import com.crm.backend.dto.LeadResponse;
import com.crm.backend.entity.Lead;
import com.crm.backend.repository.LeadRepository;
import com.crm.backend.service.LeadService;
import jakarta.validation.Valid;
import jdk.jfr.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {
    private final LeadService leadService;

    @PostMapping
    public LeadResponse createLead(@Valid @RequestBody LeadRequest request) {
        return leadService.createLead(request);
    }
    @GetMapping
    public List<LeadResponse> getLeads(){
        return leadService.getLeads();
    }
}
