package com.crm.backend.dto;

import com.crm.backend.entity.Lead;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadRequest {
    @NotBlank(message = "Lead name is required")
    private String name;
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phone;
    private String source;

    private Long assignedTo;

    private Lead.LeadStatus status;
}
