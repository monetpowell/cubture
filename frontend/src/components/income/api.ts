import type { Income } from "./income";

const API_URL = "http://localhost:8080/api/income";

export async function createIncome(income: Income): Promise<Income> {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(income),
  });

  if (!response.ok) {
    throw new Error("Failed to create income");
  }

  return response.json();
}

export async function getIncomes(
  month?: number,
  year?: number,
): Promise<Income[]> {
  let url = API_URL;

  if (month && year) {
    url += `?month=${month}&year=${year}`;
  }

  const response = await fetch(url);

  if (!response.ok) {
    throw new Error("Failed to fetch incomes");
  }

  return response.json();
}

export async function deleteIncome(id: string): Promise<void> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });

  if (!response.ok) {
    throw new Error("Failed to delete income");
  }
}

export async function updateIncome(
  id: string,
  income: Income,
): Promise<Income> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(income),
  });

  if (!response.ok) {
    throw new Error("Failed to update income");
  }

  return response.json();
}

export async function getIncome(id: string): Promise<Income> {
  const response = await fetch(`${API_URL}/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch income");
  }

  return response.json();
}
