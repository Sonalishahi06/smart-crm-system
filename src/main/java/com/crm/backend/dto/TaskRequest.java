package com.crm.backend.dto;

import com.crm.backend.entity.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    @NotNull(message = "Assigned user is required")
    private Long assignedTo;
    private Task.TaskStatus status;
}
