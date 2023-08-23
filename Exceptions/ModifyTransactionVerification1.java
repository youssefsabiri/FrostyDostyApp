package Exceptions;


import BusinessIntelligence.ModifyTransaction1;


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