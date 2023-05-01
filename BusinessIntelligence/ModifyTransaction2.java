package BusinessIntelligence;

import javax.swing.*;

public class ModifyTransaction2 {
	
	public void transactionModified(int code, double amount) {
		Transaction old_transaction = Main.transactions.search(code);
		Transaction new_transaction = old_transaction;
		new_transaction.amount=amount;
		Main.transactions.update(old_transaction, new_transaction);
		JOptionPane.showMessageDialog(null, "The transaction was modified successfully in the Transaction Record File", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

}
