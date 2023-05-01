package RemoteInterface;

import BusinessIntelligence.ModifyTransaction2;
import UserInterface.ModifyTransaction2GUI;

import javax.swing.*;

public class ModifyTransactionVerification2 {
	
	public void verify(int code, String quantity) {
		if (isNumeric(quantity)){
			double c = Double.valueOf(quantity);
			 ModifyTransaction2 o = new ModifyTransaction2();
			 o.transactionModified(code, c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Inventory Number must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showModifyTransaction2GUI(code);	 
		 }
		}
	

	
	private static void showModifyTransaction2GUI(int code) {
		ModifyTransaction2GUI deleteOrderGUI = new ModifyTransaction2GUI(code);
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
            double i = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
