import type { ActivityResponse } from "./activity";

const API_URL = "http://localhost:8080/api/activities";

export async function getActivities(): Promise<ActivityResponse> {
  const response = await fetch(API_URL);

  if (!response.ok) {
    throw new Error("Failed to fetch activities");
  }

  return response.json();
}