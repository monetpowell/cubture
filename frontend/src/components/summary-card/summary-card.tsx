import "./summary-card.css";
import type { ReactNode } from "react";

interface SummaryCardProps {
  icon: ReactNode;
  title: string;
  value: string;
  subtitle: string;
  highlight?: boolean;
  trend?: number;
}

export default function SummaryCard({
  icon,
  title,
  value,
  subtitle,
  highlight = false,
  trend,
}: SummaryCardProps) {
  function getTrendIcon() {
    if (trend === undefined) {
      return "";
    }

    if (trend > 0) {
      return "↑";
    }

    if (trend < 0) {
      return "↓";
    }

    return "→";
  }

  function getTrendClass() {
    if (trend === undefined || trend === 0) {
      return "trend-neutral";
    }

    return trend > 0 ? "trend-positive" : "trend-negative";
  }

  return (
    <div className="summary-card">
      <div className="summary-top">
        <div className="summary-icon">{icon}</div>

        <div className="summary-text">
          <h3>{title}</h3>
          <p>{subtitle}</p>
        </div>
      </div>

      <h2 className={highlight ? "green" : ""}>{value}</h2>

      {trend !== undefined && (
        <div className={`summary-trend ${getTrendClass()}`}>
          {getTrendIcon()} {Math.abs(trend).toFixed(1)}% vs last month
        </div>
      )}
    </div>
  );
}
