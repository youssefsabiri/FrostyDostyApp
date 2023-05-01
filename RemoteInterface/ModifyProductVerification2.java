package RemoteInterface;

import BusinessIntelligence.ModifyProduct2;
import UserInterface.ModifyProduct2GUI;

import javax.swing.*;

public class ModifyProductVerification2 {
	
	public void verify(int code, String quantity) {
		if (isNumeric(quantity)){
			int c = Integer.valueOf(quantity);
			 ModifyProduct2 o = new ModifyProduct2();
			 o.productModified(code, c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Inventory Number must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showModifyProduct2GUI(code);	 
		 }
		}
	

	
	private static void showModifyProduct2GUI(int code) {
		ModifyProduct2GUI deleteOrderGUI = new ModifyProduct2GUI(code);
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
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
