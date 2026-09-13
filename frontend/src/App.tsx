import { Routes, Route } from "react-router-dom";
import Income from "./pages/income/income";
import Dashboard from "./pages/dashboard/dashboard";
import Expenses from "./pages/expenses/expenses";
import Savings from "./pages/savings.tsx/savings";
import Childcare from "./pages/childcare/childcare";
import Activities from "./pages/activities/activities";
import IncomeForm from "./pages/income/income-form-page";
import ExpensesForm from "./pages/expenses/expenses-form-page";
import ChildcareFormPage from "./pages/childcare/childcare-form-page";
import SavingsFormPage from "./pages/savings.tsx/savings-form-page";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Dashboard />} />
      <Route path="/income" element={<Income />} />
      <Route path="/income/new" element={<IncomeForm />} />
      <Route path="/income/:id/edit" element={<IncomeForm />} />
      <Route path="/expenses" element={<Expenses />} />
      <Route path="/savings" element={<Savings />} />
      <Route path="/childcare" element={<Childcare />} />
      <Route path="/activities" element={<Activities />} />
      <Route path="/expenses/new" element={<ExpensesForm />} />
      <Route path="/expenses/:id/edit" element={<ExpensesForm />} />
      <Route path="/childcare/new" element={<ChildcareFormPage />} />
      <Route path="/childcare/:id/edit" element={<ChildcareFormPage />} />
      <Route path="/savings/new" element={<SavingsFormPage />} />
      <Route path="/savings/:id/edit" element={<SavingsFormPage />} />
    </Routes>
  );
}

export default App;
