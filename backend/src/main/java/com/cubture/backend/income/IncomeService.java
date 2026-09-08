package com.cubture.backend.income;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

// The service layer contains the application's business logic.
// It determines how data should be processed before interacting
// with the repository.
// The @Service annotation marks this class as a service component
// Spring detects it during component scanning and creates a Spring Bean,
// allowing it to be managed by the Spring IoC container.
@Service
public class IncomeService {

    // The repository is injected into the service through the constructor
    // This allows the service to interact with the database without
    // creating the repository itself
    // final - once the repository has been provided by Spring
    // it should not be reassigned
    private final IncomeRepository incomeRepository;

    // Constructor injection.
    // Spring injects an implementation of IncomeRepository into the service.
    // Interfaces cannot be instantiated directly, so Spring Data JPA
    // automatically generates the repository implementation at runtime
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> getAllIncome(Integer month, Integer year) {

        if (month == null || year == null) {
            return incomeRepository.findAll();
        }

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        return incomeRepository.findByDateReceivedBetween(startDate, endDate);
    }

    // Retrieves a single income record by its unique identifier
    // findById() return an Optional<Income> instead of returning null
    // Spring can't guarantee that an Income with that ID exists
    // specified ID may not exist in the database
    // Throws an exception if no matching income is found
    public Income getIncome(UUID id) throws NoSuchElementException {
        return incomeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Income not found"));
    }

    // Creates a new income record in the database
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    // Updates an existing income record
    // Throws an exception if the income does not exist
    public Income updateIncome(UUID id, Income updatedIncome) throws NoSuchElementException {

        // make sure the record exists first
        Income existingIncome = getIncome(id);

        existingIncome.setSource(updatedIncome.getSource());
        existingIncome.setAmount(updatedIncome.getAmount());
        existingIncome.setDateReceived(updatedIncome.getDateReceived());
        existingIncome.setFrequency(updatedIncome.getFrequency());

        return incomeRepository.save(existingIncome);
    }

    // Deletes an income record by its unique identifier
    public void deleteIncome(UUID id) {
        incomeRepository.deleteById(id);
    }
}
