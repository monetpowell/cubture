package com.cubture.backend.childcare;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

public interface ChildcareRepository extends ListCrudRepository<Childcare, UUID> {

    List<Childcare> findByDatePaidBetween(
            LocalDate startDate,
            LocalDate endDate);
}