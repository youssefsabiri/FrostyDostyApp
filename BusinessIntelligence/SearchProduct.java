package BusinessIntelligence;

import UserInterface.SearchProductGUI;
import UserInterface.SearchProductResultGUI;

import javax.swing.*;

public class SearchProduct {
	
	public void productSearched(int code) {
		product o = Main.products.search(code);
		if (o.Description.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showSearchOrderGUI();
		}
		else {
			showResultGUI(o);
		}
		
		
	}
	
	private static void showSearchOrderGUI() {
        SearchProductGUI deleteOrderGUI = new SearchProductGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
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
