package BusinessIntelligence;

import UserInterface.LoginGUI;

import javax.swing.*;

import Database.ClientCRUD;




public class Signup {

    
    
	public void signup(String fullname, String phonenumber, String address, String email, String password) {
		String[] credentials = fullname.split(" ");
    	String first_name = credentials[0]; 
    	String middle_name = credentials[1];
    	String last_name = credentials[2];
    	
    	String[] address_details = address.split(",");
    	String street = address_details[0]; 
    	String city = address_details[1];
    	
		
    	ClientCRUD.create(first_name, middle_name, last_name, phonenumber, city, street, email, password);
		
		
		account acc = new account("khawi", "khawi");
		Client cl = new Client("khawi", "khawi", "khawi", acc);
		showLoginGUI(cl);
				
	}
	
	
	
	 private static void showLoginGUI(Client cl) {
	        LoginGUI loginGUI = new LoginGUI(cl);
	        JFrame adminFrame = new JFrame("Admin GUI");
	        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        adminFrame.setSize(800, 600);
	        adminFrame.add(loginGUI);
	        adminFrame.setVisible(true);
	    }

	

}
