package com.cubture.backend.savings;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class SavingsService {

    private final SavingsRepository savingsRepository;

    public SavingsService(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    public List<Savings> getAllSavings() {
        return savingsRepository.findAll();
    }

    public Savings getSavings(UUID id) {
        return savingsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Savings goal not found"));
    }

    public Savings createSavings(Savings savings) {
        return savingsRepository.save(savings);
    }

    public Savings updateSavings(UUID id, Savings updatedSavings) {

        Savings existing = getSavings(id);

        existing.setGoalName(updatedSavings.getGoalName());
        existing.setSavedAmount(updatedSavings.getSavedAmount());
        existing.setTargetAmount(updatedSavings.getTargetAmount());
        existing.setTargetDate(updatedSavings.getTargetDate());

        return savingsRepository.save(existing);
    }

    public void deleteSavings(UUID id) {
        savingsRepository.deleteById(id);
    }
}