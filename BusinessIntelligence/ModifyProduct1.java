package BusinessIntelligence;

import UserInterface.ModifyProduct1GUI;
import UserInterface.ModifyProduct2GUI;

import javax.swing.*;

public class ModifyProduct1 {
	
	public void productSearched(int code) {

		if (code>101) {
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);}

		else {
			showModifyProduct2GUI(code);
			}
		
		
	}
	
	private static void showModifyProduct1GUI() {
		ModifyProduct1GUI deleteOrderGUI = new ModifyProduct1GUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
	
	private static void showModifyProduct2GUI(int code) {
		ModifyProduct2GUI deleteOrderGUI = new ModifyProduct2GUI(code);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
