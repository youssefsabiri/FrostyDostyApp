package BusinessIntelligence;


import UserInterface.SearchTransactionResultGUI;

import javax.swing.*;



public class SearchTransaction {
	
	public void transactionSearched(int code) {
		if (code>1000) {
			JOptionPane.showMessageDialog(null, "Transaction Not Found!", "Error", JOptionPane.ERROR_MESSAGE);}

		else {
	        	Transaction t = new Transaction(code, "01-02-2022", "Supplier Payment", "6000", "10");
	        	showResultGUI(t);}
		
		
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
