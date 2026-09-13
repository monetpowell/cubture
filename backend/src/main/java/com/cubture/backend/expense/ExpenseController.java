package com.cubture.backend.expense;

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

// Maps all expense endpoints to /api/expenses
@RequestMapping("/api/expenses")

// Groups the expense endpoints under "Expenses" in Swagger
@Tag(name = "Expenses", description = "Manage family expenses")
public class ExpenseController {

    // The controller uses the service layer to handle expense logic
    private final ExpenseService expenseService;

    // Constructor dependency injection provides the ExpenseService to the
    // controller
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Documents the endpoint in Swagger
    // The summary is shown as the short description of the endpoint
    // The description explains what the endpoint does
    @Operation(summary = "Get all expenses", description = "Retrieves expenses, optionally filtered by month and year")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = expenses retrieved successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expenses retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    // Specifies that the error response has no response body to document
                    content = @Content)
    })

    // Handles GET requests to /api/expenses
    @GetMapping
    public List<Expense> getExpenses(

            // Optional month used to filter expenses
            @Parameter(description = "Month to filter expenses by") @RequestParam(required = false) Integer month,

            // Optional year used to filter expenses
            @Parameter(description = "Year to filter expenses by") @RequestParam(required = false) Integer year) {

        // If both month and year are provided, retrieve filtered expenses
        if (month != null && year != null) {
            return expenseService.getExpenses(month, year);
        }

        // If no filter is provided, retrieve all expenses
        return expenseService.getAllExpenses();
    }

    // Documents the endpoint in Swagger
    // This endpoint retrieves a specific expense using its ID
    @Operation(summary = "Get an expense", description = "Retrieves an expense using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = expense retrieved successfully
    // 404 = expense could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Expense not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles GET requests to /api/expenses/{id}
    @GetMapping("/{id}")
    public Expense getExpense(

            // Unique ID of the expense to retrieve
            @Parameter(description = "Unique ID of the expense") @PathVariable UUID id) {

        // Passes the ID to the service layer
        return expenseService.getExpense(id);
    }

    // Documents the endpoint in Swagger
    // This endpoint creates a new expense
    @Operation(summary = "Create an expense", description = "Creates a new expense.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 201 = expense created successfully
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Expense created successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Returns HTTP 201 Created when a new expense is created
    @ResponseStatus(HttpStatus.CREATED)

    // Handles POST requests to /api/expenses
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {

        // Passes the new expense to the service layer
        return expenseService.createExpense(expense);
    }

    // Documents the endpoint in Swagger
    // This endpoint updates an existing expense
    @Operation(summary = "Update an expense", description = "Updates an existing expense using its unique ID.")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = expense updated successfully
    // 404 = expense could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense updated successfully"),
            @ApiResponse(responseCode = "404", description = "Expense not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles PUT requests to /api/expenses/{id}
    @PutMapping("/{id}")
    public Expense updateExpense(

            // Unique ID of the expense to update
            @Parameter(description = "Unique ID of the expense") @PathVariable UUID id,

            // Contains the updated expense data
            @RequestBody Expense updatedExpense) {

        // Passes the ID and updated data to the service layer
        return expenseService.updateExpense(id, updatedExpense);
    }

    // Documents the endpoint in Swagger
    // This endpoint deletes an existing expense
    @Operation(summary = "Delete an expense", description = "Deletes an existing expense using its unique ID")

    // Documents the possible HTTP responses for this endpoint in Swagger
    // 200 = expense deleted successfully
    // 404 = expense could not be found
    // 500 = unexpected server error occurred
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expense deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Expense not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    // Handles DELETE requests to /api/expenses/{id}
    @DeleteMapping("/{id}")
    public void deleteExpense(

            // Unique ID of the expense to delete
            @Parameter(description = "Unique ID of the expense") @PathVariable UUID id) {

        // Passes the ID to the service layer to delete the expense
        expenseService.deleteExpense(id);
    }
}