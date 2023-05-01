package RemoteInterface;

import BusinessIntelligence.SearchOrder;
import UserInterface.SearchOrderGUI;

import javax.swing.*;

public class SearchOrderVerification {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 SearchOrder o = new SearchOrder();
			 o.orderSearched(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Order Code must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showDeleteOrderGUI();	 
		 }
		}
	

	
	private static void showDeleteOrderGUI() {
        SearchOrderGUI deleteOrderGUI = new SearchOrderGUI();
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
