package com.cubture.backend.dashboard;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.cubture.backend.childcare.Childcare;
import com.cubture.backend.childcare.ChildcareRepository;
import com.cubture.backend.expense.Expense;
import com.cubture.backend.expense.ExpenseRepository;
import com.cubture.backend.income.Income;
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

                BigDecimal totalIncome = BigDecimal.ZERO;

                for (Income income : incomeRepository.findAll()) {
                        if (income.getDateReceived().getMonthValue() == month
                                        && income.getDateReceived().getYear() == year) {
                                totalIncome = totalIncome.add(income.getAmount());
                        }
                }

                BigDecimal totalExpenses = BigDecimal.ZERO;

                for (Expense expense : expenseRepository.findAll()) {
                        if (expense.getDatePaid().getMonthValue() == month
                                        && expense.getDatePaid().getYear() == year) {
                                totalExpenses = totalExpenses.add(expense.getAmount());
                        }
                }

                BigDecimal totalChildcare = BigDecimal.ZERO;

                for (Childcare childcare : childcareRepository.findAll()) {
                        if (childcare.getDatePaid().getMonthValue() == month
                                        && childcare.getDatePaid().getYear() == year) {
                                totalChildcare = totalChildcare.add(childcare.getAmount());
                        }
                }

                BigDecimal moneyLeft = totalIncome
                                .subtract(totalExpenses)
                                .subtract(totalChildcare);

                int previousMonth;
                int previousYear;

                if (month == 1) {
                        previousMonth = 12;
                        previousYear = year - 1;
                } else {
                        previousMonth = month - 1;
                        previousYear = year;
                }

                BigDecimal previousIncome = BigDecimal.ZERO;

                for (Income income : incomeRepository.findAll()) {
                        if (income.getDateReceived().getMonthValue() == previousMonth
                                        && income.getDateReceived().getYear() == previousYear) {
                                previousIncome = previousIncome.add(income.getAmount());
                        }
                }

                BigDecimal previousExpenses = BigDecimal.ZERO;

                for (Expense expense : expenseRepository.findAll()) {
                        if (expense.getDatePaid().getMonthValue() == previousMonth
                                        && expense.getDatePaid().getYear() == previousYear) {
                                previousExpenses = previousExpenses.add(expense.getAmount());
                        }
                }

                BigDecimal previousChildcare = BigDecimal.ZERO;

                for (Childcare childcare : childcareRepository.findAll()) {
                        if (childcare.getDatePaid().getMonthValue() == previousMonth
                                        && childcare.getDatePaid().getYear() == previousYear) {
                                previousChildcare = previousChildcare.add(childcare.getAmount());
                        }
                }

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