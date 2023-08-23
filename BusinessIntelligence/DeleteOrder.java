package BusinessIntelligence;

import UserInterface.DeleteOrderGUI;

import javax.swing.*;

import Database.OrderCRUD;
import Exceptions.Main;

public class DeleteOrder {
	
	public void orderDeleted(int code) {
		if (code>101){
			JOptionPane.showMessageDialog(null, "Order Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Main.orders.remove(code);;
			JOptionPane.showMessageDialog(null, "Order was canceled successfully from the inventory", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	

}
