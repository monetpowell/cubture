import "./summary-card.css";
import type { ReactNode } from "react";

interface SummaryCardProps {
  icon: ReactNode;
  title: string;
  value: string;
  subtitle: string;
  highlight?: boolean;
}

export default function SummaryCard({
  icon,
  title,
  value,
  subtitle,
  highlight = false,
}: SummaryCardProps) {
  return (
    <div className="summary-card">
      <div className="summary-top">
        <div className="summary-icon">
          {icon}
        </div>

        <div className="summary-text">
          <h3>{title}</h3>
          <p>{subtitle}</p>
        </div>
      </div>

      <h2 className={highlight ? "green" : ""}>{value}</h2>
    </div>
  );
}