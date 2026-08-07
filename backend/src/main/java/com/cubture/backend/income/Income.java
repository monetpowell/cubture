package com.cubture.backend.income;

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

// The @Entity annotation declares that a class to be mapped to a database table.

// The @Table annotation is used to specify the name of the database table the entity class should be mapped to.
// The @Id annotation sets which field represents the primary key of the mapped table.
// The @GeneratedValue annotation indicates how key values are generated.

//Create an income entity class that maps to the "income" table
@Entity
@Table(name = "income")

public class Income {
    // Ensure the id field is set as the primary key and values are generated using
    // the appropriate strategy for a UUID field

    // tells JPA that id is the primary key
    @Id

    // @GeneratedValue tells JPA to generate the value automatically
    // GenerationType.UUID tells Hibernate to generate a UUID
    // Unique identifier for each income record
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Where the income came from (Salary, Benefits etc.)
    private String source;

    // Amount received
    private BigDecimal amount;

    // Date the income was received
    private LocalDate dateReceived;

    // Frequency of the income (e.g. WEEKLY, MONTHLY).
    // @Enumerated(EnumType.STRING) tells JPA to store the enum as its name
    // (e.g. "MONTHLY") rather than its numeric position (e.g. 2), making
    // the database easier to read and safer if the enum order changes.
    @Enumerated(EnumType.STRING)
    private IncomeFrequency frequency;

    // Define parameterised constructor
    public Income(String source, BigDecimal amount, LocalDate dateReceived, IncomeFrequency frequency) {
        this.source = source;
        this.amount = amount;
        this.dateReceived = dateReceived;
        this.frequency = frequency;
    }

    // Default (no-argument) constructor required by JPA
    // Hibernate uses this constructor when creating an Income object from the
    // database
    // Rather than duplicating the field initialisation, it calls the parameterised
    // constructor using the `this(...)` keyword
    // This is called constructor chaining
    // Helps avoid repeating the same initialisation code
    public Income() {
        this("", BigDecimal.ZERO, LocalDate.now(), IncomeFrequency.MONTHLY);
    }

    // Create getter and setter methods for each field,
    // except id, which should only have a getter

    public UUID getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public IncomeFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(IncomeFrequency frequency) {
        this.frequency = frequency;
    }
}
