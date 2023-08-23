package Database;

import BusinessIntelligence.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class transactionlist implements Iterable<Transaction> {

    public ArrayList<Transaction> transactions = new ArrayList<>();

    public void Add(int code, String date, String des, String amount, String discount) {
        Transaction tr = new Transaction(code, date,des, amount, discount);
        transactions.add(tr);
      
    }

    public void remove(int code) {
        for (Transaction i : transactions) {
            if (i.code==code) {
                transactions.remove(i);

                return;
            }
        }

    }



   
    
    public void update(Transaction oldtransaction, Transaction newtransaction) {
    for (Transaction i: transactions) {
        if (i.code==oldtransaction.code) {
            i=newtransaction;

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

    public Iterator<Transaction> iterator() {
        return transactions.iterator();
    }
    
    public void populate() {
        Random rand = new Random();

        for (int i = 1; i <= 1000; i++) {
            int code = i;
            String date = generateRandomDate(rand);
            String des = getRandomDescription(rand);
            int amount = rand.nextInt(9901) + 100; // Random amount between 100 and 10000
            String amountStr = String.valueOf(amount);
            String receiver_id = String.valueOf(rand.nextInt(300) + 1); // Random receiver_id between 1 and 300

            Add(code, date, des, amountStr, receiver_id);
        }
    }

    // Helper method to generate random date in format (DD-MM-YYYY)
    private static String generateRandomDate(Random rand) {
        int day = rand.nextInt(28) + 1; // Random day between 1 and 28 (ignoring February for simplicity)
        int month = rand.nextInt(12) + 1; // Random month between 1 and 12
        int year = rand.nextInt(21) + 2000; // Random year between 2000 and 2021 (adjust as needed)

        return String.format("%02d-%02d-%04d", day, month, year);
    }

    // Helper method to get a random description from the given options
    private static String getRandomDescription(Random rand) {
        String[] descriptions = {"Employee Salary", "Supplier Payment", "Client Payment"};
        return descriptions[rand.nextInt(descriptions.length)];
    }

}
    
 
