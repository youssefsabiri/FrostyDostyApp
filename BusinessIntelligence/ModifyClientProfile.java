package BusinessIntelligence;

import UserInterface.ClientHomeGUI;

import javax.swing.*;

import Database.ClientCRUD;


public class ModifyClientProfile {
	
	public void profileModified(String password, String city, String street, String phone) {
		
		ClientCRUD.modify(password, city, street, phone);
		JOptionPane.showMessageDialog(null, "Profile modified successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		showHomeGUI();
	}
	
	 private static void showHomeGUI() {
	        ClientHomeGUI homeGUI = new ClientHomeGUI();
	        JFrame adminFrame = new JFrame("Home GUI");
	        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        adminFrame.setSize(800, 600);
	        adminFrame.add(homeGUI);
	        adminFrame.setVisible(true);
	    }

	

}
