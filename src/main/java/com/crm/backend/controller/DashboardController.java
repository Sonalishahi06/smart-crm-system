package com.crm.backend.controller;

import com.crm.backend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/customers/count")
    public Map<String,Long> getCustomerCount(){
        return dashboardService.getCustomerCount();
    }
    @GetMapping("/leads/count")
    public Map<String,Long> getLeadCount(){
        return dashboardService.getLeadCount();
    }
    @GetMapping("/tasks/count")
    public Map<String,Long> getTaskCount(){
        return dashboardService.getTaskCount();
    }
    @GetMapping("/leads/status")
    public Map<String,Long> getLeadStatusSummary(){
        return dashboardService.getLeadStatusSummary();
    }
    @GetMapping("/tasks/status")
    public Map<String,Long> getTaskStatusSummary(){
        return dashboardService.getTaskStatusSummary();
    }
}
