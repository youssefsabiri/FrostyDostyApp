package BusinessIntelligence;

import UserInterface.SearchTransactionGUI;
import UserInterface.SearchTransactionResultGUI;

import javax.swing.*;

public class SearchTransaction {
	
	public void transactionSearched(int code) {
		Transaction o = Main.transactions.search(code);
		if (o.description.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Transaction Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showSearchTransactionGUI();
		}
		else {
			showResultGUI(o);
		}
		
		
	}
	
	private static void showSearchTransactionGUI() {
		SearchTransactionGUI deleteOrderGUI = new SearchTransactionGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
	
	private static void showResultGUI(Transaction t) {
        SearchTransactionResultGUI deleteOrderGUI = new SearchTransactionResultGUI(t);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
