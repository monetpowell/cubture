import "./savings-card.css";

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import type { Savings } from "./savings";
import { deleteSavings, getSavings } from "./api";

export default function SavingsList() {
  const [savings, setSavings] = useState<Savings[]>([]);

  useEffect(() => {
    async function fetchSavings() {
      const data = await getSavings();
      setSavings(data);
    }

    fetchSavings();
  }, []);

  async function handleDelete(id: string) {
    if (!window.confirm("Delete this savings goal?")) {
      return;
    }

    await deleteSavings(id);

    const updated = await getSavings();
    setSavings(updated);
  }

  if (savings.length === 0) {
    return <p className="empty-message">No savings goals yet.</p>;
  }

  return (
    <div className="savings-list">
      {savings.map((goal) => {
        const progress = Math.min(
          (goal.savedAmount / goal.targetAmount) * 100,
          100,
        );

        return (
          <div className="saving-card" key={goal.id}>
            <h2>{goal.goalName}</h2>

            <div className="progress-bar">
              <div
                className="progress-fill"
                style={{ width: `${progress}%` }}
              ></div>
            </div>

            <p className="progress-text">{progress.toFixed(0)}% Complete</p>

            <div className="saving-details">
              <div>
                <span>Saved</span>
                <strong>
                  £{Number(goal.savedAmount).toLocaleString("en-GB")}
                </strong>
              </div>

              <div>
                <span>Target</span>
                <strong>
                  £{Number(goal.targetAmount).toLocaleString("en-GB")}
                </strong>
              </div>

              <div>
                <span>Target Date</span>
                <strong>
                  {new Date(goal.targetDate).toLocaleDateString("en-GB", {
                    month: "short",
                    year: "numeric",
                  })}
                </strong>
              </div>
            </div>

            <div className="saving-actions">
              <Link to={`/savings/${goal.id}/edit`}>
                <button type="button">Edit</button>
              </Link>

              <button type="button" onClick={() => handleDelete(goal.id!)}>
                Delete
              </button>
            </div>
          </div>
        );
      })}
    </div>
  );
}
