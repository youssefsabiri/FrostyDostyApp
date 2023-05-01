package BusinessIntelligence;
import Database.transactionlist;

public class CalculateExpenses {
    public double Expenses(transactionlist transactions){
     double a=0;
            for (Transaction i : transactions.transactions) {
                if (i.amount<0) {
                    a= i.amount+a;
                }
            }
            double expense = a;


        return expense;
    }

}
