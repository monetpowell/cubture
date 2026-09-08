package com.cubture.backend.expense;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

// The service layer contains the application's business logic.
@Service
public class ExpenseService {

    // Repository used to access the database.
    private final ExpenseRepository expenseRepository;

    // Constructor injection.
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Returns all expenses.
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Returns a single expense.
    public Expense getExpense(UUID id) throws NoSuchElementException {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Expense not found"));
    }

    public List<Expense> getExpenses(int month, int year) {

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        return expenseRepository.findByDatePaidBetween(startDate, endDate);
    }

    // Creates a new expense.
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Updates an existing expense.
    public Expense updateExpense(UUID id, Expense updatedExpense)
            throws NoSuchElementException {

        Expense existingExpense = getExpense(id);

        existingExpense.setName(updatedExpense.getName());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setDatePaid(updatedExpense.getDatePaid());
        existingExpense.setFrequency(updatedExpense.getFrequency());

        return expenseRepository.save(existingExpense);
    }

    // Deletes an expense.
    public void deleteExpense(UUID id) {
        expenseRepository.deleteById(id);
    }
}