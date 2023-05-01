package RemoteInterface;

import BusinessIntelligence.Client;
import BusinessIntelligence.ModifyClientProfile;
import UserInterface.ClientModifyProfileGUI;

import javax.swing.*;

public class ModifyClientProfileVerification {
	
	private JFrame frameToUpdate;
	
	public void verify(String password1, String password2, String address, String phone, Client cl) {
		if (password1.equals(password2) && isNumeric(phone)) { 
            ModifyClientProfile s = new ModifyClientProfile();
            s.profileModified(password1, address, phone, cl);
        } else if (isNumeric(phone)){
        	JOptionPane.showMessageDialog(null, "Second Password does not match the first password !", "Error", JOptionPane.ERROR_MESSAGE);
        	showModifyGUI(cl);
        } else if (password1.equals(password2)) {
        	JOptionPane.showMessageDialog(null, "Invalid Phone Number !", "Error", JOptionPane.ERROR_MESSAGE);
        	showModifyGUI(cl);
        } else {
        	JOptionPane.showMessageDialog(null, "Second Password does not match the first password, And Invalid Phone Number!", "Error", JOptionPane.ERROR_MESSAGE);
        	showModifyGUI(cl);
        }
    }

    private void showModifyGUI(Client cl) {
        ClientModifyProfileGUI profileGUI = new ClientModifyProfileGUI(cl);
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


