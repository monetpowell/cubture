import type { Savings } from "./savings";

const API_URL = "http://localhost:8080/api/savings";

export async function createSavings(savings: Savings): Promise<Savings> {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(savings),
  });

  if (!response.ok) {
    throw new Error("Failed to create savings goal");
  }

  return response.json();
}

export async function getSavings(): Promise<Savings[]> {
  const response = await fetch(API_URL);

  if (!response.ok) {
    throw new Error("Failed to fetch savings goals");
  }

  return response.json();
}

export async function getSaving(id: string): Promise<Savings> {
  const response = await fetch(`${API_URL}/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch savings goal");
  }

  return response.json();
}

export async function updateSavings(
  id: string,
  savings: Savings,
): Promise<Savings> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(savings),
  });

  if (!response.ok) {
    throw new Error("Failed to update savings goal");
  }

  return response.json();
}

export async function deleteSavings(id: string): Promise<void> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });

  if (!response.ok) {
    throw new Error("Failed to delete savings goal");
  }
}
