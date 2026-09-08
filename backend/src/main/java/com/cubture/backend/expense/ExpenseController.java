package com.cubture.backend.expense;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Returns all expenses.
    @GetMapping
    public List<Expense> getExpenses(
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year) {

        if (month != null && year != null) {
            return expenseService.getExpenses(month, year);
        }

        return expenseService.getAllExpenses();
    }

    // Returns a single expense.
    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable UUID id) {
        try {
            return expenseService.getExpense(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Expense not found",
                    exception);
        }
    }

    // Creates a new expense.
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    // Updates an expense.
    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable UUID id,
            @RequestBody Expense updatedExpense) {

        try {
            return expenseService.updateExpense(id, updatedExpense);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Expense not found",
                    exception);
        }
    }

    // Deletes an expense.
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable UUID id) {
        try {
            expenseService.deleteExpense(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Expense not found",
                    exception);
        }
    }
}