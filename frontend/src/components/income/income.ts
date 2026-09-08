import type { IncomeFrequency } from "./income-frequency";

export interface Income {
  id?: string;
  source: string;
  amount: number;
  dateReceived: string;
  frequency: IncomeFrequency;
}
