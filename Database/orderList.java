package Database;

import BusinessIntelligence.Transaction;
import BusinessIntelligence.order;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class orderList implements Iterable<order>{

    public ArrayList<order> orders= new ArrayList<>();
    FileWriter writer;

    public orderList() {
        orders = new ArrayList<>();
    }

    public void add(int orderCode, String date, double amount, String status) {
        order or = new order(orderCode, date, amount, status);
        orders.add(or);
    }

    public void remove(int orderCode){
        for(order i: orders ){
            if(i.orderCode==orderCode){
            	orders.remove(i);

            	return; 
            }
        }

    }

    
    
    public void update(int code, order neworder) {
    for (order i : orders) {
        if (i.orderCode==code) {
            i=neworder;

            return ;
        }
    }

}

    public void display(){
        Iterator<order> i=orders.iterator();
        while(i.hasNext()) {
            System.out.println(i.next().toString());
        }
    }


    
    public Iterator<order> iterator() {
        return orders.iterator();
    }
    
    public void populate() {
        Random rand = new Random();

        for (int i = 1; i <= 100; i++) {
            int code = i;
            String date = generateRandomDate(rand);
            double amount = rand.nextDouble(990) + 12; // Random amount between 100 and 10000
            String status = getRandomDescription(rand);

            add(code, date, amount, status);
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
        String[] descriptions = {"Delivered", "Cancelled", "In Process"};
        return descriptions[rand.nextInt(descriptions.length)];
    }
    

}

