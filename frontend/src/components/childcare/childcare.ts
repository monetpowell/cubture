import type { ChildcareFrequency } from "./childcare-frequency";

export interface Childcare {
  id?: string;
  name: string;
  amount: number;
  datePaid: string;
  frequency: ChildcareFrequency;
}
