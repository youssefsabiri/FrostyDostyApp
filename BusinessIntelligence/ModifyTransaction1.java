package BusinessIntelligence;


import UserInterface.ModifyTransaction2GUI;

import javax.swing.*;







public class ModifyTransaction1 {
	
	public void transactionSearched(int code) {
		if (code>1001) {
			JOptionPane.showMessageDialog(null, "Transaction Not Found!", "Error", JOptionPane.ERROR_MESSAGE);}

		else {
			showModifyTransaction2GUI(code);
			}
		
		
	}
	

	
	private static void showModifyTransaction2GUI(int code) {
		ModifyTransaction2GUI deleteOrderGUI = new ModifyTransaction2GUI(code);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }

}
