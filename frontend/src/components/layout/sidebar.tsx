import { NavLink } from "react-router-dom";
import logo from "../../assets/logo.png";

export default function Sidebar() {
  return (
    <aside className="sidebar">
      <img src={logo} alt="Cubture" className="logo" />

      <nav>
        <NavLink to="/">Home</NavLink>
        <NavLink to="/income">Income</NavLink>
        <NavLink to="/expenses">Expenses</NavLink>
        <NavLink to="/childcare">Childcare</NavLink>
        <NavLink to="/savings">Savings</NavLink>
        <NavLink to="/activities">Activities</NavLink>
      </nav>
    </aside>
  );
}
