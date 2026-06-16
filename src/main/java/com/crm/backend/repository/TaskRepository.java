package com.crm.backend.repository;

import com.crm.backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByAssignedTo(Long assignedTo);
    long countByStatus(Task.TaskStatus status);
}
