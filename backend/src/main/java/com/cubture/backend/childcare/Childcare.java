package com.cubture.backend.childcare;

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

@Entity
@Table(name = "childcare")
public class Childcare {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private BigDecimal amount;

    private LocalDate datePaid;

    @Enumerated(EnumType.STRING)
    private ChildcareFrequency frequency;

    public Childcare(
            String name,
            BigDecimal amount,
            LocalDate datePaid,
            ChildcareFrequency frequency) {

        this.name = name;
        this.amount = amount;
        this.datePaid = datePaid;
        this.frequency = frequency;
    }

    public Childcare() {
        this("", BigDecimal.ZERO, LocalDate.now(), ChildcareFrequency.MONTHLY);
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

    public ChildcareFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(ChildcareFrequency frequency) {
        this.frequency = frequency;
    }
}