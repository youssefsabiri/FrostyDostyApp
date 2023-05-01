package BusinessIntelligence;

import UserInterface.DeleteProductGUI;

import javax.swing.*;

public class DeleteProduct {
	
	public void orderDeleted(int code) {
		product o = Main.products.search(code);
		if (o.Description.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showDeleteProductGUI();
		}
		else {
			Main.products.remove(o.inventoryNumber);
			JOptionPane.showMessageDialog(null, "Product was deleted successfully from the Inventory", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	private static void showDeleteProductGUI() {
        DeleteProductGUI deleteOrderGUI = new DeleteProductGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
