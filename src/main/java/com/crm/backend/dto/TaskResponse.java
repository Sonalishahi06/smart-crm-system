package com.crm.backend.dto;

import com.crm.backend.entity.Task;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TaskResponse {
   private Long id;
   private  String title;
   private String description;
   private Long assignedTo;
   private Task.TaskStatus status;
   private LocalDateTime createdAt;

}
