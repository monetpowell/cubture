package com.cubture.backend.expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Represents an expense stored in the database.
@Entity
@Table(name = "expense")
public class Expense {

    // Primary key generated as a UUID.
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Name of the expense.
    private String name;

    // Amount paid.
    private BigDecimal amount;

    // Date the expense was paid.
    private LocalDate datePaid;

    // Frequency of the expense.
    @Enumerated(EnumType.STRING)
    private ExpenseFrequency frequency;

    // Parameterised constructor.
    public Expense(
            String name,
            BigDecimal amount,
            LocalDate datePaid,
            ExpenseFrequency frequency) {

        this.name = name;
        this.amount = amount;
        this.datePaid = datePaid;
        this.frequency = frequency;
    }

    // Default constructor required by JPA.
    public Expense() {
        this("", BigDecimal.ZERO, LocalDate.now(), ExpenseFrequency.MONTHLY);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    public ExpenseFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(ExpenseFrequency frequency) {
        this.frequency = frequency;
    }
}