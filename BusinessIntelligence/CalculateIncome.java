package BusinessIntelligence;
import Database.transactionlist;

public class CalculateIncome {
    public double NetIncome(transactionlist transactions){
        double income;
        CalculateExpenses expenses = new CalculateExpenses();
        CalculateRevenues revenues= new CalculateRevenues();
        income = revenues.Revenues(transactions)-expenses.Expenses(transactions);
        return income;
    }

}
