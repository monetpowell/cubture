import "./expense.css";

import { Link } from "react-router-dom";
import Layout from "../../components/layout/layout";
import ExpenseList from "../../components/expenses/expense-table";

export default function Expense() {
  return (
    <Layout>
      <div className="expense-page">
        <div className="expense-header">
          <h1>Expenses</h1>
          <p>Track your household spending and stay on top of your budget</p>
        </div>

        <ExpenseList />

        <Link to="/expenses/new" className="add-expense-button">
          + Add Expense
        </Link>
      </div>
    </Layout>
  );
}
