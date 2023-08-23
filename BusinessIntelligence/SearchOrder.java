package BusinessIntelligence;

import UserInterface.SearchOrderGUI;
import UserInterface.SearchOrderResultGUI;

import javax.swing.*;

import Database.OrderCRUD;

public class SearchOrder {
	
	public void orderSearched(int code) {
		if (code>100) {
			JOptionPane.showMessageDialog(null, "Order Not Found!", "Error", JOptionPane.ERROR_MESSAGE);}

		else {
	        	order t = new order(code, "05-06-2023", 100, "Delivered");
	        	showResultGUI(t);}
		
		
		
	}
	
	private static void showSearchOrderGUI() {
        SearchOrderGUI deleteOrderGUI = new SearchOrderGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
	
	private static void showResultGUI(order order) {
        SearchOrderResultGUI deleteOrderGUI = new SearchOrderResultGUI(order);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
