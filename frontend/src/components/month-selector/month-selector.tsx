interface MonthSelectorProps {
  selectedMonth: number;
  selectedYear: number;
  onMonthChange: (month: number) => void;
}

export default function MonthSelector({
  selectedMonth,
  selectedYear,
  onMonthChange,
}: MonthSelectorProps) {
  const monthNames = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  ];

  return (
    <div className="dashboard-month-selector">
      <label htmlFor="month-selector">Viewing:</label>

      <select
        id="month-selector"
        value={selectedMonth}
        onChange={(event) => onMonthChange(Number(event.target.value))}
      >
        {monthNames.map((month, index) => (
          <option key={month} value={index + 1}>
            {month} {selectedYear}
          </option>
        ))}
      </select>
    </div>
  );
}