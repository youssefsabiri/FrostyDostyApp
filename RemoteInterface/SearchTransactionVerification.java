package RemoteInterface;

import BusinessIntelligence.SearchTransaction;
import UserInterface.SearchTransactionGUI;

import javax.swing.*;




public class SearchTransactionVerification {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 SearchTransaction o = new SearchTransaction();
			 o.transactionSearched(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Transaction code must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showSearchTransactionGUI();	 
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
