package UserInterface;

import BusinessIntelligence.Client;
import BusinessIntelligence.Login;
import BusinessIntelligence.account;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public JFrame frame;
    public LoginGUI(Client cl) {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(LoginGUI.class.getResource("frosty.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.add(imageLabel);

        getContentPane().add(imagePanel, BorderLayout.NORTH);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(new Color(105, 217, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            Login login = new Login(frame); // Pass the parent JFrame here
     
            login.Authenticate(email, password, cl);
            
        });



        JLabel signUpLabel = new JLabel("If you do not have an account please ");
        signUpLabel.setHorizontalAlignment(JLabel.RIGHT);
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> {
            SignupGUI signupGUI = new SignupGUI();
            signupGUI.setVisible(true);
        });
        // Add sign-up logic here

        loginPanel.add(Box.createRigidArea(new Dimension(0, 5)), gbc); // Add a 5px gap above the email field
        loginPanel.add(emailLabel, gbc);
        loginPanel.add(emailField, gbc);
        loginPanel.add(passwordLabel, gbc);
        loginPanel.add(passwordField, gbc);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 3)), gbc); // Add a 3px gap below the password field
        loginPanel.add(loginButton, gbc);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 3)), gbc); // Add a 3px gap below the login button
        loginPanel.add(signUpLabel);
        loginPanel.add(signUpButton);

        getContentPane().add(loginPanel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(233, 30, 99));
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints infoGbc = new GridBagConstraints();
        infoGbc.gridwidth = GridBagConstraints.REMAINDER;
        infoGbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Welcome to our website!");
        titleLabel.setForeground(Color.WHITE);

        JLabel frostyLabel = new JLabel("Frosty Dosty.");
        frostyLabel.setForeground(Color.WHITE);

        infoPanel.add(titleLabel, infoGbc);
        infoPanel.add(frostyLabel, infoGbc);

        getContentPane().add(infoPanel, BorderLayout.SOUTH);

        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	account a = new account("blank", "blank");
    	Client cl = new Client("blank", "blank", "blank", a);
        SwingUtilities.invokeLater(() -> new LoginGUI(cl));
    }
}