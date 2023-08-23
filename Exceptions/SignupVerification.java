package Exceptions;

import BusinessIntelligence.Signup;
import UserInterface.SignupGUI;

import javax.swing.*;

public class SignupVerification {

    private JFrame frameToUpdate;

    public SignupVerification(JFrame frameToUpdate) {
        this.frameToUpdate = frameToUpdate;
    }
    public void verify(String fullname, String phonenumber, String address, String email, String password) {
    	if (fullname.isEmpty() || phonenumber.isEmpty() || address.isEmpty() || email.isEmpty()|| password.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            showSignupGUI();
        } else if (email.contains("@") && isNumeric(phonenumber) && isValid(address)==true) { 
            Signup s = new Signup();
            s.signup(fullname, phonenumber, address, email, password);
        } else if (email.contains("@") && isNumeric(phonenumber)){
        	JOptionPane.showMessageDialog(null, "Invalid Address: Format should be 'Street,City' !", "Error", JOptionPane.ERROR_MESSAGE);
            showSignupGUI();
        } else if (isNumeric(phonenumber) && isValid(address)==true) {
        	JOptionPane.showMessageDialog(null, "Invalid Email!", "Error", JOptionPane.ERROR_MESSAGE);
            showSignupGUI();
        } else if (email.contains("@") && isValid(address)==true) {
        	JOptionPane.showMessageDialog(null, "Invalid Phone Number!", "Error", JOptionPane.ERROR_MESSAGE);
            showSignupGUI(); 
        } else {
        	JOptionPane.showMessageDialog(null, "Invalid Email & Phone Number & Address!", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    public static boolean isValid(String address) {
        // Regex pattern matches any string of characters that doesn't contain a comma,
        // followed by a comma, and then any string of characters that doesn't contain a comma
        return address.matches("^[^,]*,[^,]*$");
    }



}
