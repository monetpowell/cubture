package com.cubture.backend.savings;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

public interface SavingsRepository extends ListCrudRepository<Savings, UUID> {

}