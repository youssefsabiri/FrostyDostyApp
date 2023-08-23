package BusinessIntelligence;



public class order {
    public int orderCode;
    public double amount;
    public String transaction_date;
    public String status;

    
    public order(int orderCode, String transaction_date, double amount, String status) {
		super();
		this.orderCode = orderCode;
		this.amount = amount;
		this.transaction_date = transaction_date;
		this.status = status;
	}


	
}

    


