package BusinessIntelligence;

import UserInterface.DeleteOrderGUI;

import javax.swing.*;

public class DeleteOrder {
	
	public void orderDeleted(int code) {
		order o = Main.orders.search(code);
		if (o.item.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Order Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showDeleteOrderGUI();
		}
		else {
			Main.orders.remove(o.orderCode);
			JOptionPane.showMessageDialog(null, "Order was deleted successfully from the Order History", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	private static void showDeleteOrderGUI() {
        DeleteOrderGUI deleteOrderGUI = new DeleteOrderGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
