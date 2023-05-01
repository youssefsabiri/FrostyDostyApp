package RemoteInterface;

import BusinessIntelligence.ModifyProduct1;
import UserInterface.ModifyProduct1GUI;

import javax.swing.*;

public class ModifyProductVerification1 {
	
	public void verify(String code) {
		if (isNumeric(code)){
			int c = Integer.valueOf(code);
			 ModifyProduct1 o = new ModifyProduct1();
			 o.productSearched(c);
		}

		 else {
			 JOptionPane.showMessageDialog(null, "Inventory Number must be an integer!", "Error", JOptionPane.ERROR_MESSAGE);
			 showModifyProduct1GUI();	 
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
