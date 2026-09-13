import "./dashboard.css";

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import Layout from "../../components/layout/layout";
import SummaryCard from "../../components/summary-card/summary-card";
import MonthSelector from "../../components/month-selector/month-selector";
import DashboardChart from "../../components/dashboard-chart/dashboard-chart";
import SavingsSlider from "../../components/savings-slider/savings-slider";

import moneyIcon from "../../assets/money.png";
import creditCardIcon from "../../assets/credit-card.png";
import childrenIcon from "../../assets/children.png";
import piggyBankIcon from "../../assets/piggy-bank.png";

import { getDashboardSummary } from "./api";
import type { DashboardSummary } from "./dashboard-summary";
import DashboardActivities from "../../components/dashboard-activities/dashboard-activities";

export default function Dashboard() {
  const today = new Date();

  const [selectedMonth, setSelectedMonth] = useState(today.getMonth() + 1);
  const [selectedYear] = useState(today.getFullYear());

  const [summary, setSummary] = useState<DashboardSummary | null>(null);
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchSummary() {
      try {
        const data = await getDashboardSummary(selectedMonth, selectedYear);
        setSummary(data);
      } catch {
        setError(
          "Unable to load your dashboard. Please check your connection and try again.",
        );
      }
    }

    fetchSummary();
  }, [selectedMonth, selectedYear]);

  const monthNames = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  ];

  function formatMoney(amount: number) {
    return amount.toLocaleString("en-GB", {
      style: "currency",
      currency: "GBP",
    });
  }

  if (error) {
    return (
      <Layout>
        <p className="dashboard-error">{error}</p>
      </Layout>
    );
  }

  if (!summary) {
    return (
      <Layout>
        <p>Loading dashboard...</p>
      </Layout>
    );
  }

  return (
    <Layout>
      <div className="dashboard-content">
        <h1>Hello Tanya 👋</h1>
        <p>
          Here's your overview for {monthNames[selectedMonth - 1]}{" "}
          {selectedYear}
        </p>
        <MonthSelector
          selectedMonth={selectedMonth}
          selectedYear={selectedYear}
          onMonthChange={setSelectedMonth}
        />
        <div className="summary-cards">
          <Link to="/income" className="summary-link">
            <SummaryCard
              icon={<img src={moneyIcon} alt="Income" />}
              title="Income"
              subtitle="This month"
              value={formatMoney(summary.totalIncome)}
              trend={summary.incomeTrend}
            />
          </Link>

          <Link to="/expenses" className="summary-link">
            <SummaryCard
              icon={<img src={creditCardIcon} alt="Expenses" />}
              title="Expenses"
              subtitle="This month"
              value={formatMoney(summary.totalExpenses)}
              trend={summary.expenseTrend}
            />
          </Link>

          <Link to="/childcare" className="summary-link">
            <SummaryCard
              icon={<img src={childrenIcon} alt="Childcare" />}
              title="Childcare"
              subtitle="This month"
              value={formatMoney(summary.totalChildcare)}
              trend={summary.childcareTrend}
            />
          </Link>

          <Link to="/savings" className="summary-link">
            <SummaryCard
              icon={<img src={piggyBankIcon} alt="Remaining" />}
              title="Remaining"
              subtitle="Available to use"
              value={formatMoney(summary.moneyLeft)}
              highlight
              trend={summary.remainingTrend}
            />
          </Link>
        </div>

        <div className="dashboard-middle">
          <DashboardChart
            income={summary.totalIncome}
            expenses={summary.totalExpenses}
            childcare={summary.totalChildcare}
            remaining={summary.moneyLeft}
          />

          <SavingsSlider
            key={`${selectedMonth}-${selectedYear}`}
            income={summary.totalIncome}
            remaining={summary.moneyLeft}
          />
        </div>

        <DashboardActivities budget={summary.moneyLeft} />
      </div>
    </Layout>
  );
}
