package BusinessIntelligence;

import javax.swing.*;

public class ModifyProduct2 {
	
	public void productModified(int code, int quantity) {
		product old_product = Main.products.search(code);
		product new_product = old_product;
		new_product.quantity=quantity;
		Main.products.update(old_product, new_product);
		JOptionPane.showMessageDialog(null, "The product was modified successfully in the inventory", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

}
