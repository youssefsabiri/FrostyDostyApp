package BusinessIntelligence;

import UserInterface.SearchOrderGUI;
import UserInterface.SearchOrderResultGUI;

import javax.swing.*;

public class SearchOrder {
	
	public void orderSearched(int code) {
		order o = Main.orders.search(code);
		if (o.item.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Order Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showSearchOrderGUI();
		}
		else {
			showResultGUI(o);
		}
		
		
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
