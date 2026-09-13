package com.cubture.backend.dashboard;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// Allows the frontend running on port 5173 to make requests to this controller
@CrossOrigin(origins = "http://localhost:5173")

// Marks this class as a REST controller that handles HTTP requests
// Returned data is automatically sent back as a response
@RestController

// Groups this controller's endpoint under "Dashboard" in Swagger
@Tag(name = "Dashboard", description = "Retrieve the family financial dashboard summary")
public class DashboardController {

    // The controller uses the service layer to handle the dashboard logic
    private final DashboardService dashboardService;

    // Constructor dependency injection provides the DashboardService to the
    // controller
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    // Documents the endpoint in Swagger
    // The summary is shown as the short description of the endpoint
    // The description explains what the endpoint does
    @Operation(summary = "Get dashboard summary", description = "Retrieves the financial dashboard summary for a specific month and year. If no month or year is provided, the current month and year are used.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = dashboard summary was retrieved successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dashboard summary retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    // Specifies that the error response has no response body to document
                    content = @Content)
    })

    // Handles GET requests to /dashboard/summary
    @GetMapping("/dashboard/summary")
    public DashboardSummary getSummary(

            // Optional month parameter used to retrieve data for a specific month
            @Parameter(description = "Month to retrieve the dashboard summary for") @RequestParam(required = false) Integer month,

            // Optional year parameter used to retrieve data for a specific year
            @Parameter(description = "Year to retrieve the dashboard summary for") @RequestParam(required = false) Integer year) {

        // Gets today's date so the current month and year can be used when parameters
        // are not provided
        LocalDate today = LocalDate.now();

        // If no month is provided, use the current month
        if (month == null) {
            month = today.getMonthValue();
        }

        // If no year is provided, use the current year
        if (year == null) {
            year = today.getYear();
        }

        // Passes the month and year to the service layer to calculate the dashboard
        // summary
        return dashboardService.getSummary(month, year);
    }
}