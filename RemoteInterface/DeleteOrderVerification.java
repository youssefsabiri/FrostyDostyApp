package RemoteInterface;

import BusinessIntelligence.DeleteOrder;
import UserInterface.DeleteOrderGUI;

import javax.swing.*;

public class DeleteOrderVerification {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 DeleteOrder o = new DeleteOrder();
			 o.orderDeleted(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Order Code must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showDeleteOrderGUI();	 
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
