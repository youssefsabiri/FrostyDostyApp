package Exceptions;


import BusinessIntelligence.ModifyClientProfile;
import UserInterface.ClientModifyProfileGUI;

import javax.swing.*;

public class ModifyClientProfileVerification {
	
	private JFrame frameToUpdate;
	
	public void verify(String password1, String password2, String city, String street, String phone) {
		if (password1.isEmpty() || city.isEmpty() || phone.isEmpty() || street.isEmpty()) {
			JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
        	showModifyGUI();
		}
		else if (password1.equals(password2) && isNumeric(phone)) { 
            ModifyClientProfile s = new ModifyClientProfile();
            s.profileModified(password1, city, street, phone);
        } else if (isNumeric(phone)){
        	JOptionPane.showMessageDialog(null, "Second Password does not match the first password !", "Error", JOptionPane.ERROR_MESSAGE);
        	showModifyGUI();
        } else if (password1.equals(password2)) {
        	JOptionPane.showMessageDialog(null, "Invalid Phone Number !", "Error", JOptionPane.ERROR_MESSAGE);
        	showModifyGUI();
        } else {
        	JOptionPane.showMessageDialog(null, "Second Password does not match the first password, Invalid Phone Number !", "Error", JOptionPane.ERROR_MESSAGE);
        	showModifyGUI();
        }
    }

    private void showModifyGUI() {
        ClientModifyProfileGUI profileGUI = new ClientModifyProfileGUI();
        frameToUpdate.getContentPane().removeAll();
        frameToUpdate.getContentPane().add(profileGUI);
        frameToUpdate.revalidate();
        frameToUpdate.repaint();
    }
	public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
	
}


