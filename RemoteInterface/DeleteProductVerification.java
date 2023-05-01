package RemoteInterface;

import BusinessIntelligence.DeleteProduct;
import UserInterface.DeleteProductGUI;

import javax.swing.*;

public class DeleteProductVerification {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 DeleteProduct o = new DeleteProduct();
			 o.orderDeleted(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Inventory Number must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showDeleteProductGUI();	 
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
}
