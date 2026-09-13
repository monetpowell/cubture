package com.cubture.backend.savings;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// Allows frontend running on port 5173 to make requests to this controller
@CrossOrigin(origins = "http://localhost:5173")

// Marks this class as a REST controller that handles HTTP requests
// Returned data is automatically sent back as a response
@RestController

// Maps all savings endpoints to /api/savings
@RequestMapping("/api/savings")

// Groups the savings endpoints under "Savings" in Swagger
@Tag(name = "Savings", description = "Manage family savings goals")
public class SavingsController {

    // The controller uses the service layer to handle savings logic
    private final SavingsService savingsService;

    // Constructor dependency injection provides the SavingsService to the
    // controller
    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }

    // Documents the endpoint in Swagger
    // The summary is shown as the short description of the endpoint
    // The description explains what the endpoint does
    @Operation(summary = "Get all savings goals", description = "Retrieves all savings goals.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = savings goals retrieved successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Savings goals retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    // Specifies that the error response has no response body to document
                    content = @Content)
    })

    // Handles GET requests to /api/savings
    @GetMapping
    public List<Savings> getAllSavings() {

        // Passes the request to the service layer
        return savingsService.getAllSavings();
    }

    // Documents the endpoint in Swagger
    // This endpoint retrieves a specific savings goal using its ID
    @Operation(summary = "Get a savings goal", description = "Retrieves a savings goal using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = savings goal retrieved successfully
    // 404 = savings goal could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Savings goal retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Savings goal not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles GET requests to /api/savings/{id}
    @GetMapping("/{id}")
    public Savings getSavings(

            // Unique ID of the savings goal to retrieve
            @Parameter(description = "Unique ID of the savings goal") @PathVariable UUID id) {

        // Passes the ID to the service layer
        return savingsService.getSavings(id);
    }

    // Documents the endpoint in Swagger
    // This endpoint creates a new savings goal
    @Operation(summary = "Create a savings goal", description = "Creates a new savings goal.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 201 = savings goal created successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Savings goal created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Returns HTTP 201 Created when a new savings goal is created
    @ResponseStatus(HttpStatus.CREATED)

    // Handles POST requests to /api/savings
    @PostMapping
    public Savings createSavings(@RequestBody Savings savings) {

        // Passes the new savings goal to the service layer
        return savingsService.createSavings(savings);
    }

    // Documents the endpoint in Swagger
    // This endpoint updates an existing savings goal
    @Operation(summary = "Update a savings goal", description = "Updates an existing savings goal using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = savings goal updated successfully
    // 404 = savings goal could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Savings goal updated successfully"),
            @ApiResponse(responseCode = "404", description = "Savings goal not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles PUT requests to /api/savings/{id}
    @PutMapping("/{id}")
    public Savings updateSavings(

            // Unique ID of the savings goal to update
            @Parameter(description = "Unique ID of the savings goal") @PathVariable UUID id,

            // Contains the updated savings goal data
            @RequestBody Savings updatedSavings) {

        // Passes the ID and updated data to the service layer
        return savingsService.updateSavings(id, updatedSavings);
    }

    // Documents the endpoint in Swagger
    // This endpoint deletes an existing savings goal
    @Operation(summary = "Delete a savings goal", description = "Deletes an existing savings goal using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = savings goal deleted successfully
    // 404 = savings goal could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Savings goal deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Savings goal not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles DELETE requests to /api/savings/{id}
    @DeleteMapping("/{id}")
    public void deleteSavings(

            // Unique ID of the savings goal to delete
            @Parameter(description = "Unique ID of the savings goal") @PathVariable UUID id) {

        // Passes the ID to the service layer to delete the savings goal
        savingsService.deleteSavings(id);
    }
}