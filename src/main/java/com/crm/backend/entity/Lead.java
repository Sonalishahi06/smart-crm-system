package com.crm.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String source;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;
    private Long assignedTo;
    private LocalDateTime createdAt=LocalDateTime.now();

    public enum LeadStatus{
        NEW,
        CONTACTED,
        QUALIFIED,
        WON,
        LOST
    }
}
