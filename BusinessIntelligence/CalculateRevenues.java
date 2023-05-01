package BusinessIntelligence;
import Database.transactionlist;

public class CalculateRevenues {

    public double Revenues(transactionlist transactions ){
        double a=0;
        for (Transaction i : transactions.transactions) {
            if (i.amount>0) {
                a= i.amount+a;
            }
        }
        double revenue = a;


        return revenue;
    }

}