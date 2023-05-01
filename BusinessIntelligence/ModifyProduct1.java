package BusinessIntelligence;

import UserInterface.ModifyProduct1GUI;
import UserInterface.ModifyProduct2GUI;

import javax.swing.*;

public class ModifyProduct1 {
	
	public void productSearched(int code) {
		product o = Main.products.search(code);
		if (o.Description.equals("not found")) {
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showModifyProduct1GUI();
		}
		else {
			showModifyProduct2GUI(o.inventoryNumber);
		}
		
		
	}
	
	private static void showModifyProduct1GUI() {
		ModifyProduct1GUI deleteOrderGUI = new ModifyProduct1GUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
	
	private static void showModifyProduct2GUI(int code) {
		ModifyProduct2GUI deleteOrderGUI = new ModifyProduct2GUI(code);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
