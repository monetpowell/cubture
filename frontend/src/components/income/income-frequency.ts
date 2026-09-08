export const IncomeFrequency = {
  WEEKLY: "WEEKLY",
  FORTNIGHTLY: "FORTNIGHTLY",
  MONTHLY: "MONTHLY",
  ANNUALLY: "ANNUALLY",
  ONE_OFF: "ONE_OFF",
} as const;

export type IncomeFrequency =
  (typeof IncomeFrequency)[keyof typeof IncomeFrequency];
