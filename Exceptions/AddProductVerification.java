package Exceptions;

import BusinessIntelligence.AddProduct;
import UserInterface.AddProductGUI;

import javax.swing.*;



public class AddProductVerification {
	
	public void verify(String description, String price, String quantity, String location) {
		if (isNumeric2(price) && isNumeric(quantity) && !isNumeric(description) && !isNumeric(location)){
			AddProduct pr = new AddProduct();
			double price2 = Double.parseDouble(price);
			double location2 = Double.parseDouble(location);
			pr.productVerified(description, price2, location2, location);
			
			
		}
		else if (isNumeric2(price) && isNumeric(quantity) && !isNumeric(description) && isNumeric(location)) {
			JOptionPane.showMessageDialog(null, "Location must be a string!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (isNumeric2(price) && isNumeric(quantity) && !isNumeric(location) && isNumeric(description)){
			JOptionPane.showMessageDialog(null, "Description must be a string!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (isNumeric2(price) && !isNumeric(quantity) && !isNumeric(location) && !isNumeric(description)){
			JOptionPane.showMessageDialog(null, "Quantity must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Price must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
		}
}
	
	
	public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
	
	
	public static boolean isNumeric2(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double i = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
	
	private static void showAddProductGUI() {
        AddProductGUI addproductGUI = new AddProductGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(addproductGUI);
        adminFrame.setVisible(true);
    }
	

}
