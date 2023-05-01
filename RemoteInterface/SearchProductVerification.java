package RemoteInterface;

import BusinessIntelligence.SearchProduct;
import UserInterface.SearchProductGUI;

import javax.swing.*;

public class SearchProductVerification {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 SearchProduct o = new SearchProduct();
			 o.productSearched(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Inventory Number must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showDeleteOrderGUI();	 
		 }
		}
	

	
	private static void showDeleteOrderGUI() {
        SearchProductGUI deleteOrderGUI = new SearchProductGUI();
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
