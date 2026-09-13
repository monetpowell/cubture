import "./savings.css";

import { Link } from "react-router-dom";
import Layout from "../../components/layout/layout";
import SavingsList from "../../components/savings/savings-card";

export default function Savings() {
  return (
    <Layout>
      <div className="savings-page">
        <div className="savings-header">
          <h1>Savings Goals</h1>
          <p>Save towards the things that matter most</p>
        </div>

        <SavingsList />

        <Link to="/savings/new" className="add-savings-button">
          + Add Goal
        </Link>
      </div>
    </Layout>
  );
}
