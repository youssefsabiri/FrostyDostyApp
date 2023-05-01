package BusinessIntelligence;

import UserInterface.ModifyOrder1GUI;
import UserInterface.ModifyOrder2GUI;

import javax.swing.*;

public class ModifyOrder1 {
	
	public void orderSearched(int code) {
		order o = Main.orders.search(code);
		if (o.item.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Order Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showModifyOrder1GUI();
		}
		else {
			showModifyOrder2GUI(o);
		}
		
		
	}
	
	private static void showModifyOrder1GUI() {
        ModifyOrder1GUI deleteOrderGUI = new ModifyOrder1GUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
	
	private static void showModifyOrder2GUI(order order) {
        ModifyOrder2GUI deleteOrderGUI = new ModifyOrder2GUI(order);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
