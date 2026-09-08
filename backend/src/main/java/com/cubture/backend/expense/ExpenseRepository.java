package com.cubture.backend.expense;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

// Repository provides CRUD operations for the expense table.
// Spring Data JPA automatically creates the implementation.
public interface ExpenseRepository extends ListCrudRepository<Expense, UUID> {

    List<Expense> findByDatePaidBetween(
            LocalDate startDate,
            LocalDate endDate);
}