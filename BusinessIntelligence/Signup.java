package BusinessIntelligence;

import UserInterface.LoginGUI;

import javax.swing.*;




public class Signup {

    
    
	public void signup(String fullname, String phonenumber, String address, String email, String password) {
		Main.accounts.Add(email, password);
		account acc = new account(email, password);
		Client cl = new Client(fullname, phonenumber, address, acc);
		Main.clients.Add(fullname, phonenumber, address, acc);
		//Login login = new Login(this.parentFrame);
		//login.Authenticate(email, password, accounts);
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
