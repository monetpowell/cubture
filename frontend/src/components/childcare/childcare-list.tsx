import "./childcare-list.css";

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import type { Childcare } from "./childcare";
import { deleteChildcare, getChildcare } from "./api";

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
    if (!window.confirm("Delete this childcare record?")) {
      return;
    }

    await deleteChildcare(id);

    const updated = await getChildcare(selectedMonth, selectedYear);
    setChildcare(updated);
  }

  if (childcare.length === 0) {
    return (
      <>
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

        <p>No childcare costs added yet.</p>
      </>
    );
  }

  return (
    <>
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
                  <button>Edit</button>
                </Link>

                <button onClick={() => handleDelete(entry.id!)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}
