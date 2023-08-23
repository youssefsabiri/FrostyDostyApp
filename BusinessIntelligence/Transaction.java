
package BusinessIntelligence;

public class Transaction {
    public int code;
    public String description;
    public String amount;
    public String date;

    public String discount;

    public Transaction(int transaction_code, String date, String description, String amount, String discount) {
        this.code = transaction_code;
        this.date=date;
        this.description = description;
        this.amount = amount;
        this.discount = discount;
    }






    
}


