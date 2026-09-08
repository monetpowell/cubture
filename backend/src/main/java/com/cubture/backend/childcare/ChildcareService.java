package com.cubture.backend.childcare;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ChildcareService {

    private final ChildcareRepository childcareRepository;

    public ChildcareService(ChildcareRepository childcareRepository) {
        this.childcareRepository = childcareRepository;
    }

    // Get all childcare records for a selected month
    public List<Childcare> getChildcare(int month, int year) {

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        return childcareRepository.findByDatePaidBetween(startDate, endDate);
    }

    // Get a single childcare record by ID
    public Childcare getChildcare(UUID id) {
        return childcareRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Childcare not found"));
    }

    // Create a new childcare record
    public Childcare createChildcare(Childcare childcare) {
        return childcareRepository.save(childcare);
    }

    // Update an existing childcare record
    public Childcare updateChildcare(UUID id, Childcare updatedChildcare) {

        Childcare existing = getChildcare(id);

        existing.setName(updatedChildcare.getName());
        existing.setAmount(updatedChildcare.getAmount());
        existing.setDatePaid(updatedChildcare.getDatePaid());
        existing.setFrequency(updatedChildcare.getFrequency());

        return childcareRepository.save(existing);
    }

    // Delete a childcare record
    public void deleteChildcare(UUID id) {
        childcareRepository.deleteById(id);
    }
}