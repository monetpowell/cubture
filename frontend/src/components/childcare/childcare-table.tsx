import "./childcare-table.css";

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import type { Childcare } from "./childcare";
import { deleteChildcare, getChildcare } from "./api";
import MonthSelector from "../month-selector/month-selector";

export default function ChildcareList() {
  const today = new Date();

  const [selectedMonth, setSelectedMonth] = useState(today.getMonth() + 1);
  const [selectedYear] = useState(today.getFullYear());

  const [childcare, setChildcare] = useState<Childcare[]>([]);

  useEffect(() => {
    async function fetchChildcare() {
      const data = await getChildcare(selectedMonth, selectedYear);
      setChildcare(data);
    }

    fetchChildcare();
  }, [selectedMonth, selectedYear]);

  async function handleDelete(id: string) {
    if (!window.confirm("Delete this childcare record?")) {
      return;
    }

    await deleteChildcare(id);

    const updated = await getChildcare(selectedMonth, selectedYear);
    setChildcare(updated);
  }

  return (
    <>
      <MonthSelector
        selectedMonth={selectedMonth}
        selectedYear={selectedYear}
        onMonthChange={setSelectedMonth}
      />

      {childcare.length === 0 ? (
        <p className="no-childcare">No childcare costs added yet.</p>
      ) : (
        <div className="childcare-table-wrapper">
          <table className="childcare-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Frequency</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
              {childcare.map((entry) => (
                <tr key={entry.id}>
                  <td>{entry.name}</td>

                  <td>
                    {Number(entry.amount).toLocaleString("en-GB", {
                      style: "currency",
                      currency: "GBP",
                    })}
                  </td>

                  <td>{entry.datePaid}</td>

                  <td>{entry.frequency}</td>

                  <td>
                    <Link to={`/childcare/${entry.id}/edit`}>
                      <button type="button">Edit</button>
                    </Link>

                    <button
                      type="button"
                      onClick={() => handleDelete(entry.id!)}
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
