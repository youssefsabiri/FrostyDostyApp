package BusinessIntelligence;

import javax.swing.*;

import RemoteInterface.Main;

public class ModifyProduct2 {
	
	public void productModified(int code, int quantity) {
		Main.products.remove(code);
		Main.products.add(code, "Milk", 6, 20, 1, "Row 1");
		JOptionPane.showMessageDialog(null, "The product was modified successfully in the inventory", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

}
