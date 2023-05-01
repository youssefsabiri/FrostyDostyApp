package RemoteInterface;

import BusinessIntelligence.AddTransaction;
import UserInterface.AddTransactionGUI;

import javax.swing.*;



public class AddTransactionVerification {
	
	public void verify(String name, String amount, String discount) {
		if (isNumeric(amount) && isNumeric(discount)){
			Double p = Double.valueOf(amount);
			Double q = Double.valueOf(discount);
			AddTransaction tr = new AddTransaction();
			tr.transactionVerified(name, p, q);
	}
		else if (isNumeric(amount)==false && isNumeric(discount)==false) {
			JOptionPane.showMessageDialog(null, "Amount must be a double, and Discount must be a double!", "Error", JOptionPane.ERROR_MESSAGE);
			showAddTransactionGUI();	
		}
		else {
			 if (isNumeric(amount)) {
				 JOptionPane.showMessageDialog(null, "Discount must be a double!", "Error", JOptionPane.ERROR_MESSAGE);
				 showAddTransactionGUI();	
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Amount must be a double!", "Error", JOptionPane.ERROR_MESSAGE);
				 showAddTransactionGUI();	 
			 }
		}
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
	

	
	private static void showAddTransactionGUI() {
		AddTransactionGUI addtransactionGUI = new AddTransactionGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(addtransactionGUI);
        adminFrame.setVisible(true);
    }
	

}
