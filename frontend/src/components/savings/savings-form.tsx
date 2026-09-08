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
          <label>Goal Name</label>

          <input
            value={goalName}
            onChange={(e) => setGoalName(e.target.value)}
            placeholder="e.g. Family Holiday"
            required
          />
        </div>

        <div className="form-group">
          <label>Saved Amount (£)</label>

          <input
            type="number"
            value={savedAmount}
            onChange={(e) => setSavedAmount(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label>Target Amount (£)</label>

          <input
            type="number"
            value={targetAmount}
            onChange={(e) => setTargetAmount(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label>Target Date</label>

          <input
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