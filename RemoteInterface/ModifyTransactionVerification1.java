package RemoteInterface;

import BusinessIntelligence.ModifyTransaction1;
import UserInterface.ModifyTransaction1GUI;

import javax.swing.*;

public class ModifyTransactionVerification1 {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 ModifyTransaction1 o = new ModifyTransaction1();
			 o.transactionSearched(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Transaction Code must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showModifyTransaction1GUI();	 
		 }
		}
	

	
	private static void showModifyTransaction1GUI() {
		ModifyTransaction1GUI deleteOrderGUI = new ModifyTransaction1GUI();
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
