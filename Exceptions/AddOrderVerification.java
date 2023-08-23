package Exceptions;

import BusinessIntelligence.AddOrder;
import Database.SearchMenuItem;
import UserInterface.AddOrderGUI;

import javax.swing.*;
import java.awt.*;

public class AddOrderVerification {
	
	public void verify(String MenuItem, String Quantity, CardLayout contentCardLayout, JPanel contentPanel) {
		String a = SearchMenuItem.search(MenuItem);
		if ((a.equals("Not found"))){
			JOptionPane.showMessageDialog(null, "Item you entered does not exist in our menu! Please check the menu again and type in the item of your choice", "Error", JOptionPane.ERROR_MESSAGE);
			showAddOrderGUI(contentCardLayout, contentPanel);
	}
		else {
			 if (isNumeric(Quantity)) {
				 int q = Integer.valueOf(Quantity);
				 AddOrder o = new AddOrder();
				 o.orderVerified(q, a, contentCardLayout, contentPanel);
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Quantity must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
				 showAddOrderGUI(contentCardLayout, contentPanel);
			 }
		}
}
	
	private static void showAddOrderGUI(CardLayout contentCardLayout, JPanel contentPanel) {
        AddOrderGUI addOrderGUI = new AddOrderGUI(contentCardLayout, contentPanel);
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