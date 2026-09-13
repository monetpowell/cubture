import "./income-form.css";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

import { createIncome, getIncome, updateIncome } from "./api";
import { IncomeFrequency } from "./income-frequency";

export default function IncomeForm() {
  const navigate = useNavigate();

  // Reads the income ID from the URL parameters.
  // If no ID is present, we are creating a new income entry.
  const { id } = useParams();

  const [source, setSource] = useState("");
  const [amount, setAmount] = useState("");
  const [dateReceived, setDateReceived] = useState("");
  const [frequency, setFrequency] = useState<IncomeFrequency>("MONTHLY");

  // If an ID exists, load the income so the form is pre-filled.
  useEffect(() => {
    async function loadIncome() {
      if (!id) {
        return;
      }

      try {
        const income = await getIncome(id);

        setSource(income.source);
        setAmount(income.amount.toString());
        setDateReceived(income.dateReceived);
        setFrequency(income.frequency);
      } catch (error) {
        console.error("Failed to load income", error);
        alert("Failed to load income.");
      }
    }

    loadIncome();
  }, [id]);

  async function handleSubmit(e: React.SyntheticEvent<HTMLFormElement>) {
    e.preventDefault();

    try {
      if (id) {
        await updateIncome(id, {
          source,
          amount: Number(amount),
          dateReceived,
          frequency,
        });
      } else {
        await createIncome({
          source,
          amount: Number(amount),
          dateReceived,
          frequency,
        });
      }

      navigate("/income");
    } catch (error) {
      console.error("Failed to save income", error);
      alert("Failed to save income. Please try again.");
    }
  }

  return (
    <div className="income-card">
      <h1>{id ? "Edit Income" : "Add Income"}</h1>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="source">Source</label>
          <input
            id="source"
            value={source}
            onChange={(e) => setSource(e.target.value)}
            placeholder="e.g. Salary"
            minLength={2}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="amount">Amount</label>
          <input
            id="amount"
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            placeholder="e.g. 2500"
            min="0.01"
            step="0.01"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="dateReceived">Date received</label>
          <input
            id="dateReceived"
            type="date"
            value={dateReceived}
            onChange={(e) => setDateReceived(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="frequency">Frequency</label>
          <select
            id="frequency"
            value={frequency}
            onChange={(e) => setFrequency(e.target.value as IncomeFrequency)}
          >
            <option value="WEEKLY">Weekly</option>
            <option value="FORTNIGHTLY">Fortnightly</option>
            <option value="MONTHLY">Monthly</option>
            <option value="ANNUALLY">Annually</option>
            <option value="ONE_OFF">One off</option>
          </select>
        </div>

        <button type="submit" className="submit-btn">
          {id ? "Update Income" : "Save Income"}
        </button>
      </form>
    </div>
  );
}
