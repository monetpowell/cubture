import "./savings-form.css";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

import { createSavings, getSaving, updateSavings } from "./api";

export default function SavingsForm() {
  const navigate = useNavigate();
  const { id } = useParams();

  const [goalName, setGoalName] = useState("");
  const [savedAmount, setSavedAmount] = useState("");
  const [targetAmount, setTargetAmount] = useState("");
  const [targetDate, setTargetDate] = useState("");

  useEffect(() => {
    async function loadSavings() {
      if (!id) {
        return;
      }

      const savings = await getSaving(id);

      setGoalName(savings.goalName);
      setSavedAmount(savings.savedAmount.toString());
      setTargetAmount(savings.targetAmount.toString());
      setTargetDate(savings.targetDate);
    }

    loadSavings();
  }, [id]);

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    const savings = {
      goalName,
      savedAmount: Number(savedAmount),
      targetAmount: Number(targetAmount),
      targetDate,
    };

    if (id) {
      await updateSavings(id, savings);
    } else {
      await createSavings(savings);
    }

    navigate("/savings");
  }

  return (
    <div className="form-card">
      <h1>{id ? "Edit Savings Goal" : "Add Savings Goal"}</h1>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="goalName">Goal Name</label>
          <input
            id="goalName"
            value={goalName}
            onChange={(e) => setGoalName(e.target.value)}
            placeholder="e.g. Family Holiday"
            minLength={2}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="savedAmount">Saved Amount (£)</label>
          <input
            id="savedAmount"
            type="number"
            value={savedAmount}
            onChange={(e) => setSavedAmount(e.target.value)}
            min="0"
            step="0.01"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="targetAmount">Target Amount (£)</label>
          <input
            id="targetAmount"
            type="number"
            value={targetAmount}
            onChange={(e) => setTargetAmount(e.target.value)}
            min="0.01"
            step="0.01"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="targetDate">Target Date</label>
          <input
            id="targetDate"
            type="date"
            value={targetDate}
            onChange={(e) => setTargetDate(e.target.value)}
            required
          />
        </div>

        <button type="submit" className="submit-btn">
          {id ? "Update Savings Goal" : "Save Savings Goal"}
        </button>
      </form>
    </div>
  );
}
