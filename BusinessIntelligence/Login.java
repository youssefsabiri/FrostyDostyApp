package BusinessIntelligence;

import UserInterface.AdminGUI;
import UserInterface.ClientHomeGUI;
import UserInterface.LoginHomeGUI;
import Database.ClientCRUD;
import RemoteInterface.Main;

import javax.swing.*;

public class Login {
    private JFrame parentFrame;

    public Login(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }



	public void Authenticate(String email, String password) {
		if (email.equals("R.fadili@gmail.com")) {
            if (password.equals("Admin123"))
                showAdminGUI();
            else {
                JOptionPane.showMessageDialog(null, "Password Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            }
		}
		
        String a = ClientCRUD.search(email);
        
        if (!a.equals("Not found")){ 
        	String[] credentials = a.split(",");
        	String password_found = credentials[1];
        	int clientID = Integer.parseInt(credentials[2]);
        	if (password.equals(password_found)) {
            	Main.clientID=clientID;
                showClientHomeGUI();
            }
            else {
                JOptionPane.showMessageDialog(null, "Password Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                showLoginHomeGUI(parentFrame);
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "User Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            showLoginHomeGUI(parentFrame);
        } 
    }

    

    private static void showAdminGUI() {
        AdminGUI adminGUI = new AdminGUI();
        JFrame adminFrame = new JFrame("Admin GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(adminGUI);
        adminFrame.setVisible(true);
    }

    private static void showClientHomeGUI() {
    	System.out.println("ClientID is :  " + Main.clientID);
        ClientHomeGUI clientGUI = new ClientHomeGUI();
        JFrame clientFrame = new JFrame("Client Home GUI");
        clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clientFrame.setSize(800, 600);
        clientFrame.add(clientGUI);
        clientFrame.setVisible(true);
    }

    private static void showLoginHomeGUI(JFrame parentFrame) {
        LoginHomeGUI loginHomeGUI = new LoginHomeGUI();
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(loginHomeGUI);
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}
