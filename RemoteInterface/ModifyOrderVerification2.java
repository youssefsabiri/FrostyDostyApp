package RemoteInterface;

import BusinessIntelligence.ModifyOrder2;
import BusinessIntelligence.order;
import Database.MenuItem;
import Database.MenuList;
import UserInterface.ModifyOrder2GUI;

import javax.swing.*;

public class ModifyOrderVerification2 {
	
	public void verify(order old_order, String ItemName, String Quantity) {
		MenuItem a = MenuList.search(ItemName);
		if ((a.name.equals("not found"))){
			JOptionPane.showMessageDialog(null, "Item you entered does not exist in our menu! Please check the menu again and typr in the item of your choice", "Error", JOptionPane.ERROR_MESSAGE);
			showModifyOrder2GUI(old_order);
	}
		else {
			 if (isNumeric(Quantity)) {
				 int q = Integer.valueOf(Quantity);
				 ModifyOrder2 o = new ModifyOrder2();
				 o.orderModified(old_order, q, a);
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Quantity must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
				 showModifyOrder2GUI(old_order);	 
			 }
		}
}
	
	private static void showModifyOrder2GUI(order old_order) {
		ModifyOrder2GUI addOrderGUI = new ModifyOrder2GUI(old_order);
        JFrame adminFrame = new JFrame("Modify Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(addOrderGUI);
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