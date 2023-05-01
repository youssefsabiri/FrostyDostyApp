package RemoteInterface;

import BusinessIntelligence.Signup;
import UserInterface.SignupGUI;

import javax.swing.*;

public class SignupVerification {

    private JFrame frameToUpdate;

    public SignupVerification(JFrame frameToUpdate) {
        this.frameToUpdate = frameToUpdate;
    }
    public void verify(String fullname, String phonenumber, String addresss, String email, String password) {
        if (email.contains("@gmail.com") && isNumeric(phonenumber)) { 
            Signup s = new Signup();
            s.signup(fullname, phonenumber, addresss, email, password);
        } else if (isNumeric(phonenumber)){
        	JOptionPane.showMessageDialog(null, "Invalid Email !", "Error", JOptionPane.ERROR_MESSAGE);
            showSignupGUI();
        } else if (email.contains("@gmail.com")) {
        	JOptionPane.showMessageDialog(null, "Invalid Phone Number !", "Error", JOptionPane.ERROR_MESSAGE);
            showSignupGUI();
        } else {
        	JOptionPane.showMessageDialog(null, "Invalid Email & Phone Number!", "Error", JOptionPane.ERROR_MESSAGE);
            showSignupGUI();
        }
    }

    private void showSignupGUI() {
        SignupGUI signupGUI = new SignupGUI();
        frameToUpdate.getContentPane().removeAll();
        frameToUpdate.getContentPane().add(signupGUI);
        frameToUpdate.revalidate();
        frameToUpdate.repaint();
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
