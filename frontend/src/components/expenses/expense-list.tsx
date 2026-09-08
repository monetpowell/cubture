import "./expense-list.css";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import type { Expense } from "./expense";
import { deleteExpense, getExpenses } from "./api";

export default function ExpenseList() {
  const [expenses, setExpenses] = useState<Expense[]>([]);
  const today = new Date();

  const [selectedMonth, setSelectedMonth] = useState(today.getMonth() + 1);

  const [selectedYear] = useState(today.getFullYear());

  useEffect(() => {
    const fetchExpenses = async () => {
      const data = await getExpenses(selectedMonth, selectedYear);
      setExpenses(data);
    };

    fetchExpenses();
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

  async function handleDelete(id: string) {
    if (!window.confirm("Delete this expense?")) {
      return;
    }

    await deleteExpense(id);

    const updated = await getExpenses(selectedMonth, selectedYear);
    setExpenses(updated);
  }

  return (
    <div className="expenses-page">
      <div className="expenses-header">
        <h1>Manage Expenses</h1>
        <p>Track your household spending and stay on top of your budget.</p>
      </div>

      <div className="expense-actions">
        <Link to="/expenses/new" className="add-expense-button">
          + Add Expense
        </Link>
      </div>
      <div className="dashboard-month-selector">
        <label htmlFor="month">Viewing:</label>

        <select
          id="month"
          value={selectedMonth}
          onChange={(event) => setSelectedMonth(Number(event.target.value))}
        >
          {monthNames.map((month, index) => (
            <option key={month} value={index + 1}>
              {month} {selectedYear}
            </option>
          ))}
        </select>
      </div>
      {expenses.length === 0 ? (
        <p className="no-expenses">No expenses added yet.</p>
      ) : (
        <div className="expense-table-wrapper">
          <table className="expense-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Amount</th>
                <th>Date Paid</th>
                <th>Frequency</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
              {expenses.map((expense) => (
                <tr key={expense.id}>
                  <td>{expense.name}</td>
                  <td>
                    {Number(expense.amount).toLocaleString("en-GB", {
                      style: "currency",
                      currency: "GBP",
                    })}
                  </td>
                  <td>{expense.datePaid}</td>
                  <td>{expense.frequency}</td>
                  <td>
                    <Link to={`/expenses/${expense.id}/edit`}>
                      <button>Edit</button>
                    </Link>

                    <button onClick={() => handleDelete(expense.id!)}>
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
