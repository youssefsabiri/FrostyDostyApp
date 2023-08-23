package Exceptions;



import javax.swing.*;

import BusinessIntelligence.Transaction;
import Database.TransactionEmployeeCRUD;
import Database.TransactionSupplierCRUD;



public class AddTransactionVerification {
	
	public void verify(String amount, String type, String ID) {
		if(amount.isEmpty() || ID.isEmpty() || type.isEmpty()) {
			JOptionPane.showMessageDialog(null, "All fields should be filled!", "Error", JOptionPane.ERROR_MESSAGE);
			//showAddTransactionGUI();  
		}
		
		else if (isNumeric(amount) && isNumeric(ID) && (type.equals("E") || type.equals("S"))){
			int am = Integer.parseInt(amount);
			int id = Integer.parseInt(ID);
			if(type.equals("E")) {
				TransactionEmployeeCRUD.create(am, id);
				Main.transactions.Add(1001, "23-07-2023", "Employee Salary", "3000", "6");
				JOptionPane.showMessageDialog(null, "Your Transaction was added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
			} else {
				TransactionSupplierCRUD.create(am, id);
				Main.transactions.Add(1001, "23-07-2023", "Supplier Payment", "3000", "6");
				JOptionPane.showMessageDialog(null, "Your Transaction was added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (isNumeric(amount) && isNumeric(ID) && !(type.equals("E") || type.equals("S"))) {
			JOptionPane.showMessageDialog(null, "Type must be either E or S!", "Error", JOptionPane.ERROR_MESSAGE);
				
		}
		else {
			 if (isNumeric(amount)) {
				 JOptionPane.showMessageDialog(null, "Code must be an  integer!", "Error", JOptionPane.ERROR_MESSAGE);
					
			 }
			 else if (isNumeric(ID)){
				 JOptionPane.showMessageDialog(null, "Amount must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
				 
			 }else {
				 JOptionPane.showMessageDialog(null, "Amount & code must be numbers!", "Error", JOptionPane.ERROR_MESSAGE);
				
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
	

	
	
	

}