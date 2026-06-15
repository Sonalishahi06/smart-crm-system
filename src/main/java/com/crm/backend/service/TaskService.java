package com.crm.backend.service;

import com.crm.backend.dto.TaskRequest;
import com.crm.backend.dto.TaskResponse;
import com.crm.backend.dto.UpdateTaskStatusRequest;
import com.crm.backend.entity.Task;
import com.crm.backend.entity.User;
import com.crm.backend.exception.*;
import com.crm.backend.repository.TaskRepository;
import com.crm.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskResponse createTask(TaskRequest request){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        User currentUser=userRepository.findByEmail(email);

        if(!"ADMIN".equals(currentUser.getRole())){
            throw new UnauthorizedLeadCreationException("Only ADMIN can create Tasks");
        }
        User assignedUser=userRepository.findById(request.getAssignedTo()).orElseThrow(()->
                new UserNotFoundException("Assigned user not found"));

        if(!"USER".equals(assignedUser.getRole())){
            throw new InvalidTaskAssignmentException("Task can only be assinged to employee");
        }

        Task task=new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setAssignedTo(request.getAssignedTo());
        if(request.getStatus()==null){
            task.setStatus(Task.TaskStatus.PENDING);
        }
        else{
            task.setStatus(request.getStatus());
        }
        Task savedTask=taskRepository.save(task);
        return mapToReaponse(savedTask);
    }

    public List<TaskResponse> getTasks(){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        User user=userRepository.findByEmail(email);
        List<Task> tasks;
        if("ADMIN".equals((user.getRole()))){
            tasks=taskRepository.findAll();
        }
        else {
            tasks=taskRepository.findByAssignedTo(user.getId());
        }
        return tasks.stream().map(this::mapToReaponse).toList();
    }

public TaskResponse updateTaskStatus(Long taskId, UpdateTaskStatusRequest request){
        Task task=taskRepository.findById(taskId).orElseThrow(()->
                new TaskNotFoundException("Task not found"));
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        String email= auth.getName();
        User currentUser=userRepository.findByEmail(email);
        if("USER".equals(currentUser.getRole()) && !task.getAssignedTo().equals(currentUser.getId())){
            throw new UnauthorizedTaskUpdateException("You can update only your assigned tasks");
    }
        task.setStatus(request.getStatus());
        Task updatedTask=taskRepository.save(task);
        return mapToReaponse(updatedTask);
}



    private TaskResponse mapToReaponse(Task task){
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .assignedTo(task.getAssignedTo())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .build();
    }
}
