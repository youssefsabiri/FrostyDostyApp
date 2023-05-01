package UserInterface;

import BusinessIntelligence.Client;
import BusinessIntelligence.account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientProfileGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public ClientProfileGUI(Client cl) {
        setTitle("User Profile");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridBagLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new GridBagLayout());
        add(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // set grid width to 2
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER; // set anchor to center

        JLabel headerLabel = new JLabel("Hello our lovely CLient!");
        headerLabel.setForeground(new Color(237, 52, 141));
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(headerLabel, gbc);

        gbc.gridwidth = 1; // reset grid width to 1

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setForeground(new Color(105, 217, 255));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(cl.fullname, 20);
        nameField.setBackground(mainPanel.getBackground());
        nameField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(nameField, gbc);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setForeground(new Color(105, 217, 255));
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(phoneLabel, gbc);

        JTextField phoneField = new JTextField(cl.phonenumber, 20);
        phoneField.setBackground(mainPanel.getBackground());
        phoneField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(phoneField, gbc);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(new Color(105, 217, 255));
        addressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(addressLabel, gbc);

        JTextField addressField = new JTextField(cl.address, 20);
        addressField.setBackground(mainPanel.getBackground());
        addressField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(addressField, gbc);

// Add anchor for the Address label to be on the left side
        gbc.anchor = GridBagConstraints.WEST;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(new Color(105, 217, 255));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(cl.account.login, 20);
        emailField.setBackground(mainPanel.getBackground());
        emailField.setForeground(Color.WHITE);
        gbc.gridx++;
        mainPanel.add(emailField, gbc);

        JLabel modifyPrompt = new JLabel("Click Here to:");
        modifyPrompt.setForeground(new Color(105, 217, 255));
        modifyPrompt.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(modifyPrompt, gbc);

        JButton modifyButton = new JButton("Modify account");
        modifyButton.setForeground(new Color(233, 30, 99));

        modifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx++;
        mainPanel.add(modifyButton, gbc);

        // Add action listener to modifyButton
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientModifyProfileGUI(cl);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
    	account a = new account("blank", "blank");
    	Client cl = new Client("blank", "blank", "blank", a);
        new ClientProfileGUI(cl);
    }
}