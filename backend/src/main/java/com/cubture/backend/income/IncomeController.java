package com.cubture.backend.income;

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
import org.springframework.web.bind.annotation.RequestParam;
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

// The @RestController annotation marks the class as a REST controller
// Handles incoming HTTP requests and returns responses as JSON
@RestController

// Maps all endpoints in controller to /api/income
@RequestMapping("/api/income")

// Groups the income endpoints under "Income" in Swagger
@Tag(name = "Income", description = "Manage family income records")
public class IncomeController {

    // The controller uses the service layer to handle income logic
    private final IncomeService incomeService;

    // Constructor dependency injection provides the IncomeService to the controller
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    // Documents the endpoint in Swagger
    // The summary is shown as the short description of the endpoint
    // The description explains what the endpoint does
    @Operation(summary = "Get all income records", description = "Retrieves income records, optionally filtered by month and year.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = income records retrieved successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Income records retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    // Specifies that the error response has no response body to document
                    content = @Content)
    })

    // Handles GET requests to /api/income
    @GetMapping
    public List<Income> getAllIncome(

            // Optional month used to filter income records
            @Parameter(description = "Month to filter income records by") @RequestParam(required = false) Integer month,

            // Optional year used to filter income records
            @Parameter(description = "Year to filter income records by") @RequestParam(required = false) Integer year) {

        // Passes the month and year to the service layer
        return incomeService.getAllIncome(month, year);
    }

    // Documents the endpoint in Swagger
    // This endpoint retrieves a specific income record using its ID
    @Operation(summary = "Get an income record", description = "Retrieves an income record using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = income record retrieved successfully
    // 404 = income record could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Income record retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Income record not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles GET requests to /api/income/{id}
    @GetMapping("/{id}")
    public Income getIncome(

            // Unique ID of the income record to retrieve
            @Parameter(description = "Unique ID of the income record") @PathVariable UUID id) {

        // Passes the ID to the service layer
        return incomeService.getIncome(id);
    }

    // Documents the endpoint in Swagger
    // This endpoint creates a new income record
    @Operation(summary = "Create an income record", description = "Creates a new income record.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 201 = income record created successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Income record created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Returns HTTP 201 Created when a new income record is created
    @ResponseStatus(HttpStatus.CREATED)

    // Handles POST requests to /api/income
    @PostMapping
    public Income createIncome(@RequestBody Income income) {

        // Passes the new income record to the service layer
        return incomeService.createIncome(income);
    }

    // Documents the endpoint in Swagger
    // This endpoint updates an existing income record
    @Operation(summary = "Update an income record", description = "Updates an existing income record using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = income record updated successfully
    // 404 = income record could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Income record updated successfully"),
            @ApiResponse(responseCode = "404", description = "Income record not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles PUT requests to /api/income/{id}
    @PutMapping("/{id}")
    public Income updateIncome(

            // Unique ID of the income record to update
            @Parameter(description = "Unique ID of the income record") @PathVariable UUID id,

            // Contains the updated income record data
            @RequestBody Income updatedIncome) {

        // Passes the ID and updated data to the service layer
        return incomeService.updateIncome(id, updatedIncome);
    }

    // Documents the endpoint in Swagger
    // This endpoint deletes an existing income record
    @Operation(summary = "Delete an income record", description = "Deletes an existing income record using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = income record deleted successfully
    // 404 = income record could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Income record deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Income record not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles DELETE requests to /api/income/{id}
    @DeleteMapping("/{id}")
    public void deleteIncome(

            // Unique ID of the income record to delete
            @Parameter(description = "Unique ID of the income record") @PathVariable UUID id) {

        // Passes the ID to the service layer to delete the income record
        incomeService.deleteIncome(id);
    }
}