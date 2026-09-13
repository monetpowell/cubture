import "./expense-table.css";

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import type { Expense } from "./expense";
import { deleteExpense, getExpenses } from "./api";
import MonthSelector from "../month-selector/month-selector";

export default function ExpenseList() {
  const today = new Date();

  const [selectedMonth, setSelectedMonth] = useState(today.getMonth() + 1);
  const [selectedYear] = useState(today.getFullYear());

  const [expenses, setExpenses] = useState<Expense[]>([]);

  useEffect(() => {
    async function fetchExpenses() {
      const data = await getExpenses(selectedMonth, selectedYear);
      setExpenses(data);
    }

    fetchExpenses();
  }, [selectedMonth, selectedYear]);

  async function handleDelete(id: string) {
    if (!window.confirm("Delete this expense?")) {
      return;
    }

    await deleteExpense(id);

    const updated = await getExpenses(selectedMonth, selectedYear);
    setExpenses(updated);
  }

  return (
    <>
      <MonthSelector
        selectedMonth={selectedMonth}
        selectedYear={selectedYear}
        onMonthChange={setSelectedMonth}
      />

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
                      <button type="button">Edit</button>
                    </Link>

                    <button
                      type="button"
                      onClick={() => handleDelete(expense.id!)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </>
  );
}
