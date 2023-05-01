package RemoteInterface;

import BusinessIntelligence.AddProduct;
import UserInterface.AddProductGUI;

import javax.swing.*;



public class AddProductVerification {
	
	public void verify(String description, String price, String Quantity, String location) {
		if (isNumeric2(price) && isNumeric(Quantity)){
			Double p = Double.valueOf(price);
			int q = Integer.valueOf(Quantity);
			AddProduct pr = new AddProduct();
			pr.productVerified(description, p, q, location);
	}
		else if (isNumeric2(price)==false && isNumeric(Quantity)==false) {
			JOptionPane.showMessageDialog(null, "Quantity must be an integer, and Price must be a double!", "Error", JOptionPane.ERROR_MESSAGE);
			 showAddProductGUI();	
		}
		else {
			 if (isNumeric2(price)) {
				 JOptionPane.showMessageDialog(null, "Quantity must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
				 showAddProductGUI();	
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Price must be a double!", "Error", JOptionPane.ERROR_MESSAGE);
				 showAddProductGUI();	 
			 }
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
