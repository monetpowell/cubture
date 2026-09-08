package com.cubture.backend.dashboard;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.cubture.backend.childcare.ChildcareRepository;
import com.cubture.backend.expense.ExpenseRepository;
import com.cubture.backend.income.IncomeRepository;

@Service
public class DashboardService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final ChildcareRepository childcareRepository;

    public DashboardService(
            IncomeRepository incomeRepository,
            ExpenseRepository expenseRepository,
            ChildcareRepository childcareRepository) {

        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.childcareRepository = childcareRepository;
    }

    public DashboardSummary getSummary(int month, int year) {

        BigDecimal totalIncome = incomeRepository.findAll()
                .stream()
                .filter(income -> income.getDateReceived().getMonthValue() == month
                        && income.getDateReceived().getYear() == year)
                .map(income -> income.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpenses = expenseRepository.findAll()
                .stream()
                .filter(expense -> expense.getDatePaid().getMonthValue() == month
                        && expense.getDatePaid().getYear() == year)
                .map(expense -> expense.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalChildcare = childcareRepository.findAll()
                .stream()
                .filter(childcare -> childcare.getDatePaid().getMonthValue() == month
                        && childcare.getDatePaid().getYear() == year)
                .map(childcare -> childcare.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal moneyLeft = totalIncome
                .subtract(totalExpenses)
                .subtract(totalChildcare);

        return new DashboardSummary(
                totalIncome,
                totalExpenses,
                totalChildcare,
                moneyLeft);
    }
}