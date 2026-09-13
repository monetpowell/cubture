import ExpenseForm from "../../components/expenses/expense-form";
import Layout from "../../components/layout/layout";

export default function ExpensesFormPage() {
  return (
    <Layout>
      <div className="expense-form-page">
        <ExpenseForm />
      </div>
    </Layout>
  );
}
