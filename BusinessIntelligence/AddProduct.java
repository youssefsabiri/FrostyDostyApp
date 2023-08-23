package BusinessIntelligence;

import javax.swing.*;

import Exceptions.Main;





public class AddProduct {
	
	public void productVerified(String description, double price, double quantity, String location) {
		Main.products.add(101, description, price, quantity, 1,location);
		JOptionPane.showMessageDialog(null, "Your product was added successfully to the inventory", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

}
