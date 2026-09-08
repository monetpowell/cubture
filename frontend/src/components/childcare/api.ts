import type { Childcare } from "./childcare";

const API_URL = "http://localhost:8080/api/childcare";

export async function createChildcare(
  childcare: Childcare,
): Promise<Childcare> {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(childcare),
  });

  if (!response.ok) {
    throw new Error("Failed to create childcare");
  }

  return response.json();
}
export async function getChildcare(
  month?: number,
  year?: number,
): Promise<Childcare[]> {
  let url = API_URL;

  if (month && year) {
    url += `?month=${month}&year=${year}`;
  }

  const response = await fetch(url);

  if (!response.ok) {
    throw new Error("Failed to fetch childcare");
  }

  return response.json();
}

export async function getChildcareItem(id: string): Promise<Childcare> {
  const response = await fetch(`${API_URL}/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch childcare");
  }

  return response.json();
}

export async function updateChildcare(
  id: string,
  childcare: Childcare,
): Promise<Childcare> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(childcare),
  });

  if (!response.ok) {
    throw new Error("Failed to update childcare");
  }

  return response.json();
}

export async function deleteChildcare(id: string): Promise<void> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });

  if (!response.ok) {
    throw new Error("Failed to delete childcare");
  }
}
