package com.crm.backend.controller;

import com.crm.backend.dto.TaskRequest;
import com.crm.backend.dto.TaskResponse;
import com.crm.backend.dto.UpdateTaskStatusRequest;
import com.crm.backend.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request){
        return taskService.createTask(request);
    }
    @GetMapping
    public List<TaskResponse> getTask(){
        return taskService.getTasks();
    }
    @PutMapping("/{id}/status")
    public TaskResponse updateTask(@PathVariable Long id, @Valid @RequestBody UpdateTaskStatusRequest request){
        return taskService.updateTaskStatus(id,request);
    }
}
