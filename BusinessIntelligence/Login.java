package BusinessIntelligence;

import UserInterface.AdminGUI;
import UserInterface.ClientHomeGUI;

import javax.swing.*;

public class Login {
    private JFrame parentFrame;

    public Login(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }



	public void Authenticate(String email, String password, Client cl) {
        account a = Main.accounts.search(email);
        if (email.equals("R.fadili@gmail.com")) {
            if (password.equals("Admin123"))
                showAdminGUI();
            else {
                JOptionPane.showMessageDialog(null, "Password Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                showLoginHomeGUI(parentFrame, cl);
            }
        } else if (a.login.equals("not found")) {
            JOptionPane.showMessageDialog(null, "User Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            showLoginHomeGUI(parentFrame, cl);
        } else if (email.equals(a.login) && password.equals(a.getPassword()))
            showClientHomeGUI(cl);
        else {
            JOptionPane.showMessageDialog(null, "Password Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            showLoginHomeGUI(parentFrame, cl);
        }
    }

    // Other methods remain the same

    private static void showAdminGUI() {
        AdminGUI adminGUI = new AdminGUI();
        JFrame adminFrame = new JFrame("Admin GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(adminGUI);
        adminFrame.setVisible(true);
    }

    private static void showClientHomeGUI(Client cl) {
        ClientHomeGUI clientGUI = new ClientHomeGUI(cl, Main.orders);
        JFrame clientFrame = new JFrame("Client Home GUI");
        clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clientFrame.setSize(800, 600);
        clientFrame.add(clientGUI);
        clientFrame.setVisible(true);
    }

    private static void showLoginHomeGUI(JFrame parentFrame, Client cl) {
        LoginHomeGUI loginHomeGUI = new LoginHomeGUI(cl);
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(loginHomeGUI);
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}
