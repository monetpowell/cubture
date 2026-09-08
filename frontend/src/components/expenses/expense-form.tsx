import "./expense-form.css";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import type { ExpenseFrequency } from "./expense-frequency";
import { createExpense, getExpense, updateExpense } from "./api";

export default function ExpenseForm() {
  const navigate = useNavigate();
  const { id } = useParams();

  const [name, setName] = useState("");
  const [amount, setAmount] = useState("");
  const [datePaid, setDatePaid] = useState("");
  const [frequency, setFrequency] = useState<ExpenseFrequency>("MONTHLY");

  useEffect(() => {
    async function loadExpense() {
      if (!id) {
        return;
      }

      const expense = await getExpense(id);

      setName(expense.name);
      setAmount(expense.amount.toString());
      setDatePaid(expense.datePaid);
      setFrequency(expense.frequency);
    }

    loadExpense();
  }, [id]);

  async function handleSubmit(e: React.SyntheticEvent<HTMLFormElement>) {
    e.preventDefault();

    if (id) {
      await updateExpense(id, {
        name,
        amount: Number(amount),
        datePaid,
        frequency,
      });
    } else {
      await createExpense({
        name,
        amount: Number(amount),
        datePaid,
        frequency,
      });
    }

    navigate("/expenses");
  }

  return (
    <div className="expense-card">
      <h1>{id ? "Edit Expense" : "Add Expense"}</h1>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Name</label>

          <input
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="e.g. Rent"
            required
          />
        </div>

        <div className="form-group">
          <label>Amount</label>

          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label>Date paid</label>

          <input
            type="date"
            value={datePaid}
            onChange={(e) => setDatePaid(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label>Frequency</label>

          <select
            value={frequency}
            onChange={(e) => setFrequency(e.target.value as ExpenseFrequency)}
          >
            <option value="WEEKLY">Weekly</option>
            <option value="FORTNIGHTLY">Fortnightly</option>
            <option value="MONTHLY">Monthly</option>
            <option value="ANNUALLY">Annually</option>
            <option value="ONE_OFF">One off</option>
          </select>
        </div>

        <button type="submit" className="button">
          Save Expense
        </button>
      </form>
    </div>
  );
}
