package Exceptions;

import BusinessIntelligence.ModifyTransaction2;
import UserInterface.ModifyTransaction2GUI;

import javax.swing.*;

public class ModifyTransactionVerification2 {
	
	public void verify(int code, String amount) {
		if (isNumeric(amount)){
			 int am  = Integer.parseInt(amount);
			 ModifyTransaction2 o = new ModifyTransaction2();
			 o.transactionModified(code, am);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Amount must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);	 
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
}
