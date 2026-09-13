import "./childcare.css";

import { Link } from "react-router-dom";
import Layout from "../../components/layout/layout";
import ChildcareList from "../../components/childcare/childcare-table";

export default function Childcare() {
  return (
    <Layout>
      <div className="childcare-page">
        <div className="childcare-header">
          <h1>Childcare</h1>
          <p>Track and manage your childcare costs</p>
        </div>

        <ChildcareList />

        <Link to="/childcare/new" className="add-childcare-button">
          + Add Childcare
        </Link>
      </div>
    </Layout>
  );
}
