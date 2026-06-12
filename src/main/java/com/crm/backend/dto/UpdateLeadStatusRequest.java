package com.crm.backend.dto;

import com.crm.backend.entity.Lead;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLeadStatusRequest {
    @NotNull(message = "Status is required")
    private Lead.LeadStatus status;
}
