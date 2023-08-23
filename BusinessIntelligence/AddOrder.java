package BusinessIntelligence;


import UserInterface.ClientOrdersGUI;

import javax.swing.*;

import Database.OrderCRUD;
import Database.TransactionClientCRUD;
import RemoteInterface.Main;

import java.awt.*;




public class AddOrder {
	
	public void orderVerified(int quantity, String item_details, CardLayout contentCardLayout, JPanel contentPanel) {
		String[] numbers = item_details.split(",");
		int item_code = Integer.parseInt(numbers[0]); 
		int item_price = Integer.parseInt(numbers[1]); 
		int amount = quantity*item_price;
		
		OrderCRUD.create(amount, quantity, item_code);
		TransactionClientCRUD.create(amount);
		
		Main.orders.add(101, "07-23-2023" , 50, "In Process");
		
		JOptionPane.showMessageDialog(null, "Your order was placed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		showOrdersGUI(contentCardLayout, contentPanel);
		
		
		
	}
	private static void showOrdersGUI(CardLayout contentCardLayout, JPanel contentPanel) {
		ClientOrdersGUI homeGUI = new ClientOrdersGUI(contentCardLayout, contentPanel);
		JFrame adminFrame = new JFrame("Home GUI");
		adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		adminFrame.setSize(800, 600);
		adminFrame.add(homeGUI);
		adminFrame.setVisible(true);
	}

}


 