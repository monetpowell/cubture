import { Routes, Route } from "react-router-dom";
import Income from "./pages/income/income";
import Dashboard from "./pages/dashboard/dashboard";
import Savings from "./pages/savings.tsx/savings";
import Childcare from "./pages/childcare/childcare";
import Activities from "./pages/activities/activities";
import ChildcareFormPage from "./pages/childcare/childcare-form-page";
import SavingsFormPage from "./pages/savings.tsx/savings-form-page";
import IncomeFormPage from "./pages/income/income-form-page";
import ExpenseFormPage from "./pages/expense/expense-form-page";
import Expense from "./pages/expense/expense";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Dashboard />} />
      <Route path="/income" element={<Income />} />
      <Route path="/income/new" element={<IncomeFormPage />} />
      <Route path="/income/:id/edit" element={<IncomeFormPage />} />
      <Route path="/expenses" element={<Expense />} />
      <Route path="/savings" element={<Savings />} />
      <Route path="/childcare" element={<Childcare />} />
      <Route path="/activities" element={<Activities />} />
      <Route path="/expenses/new" element={<ExpenseFormPage />} />
      <Route path="/expenses/:id/edit" element={<ExpenseFormPage />} />
      <Route path="/childcare/new" element={<ChildcareFormPage />} />
      <Route path="/childcare/:id/edit" element={<ChildcareFormPage />} />
      <Route path="/savings/new" element={<SavingsFormPage />} />
      <Route path="/savings/:id/edit" element={<SavingsFormPage />} />
    </Routes>
  );
}

export default App;
