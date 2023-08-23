package Exceptions;

import BusinessIntelligence.DeleteTransaction;
import UserInterface.DeleteTransactionGUI;

import javax.swing.*;

public class DeleteTransactionVerification {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 DeleteTransaction o = new DeleteTransaction();
			 o.transactionDeleted(c);
		}

		 else {
			
			 JOptionPane.showMessageDialog(null, "Transaction Code must be an integer!", "Error", JOptionPane.ERROR_MESSAGE); 
		 }
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
