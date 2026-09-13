import "./childcare-form.css";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

import type { ChildcareFrequency } from "./childcare-frequency";
import { createChildcare, getChildcareItem, updateChildcare } from "./api";

export default function ChildcareForm() {
  const navigate = useNavigate();
  const { id } = useParams();

  const [name, setName] = useState("");
  const [amount, setAmount] = useState("");
  const [datePaid, setDatePaid] = useState("");
  const [frequency, setFrequency] = useState<ChildcareFrequency>("MONTHLY");

  useEffect(() => {
    async function loadChildcare() {
      if (!id) {
        return;
      }

      const childcare = await getChildcareItem(id);

      setName(childcare.name);
      setAmount(childcare.amount.toString());
      setDatePaid(childcare.datePaid);
      setFrequency(childcare.frequency);
    }

    loadChildcare();
  }, [id]);

  async function handleSubmit(e: React.SyntheticEvent<HTMLFormElement>) {
    e.preventDefault();

    if (id) {
      await updateChildcare(id, {
        name,
        amount: Number(amount),
        datePaid,
        frequency,
      });
    } else {
      await createChildcare({
        name,
        amount: Number(amount),
        datePaid,
        frequency,
      });
    }

    navigate("/childcare");
  }

  return (
    <div className="childcare-form-header">
      <h1>{id ? "Edit Childcare" : "Add Childcare"}</h1>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Name</label>

          <input
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="e.g. Nursery Fees"
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
          <label>Date Paid</label>

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
            onChange={(e) => setFrequency(e.target.value as ChildcareFrequency)}
          >
            <option value="WEEKLY">Weekly</option>
            <option value="FORTNIGHTLY">Fortnightly</option>
            <option value="MONTHLY">Monthly</option>
            <option value="ANNUALLY">Annually</option>
            <option value="ONE_OFF">One off</option>
          </select>
        </div>

        <button type="submit" className="submit-btn">
          {id ? "Update Childcare" : "Save Childcare"}
        </button>
      </form>
    </div>
  );
}
