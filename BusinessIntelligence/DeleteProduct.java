package BusinessIntelligence;



import javax.swing.*;

import RemoteInterface.Main;

public class DeleteProduct {
	
	public void orderDeleted(int code) {
		if (code>101){
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Main.products.remove(code);;
			JOptionPane.showMessageDialog(null, "Product was deleted successfully from the inventory", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	

}
