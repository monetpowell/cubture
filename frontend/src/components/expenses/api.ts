import type { Expense } from "./expense";

const API_URL = "http://localhost:8080/api/expenses";

export async function createExpense(expense: Expense): Promise<Expense> {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(expense),
  });

  if (!response.ok) {
    throw new Error("Failed to create expense");
  }

  return response.json();
}

export async function getExpenses(
  month?: number,
  year?: number,
): Promise<Expense[]> {
  let url = API_URL;

  if (month && year) {
    url += `?month=${month}&year=${year}`;
  }

  const response = await fetch(url);

  if (!response.ok) {
    throw new Error("Failed to fetch expenses");
  }

  return response.json();
}

export async function getExpense(id: string): Promise<Expense> {
  const response = await fetch(`${API_URL}/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch expense");
  }

  return response.json();
}

export async function updateExpense(
  id: string,
  expense: Expense,
): Promise<Expense> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(expense),
  });

  if (!response.ok) {
    throw new Error("Failed to update expense");
  }

  return response.json();
}

export async function deleteExpense(id: string): Promise<void> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });

  if (!response.ok) {
    throw new Error("Failed to delete expense");
  }
}
