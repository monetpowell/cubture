package com.cubture.backend.dashboard;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard/summary")
    public DashboardSummary getSummary(

            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year) {

        LocalDate today = LocalDate.now();

        if (month == null) {
            month = today.getMonthValue();
        }

        if (year == null) {
            year = today.getYear();
        }

        return dashboardService.getSummary(month, year);
    }
}