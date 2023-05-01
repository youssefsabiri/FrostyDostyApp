package RemoteInterface;

import BusinessIntelligence.AddOrder;
import Database.MenuItem;
import Database.MenuList;
import Database.orderList;
import UserInterface.AddOrderGUI;

import javax.swing.*;
import java.awt.*;

public class AddOrderVerification {
	
	public void verify(String ProductName, String Quantity, orderList list, CardLayout contentCardLayout, JPanel contentPanel) {
		MenuItem a = MenuList.search(ProductName);
		if ((a.name.equals("not found"))){
			JOptionPane.showMessageDialog(null, "Item you entered does not exist in our menu! Please check the menu again and type in the item of your choice", "Error", JOptionPane.ERROR_MESSAGE);
			showAddOrderGUI(list, contentCardLayout, contentPanel);
	}
		else {
			 if (isNumeric(Quantity)) {
				 int q = Integer.valueOf(Quantity);
				 AddOrder o = new AddOrder();
				 o.orderVerified(q, a, list, contentCardLayout, contentPanel);
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Quantity must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
				 showAddOrderGUI(list, contentCardLayout, contentPanel);
			 }
		}
}
	
	private static void showAddOrderGUI(orderList list, CardLayout contentCardLayout, JPanel contentPanel) {
        AddOrderGUI addOrderGUI = new AddOrderGUI(list, contentCardLayout, contentPanel);
        JFrame adminFrame = new JFrame("Add Order GUI");
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