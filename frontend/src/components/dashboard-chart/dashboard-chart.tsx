import "./dashboard-chart.css";

import {
  ResponsiveContainer,
  BarChart,
  Bar,
  CartesianGrid,
  XAxis,
  YAxis,
  Tooltip,
  Cell,
} from "recharts";

interface DashboardChartProps {
  income: number;
  expenses: number;
  childcare: number;
  remaining: number;
}

export default function DashboardChart({
  income,
  expenses,
  childcare,
  remaining,
}: DashboardChartProps) {
  const data = [
    {
      name: "Income",
      amount: income,
      colour: "#66e2b2",
    },
    {
      name: "Expenses",
      amount: expenses,
      colour: "#fb9c9c",
    },
    {
      name: "Childcare",
      amount: childcare,
      colour: "#a1d7f4",
    },
    {
      name: "Remaining",
      amount: remaining,
      colour: "#d4c2ff",
    },
  ];

  return (
    <div className="dashboard-chart">
      <h2>Monthly Financial Overview</h2>

      <ResponsiveContainer width="100%" height={200}>
        <BarChart
          data={data}
          layout="vertical"
          margin={{
            top: 10,
            right: 30,
            left: 30,
            bottom: 10,
          }}
        >
          <CartesianGrid strokeDasharray="3 3" stroke="#E5E7EB" />

          <XAxis
            type="number"
            tickFormatter={(value) => `£${value}`}
            tick={{
              fontSize: 14,
              fontFamily: "Inter, sans-serif",
              fill: "#6B7280",
            }}
            axisLine={{
              stroke: "#9CA3AF",
            }}
            tickLine={{
              stroke: "#9CA3AF",
            }}
          />

          <YAxis
            type="category"
            dataKey="name"
            width={100}
            tick={{
              fontSize: 14,
              fontWeight: 600,
              fill: "#4B5563",
            }}
            axisLine={false}
            tickLine={false}
          />

          <Tooltip
            contentStyle={{
              borderRadius: "10px",
              border: "1px solid #E5E7EB",
              boxShadow: "0 4px 16px rgba(15, 23, 42, 0.08)",
              fontFamily: "Inter, sans-serif",
              fontSize: "14px",
            }}
            formatter={(value) =>
              Number(value).toLocaleString("en-GB", {
                style: "currency",
                currency: "GBP",
              })
            }
          />

          <Bar dataKey="amount" radius={[0, 8, 8, 0]} barSize={28}>
            {data.map((entry) => (
              <Cell key={entry.name} fill={entry.colour} />
            ))}
          </Bar>
        </BarChart>
      </ResponsiveContainer>
    </div>
  );
}
