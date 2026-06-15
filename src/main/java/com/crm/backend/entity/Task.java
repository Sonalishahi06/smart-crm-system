package com.crm.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private  String description;
    private Long assignedTo;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime createdAt=LocalDateTime.now();

    public enum TaskStatus{
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}
