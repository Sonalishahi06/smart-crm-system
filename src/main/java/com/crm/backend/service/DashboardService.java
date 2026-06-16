package com.crm.backend.service;

import com.crm.backend.entity.Lead;
import com.crm.backend.entity.Task;
import com.crm.backend.repository.CustomerRepository;
import com.crm.backend.repository.LeadRepository;
import com.crm.backend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final CustomerRepository customerRepository;
    private final LeadRepository leadRepository;
    private final TaskRepository taskRepository;

    public Map<String,Long> getCustomerCount(){
        Map<String,Long> response=new HashMap<>();
        response.put("totalCustomers",customerRepository.count());
        return response;
    }

    public Map<String,Long> getLeadCount(){
        Map<String,Long> response=new HashMap<>();
        response.put("totalLeads",leadRepository.count());
        return response;
    }

    public Map<String ,Long> getTaskCount(){
        Map<String ,Long> response=new HashMap<>();
        response.put("totalTasks",taskRepository.count());
        return response;
    }

    public Map<String,Long> getLeadStatusSummary(){
        Map<String,Long> response=new HashMap<>();
        for(Lead.LeadStatus status:Lead.LeadStatus.values()){
            response.put(status.name(), leadRepository.countByStatus(status));
        }
        return response;
    }

    public Map<String,Long> getTaskStatusSummary(){
        Map<String,Long> response=new HashMap<>();
        for(Task.TaskStatus status:Task.TaskStatus.values()){
            response.put(status.name(),taskRepository.countByStatus(status));
        }
        return response;
    }
}
