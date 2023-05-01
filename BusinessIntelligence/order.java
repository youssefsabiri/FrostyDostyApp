package BusinessIntelligence;



public class order {
    public int orderCode;
    public String item;
    public String transaction_date;
    public int quantity;

    public order(int orderCode, String transaction_date, String item, int quantity) {
        this.orderCode = orderCode;
        this.transaction_date = transaction_date;
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BusinessIntelligence.order{" +
                "orderCode='" + orderCode + '\'' +
                ", item='" + item + '\'' +
                ", transaction_date=" + transaction_date +
                ", quantity=" + quantity +
                '}';
    }
}

    


