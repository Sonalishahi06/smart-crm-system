package com.crm.backend.dto;

import com.crm.backend.entity.Lead;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class LeadResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String source;
    private Lead.LeadStatus status;
    private Long assignedTo;
    private LocalDateTime createdAt;

}
