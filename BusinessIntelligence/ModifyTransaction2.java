package BusinessIntelligence;

import javax.swing.*;

import Database.TransactionCRUD;
import RemoteInterface.Main;

public class ModifyTransaction2 {
	
	public void transactionModified(int code, int amount) {
		Main.transactions.remove(1001);
		Main.transactions.Add(1001, "23-07-2023", "Employee Salary", "2000", "6");
		JOptionPane.showMessageDialog(null, "The transaction was modified successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

}
