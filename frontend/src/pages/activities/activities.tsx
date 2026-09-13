import "./activities.css";

import Layout from "../../components/layout/layout";
import ActivityList from "../../components/activities/activity-cards";

export default function Activities() {
  return (
    <Layout>
      <div className="activities-page">
        <div className="activities-header">
          <h1>Discover Activities</h1>
          <p>Affordable family activities across the UK</p>
        </div>

        <ActivityList />
      </div>
    </Layout>
  );
}
