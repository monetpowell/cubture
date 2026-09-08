package com.cubture.backend.income;

import java.util.List;
import java.util.NoSuchElementException;
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
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:5173")

// The @RestController annotation marks this class as a REST controller
// It handles incoming HTTP requests and returns responses as JSON
@RestController

// Maps all endpoints in this controller to /api/income.
@RequestMapping("/api/income")
public class IncomeController {

    // The controller delegates business logic to the service layer
    private final IncomeService incomeService;

    // Constructor dependency injection
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    // Handles HTTP GET requests to retrieve all income records
    @GetMapping
    public List<Income> getAllIncome(
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year) {

        return incomeService.getAllIncome(month, year);
    }

    // Handles GET /api/income/{id}
    // Retrieves a single income by its UUID
    // @PathVariable extracts the id value from the URL
    @GetMapping("/{id}")
    public Income getIncome(@PathVariable UUID id) {
        try {
            return incomeService.getIncome(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Income not found",
                    exception);
        }
    }

    // Handles POST /api/income
    // Creates a new income from the JSON request body
    // Returns HTTP 201 (Created) when a new income record is successfully created.
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeService.createIncome(income);
    }

    // Handles PUT /api/income/{id}
    // Updates an existing income.
    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable UUID id, @RequestBody Income updatedIncome) {
        try {
            return incomeService.updateIncome(id, updatedIncome);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Income not found",
                    exception);
        }
    }

    // Handles DELETE /api/income/{id}
    // Deletes an income by its UUID
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable UUID id) {
        try {
            incomeService.deleteIncome(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Income not found",
                    exception);
        }
    }

}
