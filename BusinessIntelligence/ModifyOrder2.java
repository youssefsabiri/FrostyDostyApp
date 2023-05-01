package BusinessIntelligence;


import Database.MenuItem;

import javax.swing.*;

public class ModifyOrder2 {
	
	
	public void orderModified(order old_order, int quantity, MenuItem item) {
		order new_order = old_order;
		new_order.item = item.name;
		new_order.quantity = quantity;
		double amount = quantity*item.price;
		Transaction old_Transaction = Main.transactions.search(old_order.orderCode);
		Transaction new_Transaction = old_Transaction;
		new_Transaction.amount = amount;
		Main.orders.update(old_order.orderCode, new_order);
		Main.transactions.update(old_Transaction, new_Transaction);
		JOptionPane.showMessageDialog(null, "Your order was modified successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		
	}

		//Main.orders.update(code, null);
		
	

}
