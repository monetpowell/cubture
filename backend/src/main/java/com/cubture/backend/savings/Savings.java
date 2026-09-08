package com.cubture.backend.savings;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "savings")
public class Savings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String goalName;

    private BigDecimal savedAmount;

    private BigDecimal targetAmount;

    private LocalDate targetDate;

    public Savings(
            String goalName,
            BigDecimal savedAmount,
            BigDecimal targetAmount,
            LocalDate targetDate) {

        this.goalName = goalName;
        this.savedAmount = savedAmount;
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
    }

    public Savings() {
        this("", BigDecimal.ZERO, BigDecimal.ZERO, LocalDate.now());
    }

    public UUID getId() {
        return id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public BigDecimal getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(BigDecimal savedAmount) {
        this.savedAmount = savedAmount;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}