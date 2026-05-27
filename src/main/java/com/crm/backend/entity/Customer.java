package com.crm.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String company;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Long createdBy;
    private LocalDateTime createdAt=LocalDateTime.now();

    public enum Status{
        ACTIVE,
        INACTIVE
    }
}
