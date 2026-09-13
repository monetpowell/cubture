package com.cubture.backend.childcare;

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

// Marks this class as a REST controller that handles HTTP requests
// Returned data is automatically sent back as a response
@RestController

// Maps all childcare endpoints to /api/childcare
@RequestMapping("/api/childcare")

// Groups the childcare endpoints under "Childcare" in Swagger
@Tag(name = "Childcare", description = "Manage family childcare costs")
public class ChildcareController {

    // The controller uses the service layer to handle childcare logic
    private final ChildcareService childcareService;

    // Constructor dependency injection provides the ChildcareService to the
    // controller
    public ChildcareController(ChildcareService childcareService) {
        this.childcareService = childcareService;
    }

    // Documents the endpoint in Swagger
    // The summary is shown as the short description of the endpoint
    // The description explains what the endpoint does
    @Operation(summary = "Get childcare records", description = "Retrieves childcare records for a specific month and year")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = childcare records were retrieved successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Childcare records retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    // Specifies that the error response has no response body to document
                    content = @Content)
    })

    // Handles GET requests to /api/childcare
    @GetMapping
    public List<Childcare> getChildcare(

            // Month used to retrieve childcare records
            @Parameter(description = "Month to retrieve childcare records for") @RequestParam int month,

            // Year used to retrieve childcare records
            @Parameter(description = "Year used to retrieve childcare records") @RequestParam int year) {

        // Passes the month and year to the service layer
        return childcareService.getChildcare(month, year);
    }

    // Documents the endpoint in Swagger
    // This endpoint retrieves a specific childcare record using its ID
    @Operation(summary = "Get a childcare record", description = "Retrieves a childcare record using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = childcare record was retrieved successfully
    // 404 = childcare record could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Childcare record retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Childcare record not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles GET requests to /api/childcare/{id}
    @GetMapping("/{id}")
    public Childcare getChildcare(

            // Unique ID of the childcare record to retrieve
            @Parameter(description = "Unique ID of the childcare record") @PathVariable UUID id) {

        // Passes the ID to the service layer
        return childcareService.getChildcare(id);
    }

    // Documents the endpoint in Swagger
    // This endpoint creates a new childcare record
    @Operation(summary = "Create a childcare record", description = "Creates a new childcare record.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 201 = childcare record was created successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Childcare record created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Returns HTTP 201 Created when a new childcare record is created
    @ResponseStatus(HttpStatus.CREATED)

    // Handles POST requests to /api/childcare
    @PostMapping
    public Childcare createChildcare(@RequestBody Childcare childcare) {

        // Passes the new childcare record to the service layer
        return childcareService.createChildcare(childcare);
    }

    // Documents the endpoint in Swagger
    // This endpoint updates an existing childcare record
    @Operation(summary = "Update a childcare record", description = "Updates an existing childcare record using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = childcare record was updated successfully
    // 404 = childcare record could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Childcare record updated successfully"),
            @ApiResponse(responseCode = "404", description = "Childcare record not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles PUT requests to /api/childcare/{id}
    @PutMapping("/{id}")
    public Childcare updateChildcare(

            // Unique ID of the childcare record to update
            @Parameter(description = "Unique ID of the childcare record") @PathVariable UUID id,

            // Contains updated childcare record data
            @RequestBody Childcare updatedChildcare) {

        // Passes the ID and updated data to the service layer
        return childcareService.updateChildcare(id, updatedChildcare);
    }

    // Documents the endpoint in Swagger
    // Deletes an existing childcare record
    @Operation(summary = "Delete a childcare record", description = "Deletes an existing childcare record using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = childcare record was deleted successfully
    // 404 = childcare record could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Childcare record deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Childcare record not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles DELETE requests to /api/childcare/{id}
    @DeleteMapping("/{id}")
    public void deleteChildcare(

            // Unique ID of the childcare record to delete
            @Parameter(description = "Unique ID of the childcare record") @PathVariable UUID id) {

        // Passes the ID to the service layer to delete the childcare record
        childcareService.deleteChildcare(id);
    }
}