package com.cubture.backend.income;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

// Repository provides methods for interacting with the income table
public interface IncomeRepository extends ListCrudRepository<Income, UUID> {

    List<Income> findByDateReceivedBetween(LocalDate startDate, LocalDate endDate);

}