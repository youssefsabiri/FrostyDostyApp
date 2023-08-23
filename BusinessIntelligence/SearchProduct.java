package BusinessIntelligence;


import UserInterface.SearchProductResultGUI;

import javax.swing.*;

public class SearchProduct {
	
	public void productSearched(int code) {
		if (code>100) {
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);}

		else {
	        	product t = new product(code, "Raw Chocolate", 2, 50, 1, "Row 3");
	        	showResultGUI(t);}
		
		
	}
	

	
	private static void showResultGUI(product p) {
        SearchProductResultGUI deleteOrderGUI = new SearchProductResultGUI(p);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
