import type { ExpenseFrequency } from "./expense-frequency";

export interface Expense {
  id?: string;
  name: string;
  amount: number;
  datePaid: string;
  frequency: ExpenseFrequency;
}
