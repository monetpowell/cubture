import "./savings-slider.css";
import { useState } from "react";

interface SavingsSliderProps {
  income: number;
  remaining: number;
}

export default function SavingsSlider({ remaining }: SavingsSliderProps) {
  const [percentage, setPercentage] = useState(0);

  const savedAmount = (remaining * percentage) / 100;
  const availableForActivities = remaining - savedAmount;

  function formatMoney(amount: number) {
    return amount.toLocaleString("en-GB", {
      style: "currency",
      currency: "GBP",
    });
  }

  return (
    <div className="savings-slider">
      <h2>Monthly Savings</h2>

      <div className="savings-percent">{percentage.toFixed(0)}%</div>

      <input
        type="range"
        min={0}
        max={100}
        value={percentage}
        onChange={(e) => setPercentage(Number(e.target.value))}
      />

      <p className="saved-text">{formatMoney(savedAmount)} saved this month</p>

      <p className="activities-text">
        {formatMoney(availableForActivities)} available for activities this
        month
      </p>
    </div>
  );
}
