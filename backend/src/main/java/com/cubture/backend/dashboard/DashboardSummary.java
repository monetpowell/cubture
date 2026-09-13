package com.cubture.backend.dashboard;

import java.math.BigDecimal;

public class DashboardSummary {

    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;
    private BigDecimal totalChildcare;
    private BigDecimal moneyLeft;

    private double incomeTrend;
    private double expenseTrend;
    private double childcareTrend;
    private double remainingTrend;

    public DashboardSummary(
            BigDecimal totalIncome,
            BigDecimal totalExpenses,
            BigDecimal totalChildcare,
            BigDecimal moneyLeft,
            double incomeTrend,
            double expenseTrend,
            double childcareTrend,
            double remainingTrend) {

        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.totalChildcare = totalChildcare;
        this.moneyLeft = moneyLeft;

        this.incomeTrend = incomeTrend;
        this.expenseTrend = expenseTrend;
        this.childcareTrend = childcareTrend;
        this.remainingTrend = remainingTrend;
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

    public double getIncomeTrend() {
        return incomeTrend;
    }

    public double getExpenseTrend() {
        return expenseTrend;
    }

    public double getChildcareTrend() {
        return childcareTrend;
    }

    public double getRemainingTrend() {
        return remainingTrend;
    }
}