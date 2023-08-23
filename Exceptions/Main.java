package Exceptions;

import Database.orderList;
import Database.productlist;
import Database.transactionlist;
import UserInterface.Indexpage;

public class Main {
	
	public static int clientID;
	public static orderList orders = new orderList();
	public static transactionlist transactions = new transactionlist();
	public static productlist products = new productlist();
	
	public static void main(String[] args){
    	Indexpage.main(args);
    	transactions.populate();
    	products.populate();
    	orders.populate();
 }

}
