package BusinessIntelligence;

import javax.swing.*;

import Database.TransactionCRUD;
import Exceptions.Main;

public class DeleteTransaction {
	
	public void transactionDeleted(int code) {
		if (code>1001){
			JOptionPane.showMessageDialog(null, "Transaction Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Main.transactions.remove(code);;
			JOptionPane.showMessageDialog(null, "Transaction was deleted successfully from the Transaction History", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	


}
