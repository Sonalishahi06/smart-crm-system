package com.crm.backend.dto;

import com.crm.backend.entity.Task;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskStatusRequest {
    @NotNull(message = "Status is required")
    private Task.TaskStatus status;
}
