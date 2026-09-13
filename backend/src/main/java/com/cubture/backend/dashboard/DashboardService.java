package com.cubture.backend.dashboard;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

        int previousMonth = month == 1 ? 12 : month - 1;
        int previousYear = month == 1 ? year - 1 : year;

        BigDecimal previousIncome = incomeRepository.findAll()
                .stream()
                .filter(income -> income.getDateReceived().getMonthValue() == previousMonth
                        && income.getDateReceived().getYear() == previousYear)
                .map(income -> income.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal previousExpenses = expenseRepository.findAll()
                .stream()
                .filter(expense -> expense.getDatePaid().getMonthValue() == previousMonth
                        && expense.getDatePaid().getYear() == previousYear)
                .map(expense -> expense.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal previousChildcare = childcareRepository.findAll()
                .stream()
                .filter(childcare -> childcare.getDatePaid().getMonthValue() == previousMonth
                        && childcare.getDatePaid().getYear() == previousYear)
                .map(childcare -> childcare.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal previousMoneyLeft = previousIncome
                .subtract(previousExpenses)
                .subtract(previousChildcare);

        return new DashboardSummary(
                totalIncome,
                totalExpenses,
                totalChildcare,
                moneyLeft,
                calculateTrend(totalIncome, previousIncome),
                calculateTrend(totalExpenses, previousExpenses),
                calculateTrend(totalChildcare, previousChildcare),
                calculateTrend(moneyLeft, previousMoneyLeft));
    }

    private double calculateTrend(BigDecimal current, BigDecimal previous) {

        if (previous.compareTo(BigDecimal.ZERO) == 0) {

            if (current.compareTo(BigDecimal.ZERO) == 0) {
                return 0;
            }

            return 100;
        }

        return current
                .subtract(previous)
                .divide(previous, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }
}