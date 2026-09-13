const API_URL = "http://localhost:8080";

export interface DashboardSummary {
  totalIncome: number;
  totalExpenses: number;
  totalChildcare: number;
  moneyLeft: number;

  incomeTrend: number;
  expenseTrend: number;
  childcareTrend: number;
  remainingTrend: number;
}

export async function getDashboardSummary(
  month: number,
  year: number,
): Promise<DashboardSummary> {
  const response = await fetch(
    `${API_URL}/dashboard/summary?month=${month}&year=${year}`,
  );

  if (!response.ok) {
    throw new Error("Failed to fetch dashboard summary");
  }

  return response.json();
}
