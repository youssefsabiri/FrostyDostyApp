package Database;

import BusinessIntelligence.Transaction;

import java.util.ArrayList;
import java.util.Iterator;


public class transactionlist {

    public ArrayList<Transaction> transactions = new ArrayList<>();

    public void Add(int code, String date, String des, double amount, double discount) {
        Transaction tr = new Transaction(code, date, des, amount, discount);
        transactions.add(tr);
        WriteToTransactionsFile.write(transactions);
    }

    public void remove(int code) {
        for (Transaction i : transactions) {
            if (i.code==code) {
                transactions.remove(i);
                WriteToTransactionsFile.write(transactions);
                return;
            }
        }

    }



    public Transaction search(int code){
    	Transaction a = new Transaction(-1, "not found", "not found", 0, 0);
        for(Transaction i: transactions ){
            if(i.code==code){
                return i;
                
            }
        }
        
        return(a);

    }
    
    public void update(Transaction oldtransaction, Transaction newtransaction) {
    for (Transaction i: transactions) {
        if (i.code==oldtransaction.code) {
            i=newtransaction;
            WriteToTransactionsFile.write(transactions);
            return ;
        }
    }

}

    public void display(){
        Iterator<Transaction> i=transactions.iterator();
        while(i.hasNext()) {
            System.out.println(i.next().toString());
        }
    }



}
    
 
