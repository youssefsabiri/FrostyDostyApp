
package BusinessIntelligence;

public class Transaction {
    public int code;
    public String transaction_date;
    public String description;
    public double amount;

    public double discount;

    public Transaction(int transaction_code, String transaction_date, String description, double amount, double discount) {
        this.code = transaction_code;
        this.transaction_date = transaction_date;
        this.description = description;
        this.amount = amount;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "transaction_code='" + code + '\'' +
                ", transaction_date=" + transaction_date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }


    public void ApplyDiscount(Transaction t){
        t.amount=t.amount-t.amount*(t.discount/100);
    }
}


