package com.cubture.backend.dashboard;

import java.math.BigDecimal;

public class DashboardSummary {

    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;
    private BigDecimal totalChildcare;
    private BigDecimal moneyLeft;

    public DashboardSummary(
            BigDecimal totalIncome,
            BigDecimal totalExpenses,
            BigDecimal totalChildcare,
            BigDecimal moneyLeft) {

        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.totalChildcare = totalChildcare;
        this.moneyLeft = moneyLeft;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public BigDecimal getTotalChildcare() {
        return totalChildcare;
    }

    public BigDecimal getMoneyLeft() {
        return moneyLeft;
    }
}