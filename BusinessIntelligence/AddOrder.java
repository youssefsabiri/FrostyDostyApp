package BusinessIntelligence;

import Database.MenuItem;
import Database.orderList;
import UserInterface.ClientOrdersGUI;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;



public class AddOrder {
	
	public void orderVerified(int quantity, MenuItem item, orderList list, CardLayout contentCardLayout, JPanel contentPanel) {
		GregorianCalendar date = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date.getTime());
		Random random = new Random();
        int min = 0;
        int max = 10000;
        int code = random.nextInt(max - min + 1) + min;
		double amount = quantity*item.price;
		Main.orders.add(code, dateString, item.name, quantity);
		Main.transactions.Add(code, dateString, "Client Order" , amount, 0);
		JOptionPane.showMessageDialog(null, "Your order was placed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		showOrdersGUI(list, contentCardLayout, contentPanel);
		
		
		
	}
	private static void showOrdersGUI(orderList list, CardLayout contentCardLayout, JPanel contentPanel) {
		ClientOrdersGUI homeGUI = new ClientOrdersGUI(list, contentCardLayout, contentPanel);
		JFrame adminFrame = new JFrame("Home GUI");
		adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		adminFrame.setSize(800, 600);
		adminFrame.add(homeGUI);
		adminFrame.setVisible(true);
	}

}


 