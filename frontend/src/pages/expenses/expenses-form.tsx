import ExpenseForm from "../../components/expenses/expense-form";
import Layout from "../../components/layout/layout";

export default function ExpensesForm() {
  return (
    <Layout>
      <div className="expense-page">
        <ExpenseForm />
      </div>
    </Layout>
  );
}
