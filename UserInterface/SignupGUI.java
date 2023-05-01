package UserInterface;

import BusinessIntelligence.Client;
import BusinessIntelligence.account;
import RemoteInterface.SignupVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignupGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public SignupGUI() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(1920, 1080));
        getContentPane().setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon(SignupGUI.class.getResource("frosty.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.add(imageLabel);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(105, 217, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 2, 5);

        formPanel.add(new JLabel("Full Name"), gbc);
        gbc.gridy++;
        JTextField fullNameField = new JTextField(20);
        formPanel.add(fullNameField, gbc);

        gbc.gridy++;
        formPanel.add(new JLabel("Phone Number"), gbc);
        gbc.gridy++;
        JTextField phoneNumberField = new JTextField(20);
        formPanel.add(phoneNumberField, gbc);

        gbc.gridy++;
        formPanel.add(new JLabel("Address"), gbc);
        gbc.gridy++;
        JTextField addressField = new JTextField(20);
        formPanel.add(addressField, gbc);

        gbc.gridy++;
        formPanel.add(new JLabel("Email"), gbc);
        gbc.gridy++;
        JTextField emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        gbc.gridy++;
        formPanel.add(new JLabel("Password"), gbc);
        gbc.gridy++;
        JPasswordField passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        JButton signUpButton = new JButton("Sign Up");
        formPanel.add(signUpButton, gbc);
        signUpButton.addActionListener(e -> {
            String fullname = fullNameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            
            SignupVerification v = new SignupVerification(this);
            v.verify(fullname, phoneNumber, address, email, password);
            
        });

        // Adjust the height of the blue section
        Dimension formPanelSize = formPanel.getPreferredSize();
        int newHeight = (int) (formPanelSize.getHeight() * 2.5);
        formPanel.setPreferredSize(new Dimension(formPanelSize.width, newHeight));

        gbc.gridx = 1;
        JLabel loginLink = new JLabel("<HTML><FONT color=\"#000099\"><U>Login here</U></FONT></HTML>");
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Open LoginGUI here
                account a = new account("blank", "blank");
            	Client cl = new Client("blank", "blank", "blank", a);
                LoginGUI loginGUI = new LoginGUI(cl);
                loginGUI.setVisible(true);
            }
        });
        formPanel.add(loginLink, gbc);


        JPanel pinkSection = new JPanel();
        pinkSection.setBackground(new Color(233, 30, 99));
        pinkSection.setLayout(new GridBagLayout());
        GridBagConstraints pinkGbc = new GridBagConstraints();
        pinkGbc.gridx = 0;
        pinkGbc.gridy = 0;
        pinkGbc.anchor = GridBagConstraints.CENTER;

        JLabel welcomeLabel = new JLabel("Welcome to our website!");
        welcomeLabel.setForeground(Color.WHITE);
        pinkSection.add(welcomeLabel, pinkGbc);
        pinkGbc.gridy++;

        JLabel frostyLabel = new JLabel("Frosty Dosty.");
        frostyLabel.setForeground(Color.WHITE);
        pinkSection.add(frostyLabel, pinkGbc);

        getContentPane().add(imagePanel, BorderLayout.NORTH);
        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(pinkSection, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sign Up");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.add(new SignupGUI());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
