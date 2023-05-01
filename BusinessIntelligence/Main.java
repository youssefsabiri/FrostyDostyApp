package BusinessIntelligence;



//import java.util.Scanner;

import Database.*;
import UserInterface.Indexpage;

public class Main {
	
	public static accountList accounts = new accountList();
	public static ClientList clients = new ClientList();
	public static orderList orders = new orderList();
	public static transactionlist transactions = new transactionlist();
	public static MenuList menu = new MenuList();
	public static productlist products = new productlist();
	

    public static void main(String[] args){
    	Indexpage.main(args);
 }


}






