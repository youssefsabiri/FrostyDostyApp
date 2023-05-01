package BusinessIntelligence;

import UserInterface.ClientHomeGUI;

import javax.swing.*;


public class ModifyClientProfile {
	
	public void profileModified(String password, String address, String phone, Client old_client) {
		account new_account  = old_client.account;
		new_account.setPassword(password);
		Client new_client = old_client;
		new_client.address = address;
		new_client.phonenumber = phone;
		new_client.account = new_account;
		Main.accounts.update(old_client.account, new_account);
		Main.clients.update(old_client, new_client);
		JOptionPane.showMessageDialog(null, "Profile modified successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		showHomeGUI(new_client);
	}
	
	 private static void showHomeGUI(Client cl) {
	        ClientHomeGUI homeGUI = new ClientHomeGUI(cl, Main.orders);
	        JFrame adminFrame = new JFrame("Home GUI");
	        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        adminFrame.setSize(800, 600);
	        adminFrame.add(homeGUI);
	        adminFrame.setVisible(true);
	    }

}
