import "./activity-cards.css";

import { useEffect, useState } from "react";

import type { Activity } from "./activity";
import { getActivities } from "./api";

export default function ActivityList() {
  const [activities, setActivities] = useState<Activity[]>([]);
  const [location, setLocation] = useState("");
  const [sortPrice, setSortPrice] = useState("");
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchActivities() {
      try {
        const data = await getActivities();
        setActivities(data.results);
      } catch {
        setError(
          "Unable to load activities. Please check your connection and try again.",
        );
      }
    }

    fetchActivities();
  }, []);

  if (error) {
    return <p className="activity-error">{error}</p>;
  }

  const filteredActivities = activities.filter((activity) => {
    return (
      activity.ticketpricing !== null &&
      (location === "" ||
        activity.venue.town.toLowerCase().includes(location.toLowerCase()))
    );
  });

  const sortedActivities = [...filteredActivities];

  if (sortPrice === "LOW_HIGH") {
    sortedActivities.sort(
      (a, b) => a.ticketpricing!.minPrice - b.ticketpricing!.minPrice,
    );
  }

  if (sortPrice === "HIGH_LOW") {
    sortedActivities.sort(
      (a, b) => b.ticketpricing!.minPrice - a.ticketpricing!.minPrice,
    );
  }

  return (
    <>
      <div className="activity-filters">
        <input
          type="text"
          placeholder="Search location..."
          value={location}
          onChange={(e) => setLocation(e.target.value)}
        />

        <select
          value={sortPrice}
          onChange={(e) => setSortPrice(e.target.value)}
        >
          <option value="">Sort by Price</option>
          <option value="LOW_HIGH">Low to High</option>
          <option value="HIGH_LOW">High to Low</option>
        </select>
      </div>

      <div className="activity-list">
        {sortedActivities.map((activity) => (
          <div key={activity.id} className="activity-card">
            <div className="activity-image-container">
              <img
                src={activity.xlargeimageurl}
                alt={activity.eventname}
                className="activity-image"
              />
            </div>

            <div className="activity-content">
              <h3>{activity.eventname}</h3>

              <div className="activity-details">
                <p className="activity-info">📍 {activity.venue.town}</p>

                <p className="activity-info">
                  📅{" "}
                  {new Date(activity.date).toLocaleDateString("en-GB", {
                    day: "numeric",
                    month: "short",
                    year: "numeric",
                  })}
                </p>

                <p className="activity-info">
                  💷 From £{activity.ticketpricing!.minPrice.toFixed(2)}
                </p>
              </div>

              <a
                href={activity.link}
                target="_blank"
                rel="noreferrer"
                className="view-button"
              >
                View Event
              </a>
            </div>
          </div>
        ))}
      </div>
    </>
  );
}
