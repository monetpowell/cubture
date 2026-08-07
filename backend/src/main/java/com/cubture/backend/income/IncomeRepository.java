package com.cubture.backend.income;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

// Repository provides methods for interacting with the income table
// Spring Data JPA automatically implements common CRUD operations
// Reads from and writes to the database

public interface IncomeRepository extends ListCrudRepository<Income, UUID> {

}