package com.cubture.backend.savings;

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

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/savings")
public class SavingsController {

    private final SavingsService savingsService;

    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }

    @GetMapping
    public List<Savings> getAllSavings() {
        return savingsService.getAllSavings();
    }

    @GetMapping("/{id}")
    public Savings getSavings(@PathVariable UUID id) {

        try {
            return savingsService.getSavings(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Savings goal not found",
                    exception);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Savings createSavings(@RequestBody Savings savings) {
        return savingsService.createSavings(savings);
    }

    @PutMapping("/{id}")
    public Savings updateSavings(
            @PathVariable UUID id,
            @RequestBody Savings updatedSavings) {

        try {
            return savingsService.updateSavings(id, updatedSavings);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Savings goal not found",
                    exception);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSavings(@PathVariable UUID id) {

        try {
            savingsService.deleteSavings(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Savings goal not found",
                    exception);
        }
    }
}