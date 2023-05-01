package BusinessIntelligence;

import javax.swing.*;
import java.util.Random;




public class AddProduct {
	
	public void productVerified(String description, double price, int Quantity, String location) {
		Random random = new Random();
        int min = 0;
        int max = 10000;
        int inventoryNumber = random.nextInt(max - min + 1) + min;
		Main.products.add(inventoryNumber, description, price, Quantity, location);
		JOptionPane.showMessageDialog(null, "Your product was added successfully to the inventory", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

}
