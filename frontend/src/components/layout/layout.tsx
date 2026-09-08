import Sidebar from "./sidebar";
import TopBar from "./topbar";
import "./layout.css";

type LayoutProps = {
  children: React.ReactNode;
};

export default function Layout({ children }: LayoutProps) {
  return (
    <div className="layout">
      <Sidebar />

      <main className="main-content">
        <TopBar />

        <div className="page-content">{children}</div>
      </main>
    </div>
  );
}
