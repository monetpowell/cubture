package com.cubture.backend.activities;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// Allows the frontend running on port 5173 to make requests to this controller
@CrossOrigin(origins = "http://localhost:5173")

// Marks this class as a REST controller that handles HTTP requests
// Returned data is automatically sent back as a response
@RestController

// Groups this controller's endpoint under "Activities" in Swagger
@Tag(name = "Activities", description = "Retrieve family activities")
public class ActivityController {

    // The controller uses the service layer to handle the activity logic
    private final ActivityService activityService;

    // Constructor dependency injection provides the ActivityService to the
    // controller
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // Documents the endpoint in Swagger
    // The summary is shown as the short description of the endpoint
    // The description explains what the endpoint does
    @Operation(summary = "Get family activities", description = "Retrieves family activities from the Skiddle API.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = activities were retrieved successfully
    // 500 = unexpected server error occurred
    // 404 response not included as this endpoint retrieves activities
    // from Skiddle API rather than requesting a specific activity by ID
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Activities retrieved successfully"),
            // Specifies that the error response has no response body to document
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles GET requests to /api/activities
    @GetMapping("/api/activities")
    public String getActivities() {

        // Passes the request to the service layer
        // The service is responsible for retrieving the activities from the Skiddle API
        return activityService.getActivities();
    }
}