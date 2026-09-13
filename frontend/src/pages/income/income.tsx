import "./income.css";

import { Link } from "react-router-dom";
import Layout from "../../components/layout/layout";
import IncomeList from "../../components/income/income-list";

export default function Income() {
  return (
    <Layout>
      <div className="income-page">
        <div className="income-header">
          <h1>Income</h1>
          <p>Track and manage your income</p>
        </div>
        <IncomeList />
        <Link to="/income/new" className="add-income-button">
          + Add Income
        </Link>
      </div>
    </Layout>
  );
}
