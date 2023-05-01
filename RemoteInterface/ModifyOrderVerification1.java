package RemoteInterface;

import BusinessIntelligence.ModifyOrder1;
import UserInterface.ModifyOrder1GUI;

import javax.swing.*;

public class ModifyOrderVerification1 {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 ModifyOrder1 o = new ModifyOrder1();
			 o.orderSearched(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Order Code must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showModifyOrderGUI();	 
		 }
		}
	

	
	private static void showModifyOrderGUI() {
        ModifyOrder1GUI deleteOrderGUI = new ModifyOrder1GUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
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
