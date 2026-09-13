import "./income-list.css";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getIncomes, deleteIncome } from "./api";
import type { Income } from "./income";
import MonthSelector from "../month-selector/month-selector";

export default function IncomeList() {
  const navigate = useNavigate();

  const today = new Date();

  const [selectedMonth, setSelectedMonth] = useState(today.getMonth() + 1);
  const [selectedYear] = useState(today.getFullYear());

  const [incomes, setIncomes] = useState<Income[]>([]);

  useEffect(() => {
    async function fetchIncomes() {
      const data = await getIncomes(selectedMonth, selectedYear);
      setIncomes(data);
    }

    fetchIncomes();
  }, [selectedMonth, selectedYear]);

  async function handleDelete(id: string) {
    if (!window.confirm("Delete this income?")) {
      return;
    }

    await deleteIncome(id);

    const updated = await getIncomes(selectedMonth, selectedYear);
    setIncomes(updated);
  }

  return (
    <>
      <MonthSelector
        selectedMonth={selectedMonth}
        selectedYear={selectedYear}
        onMonthChange={setSelectedMonth}
      />

      {incomes.length === 0 ? (
        <p>No income added yet.</p>
      ) : (
        <table className="income-table">
          <thead>
            <tr>
              <th>Source</th>
              <th>Amount</th>
              <th>Date received</th>
              <th>Frequency</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            {incomes.map((income) => (
              <tr key={income.id}>
                <td>{income.source}</td>
                <td>
                  {Number(income.amount).toLocaleString("en-GB", {
                    style: "currency",
                    currency: "GBP",
                  })}
                </td>
                <td>{income.dateReceived}</td>
                <td>{income.frequency}</td>
                <td>
                  <button onClick={() => navigate(`/income/${income.id}/edit`)}>
                    Edit
                  </button>

                  <button onClick={() => handleDelete(income.id!)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </>
  );
}
