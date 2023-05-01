package BusinessIntelligence;

import UserInterface.DeleteTransactionGUI;

import javax.swing.*;

public class DeleteTransaction {
	
	public void transactionDeleted(int code) {
		Transaction o = Main.transactions.search(code);
		if (o.description.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Transaction Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showDeleteTransactionGUI();
		}
		else {
			Main.transactions.remove(o.code);;
			JOptionPane.showMessageDialog(null, "Transaction was deleted successfully from the Transaction Record File", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	private static void showDeleteTransactionGUI() {
        DeleteTransactionGUI deleteOrderGUI = new DeleteTransactionGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
	

}
