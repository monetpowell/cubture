import "./dashboard-activities.css";

import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import type { Activity } from "../activities/activity";
import { getActivities } from "../activities/api";

interface DashboardActivitiesProps {
  budget: number;
}

export default function DashboardActivities({
  budget,
}: DashboardActivitiesProps) {
  const [activities, setActivities] = useState<Activity[]>([]);

  useEffect(() => {
    async function fetchActivities() {
      try {
        const data = await getActivities();

        const affordable = data.results
          .filter(
            (activity) =>
              activity.ticketpricing !== null &&
              activity.ticketpricing.minPrice <= budget,
          )
          .sort((a, b) => a.ticketpricing!.minPrice - b.ticketpricing!.minPrice)
          .slice(0, 4);

        setActivities(affordable);
      } catch (error) {
        console.error(error);
      }
    }

    fetchActivities();
  }, [budget]);

  return (
    <div className="dashboard-activities">
      <div className="dashboard-activities-header">
        <h2>Activities You Can Afford</h2>

        <Link to="/activities" className="dashboard-view-all">
          View all →
        </Link>
      </div>

      {activities.length === 0 ? (
        <p>No affordable activities found.</p>
      ) : (
        <div className="dashboard-activities-grid">
          {activities.map((activity) => (
            <div key={activity.id} className="dashboard-activity-card">
              <img
                className="dashboard-activity-image"
                src={activity.xlargeimageurl}
                alt={activity.eventname}
              />

              <div className="dashboard-activity-content">
                <h3>{activity.eventname}</h3>

                <p>📍 {activity.venue.town}</p>

                <p>
                  📅{" "}
                  {new Date(activity.date).toLocaleDateString("en-GB", {
                    day: "numeric",
                    month: "short",
                  })}
                </p>
              </div>

              <div className="dashboard-activity-price">
                £{activity.ticketpricing!.minPrice.toFixed(2)}
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}
