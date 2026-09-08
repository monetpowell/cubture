import "./dashboard.css";

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import Layout from "../../components/layout/layout";
import SummaryCard from "../../components/summary-card/summary-card";
import MonthSelector from "../../components/month-selector/month-selector";

import moneyIcon from "../../assets/money.png";
import creditCardIcon from "../../assets/credit-card.png";
import childrenIcon from "../../assets/children.png";
import piggyBankIcon from "../../assets/piggy-bank.png";

import { getDashboardSummary } from "./api";
import type { DashboardSummary } from "./dashboard-summary";

export default function Dashboard() {
  const today = new Date();

  const [selectedMonth, setSelectedMonth] = useState(today.getMonth() + 1);
  const [selectedYear] = useState(today.getFullYear());

  const [summary, setSummary] = useState<DashboardSummary | null>(null);

  useEffect(() => {
    async function fetchSummary() {
      const data = await getDashboardSummary(selectedMonth, selectedYear);
      setSummary(data);
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

        <MonthSelector
          selectedMonth={selectedMonth}
          selectedYear={selectedYear}
          onMonthChange={setSelectedMonth}
        />

        <p>
          Here's your overview for {monthNames[selectedMonth - 1]}{" "}
          {selectedYear}
        </p>

        <div className="summary-cards">
          <Link to="/income" className="summary-link">
            <SummaryCard
              icon={<img src={moneyIcon} alt="Income" />}
              title="Income"
              subtitle="This month"
              value={formatMoney(summary.totalIncome)}
            />
          </Link>

          <Link to="/expenses" className="summary-link">
            <SummaryCard
              icon={<img src={creditCardIcon} alt="Expenses" />}
              title="Expenses"
              subtitle="This month"
              value={formatMoney(summary.totalExpenses)}
            />
          </Link>

          <Link to="/childcare" className="summary-link">
            <SummaryCard
              icon={<img src={childrenIcon} alt="Childcare" />}
              title="Childcare"
              subtitle="This month"
              value={formatMoney(summary.totalChildcare)}
            />
          </Link>

          <Link to="/savings" className="summary-link">
            <SummaryCard
              icon={<img src={piggyBankIcon} alt="Money Left" />}
              title="Remaining"
              subtitle="Available to use"
              value={formatMoney(summary.moneyLeft)}
              highlight
            />
          </Link>
        </div>
      </div>
    </Layout>
  );
}
