package UserInterface;

import BusinessIntelligence.Client;
import BusinessIntelligence.account;
import Exceptions.ModifyClientProfileVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientModifyProfileGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField phoneField;
    private JTextField transactionField;
    private JTextField cityField, pass2Field, streetField;
    private JButton enterButton;

    public ClientModifyProfileGUI() {
        // Set up the frame
        setTitle("Modify Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        // Set up the form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Add the title label
        JLabel titleLabel = new JLabel("Account Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 5, 15, 5);
        formPanel.add(titleLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        gbc.gridy++;

        gbc.gridy++;
        JLabel transactionLabel = new JLabel("New Password:");
        transactionLabel.setForeground(Color.WHITE);
        formPanel.add(transactionLabel, gbc);

        gbc.gridy++;
        JLabel transactionAmountLabel = new JLabel("Confirm New Password:");
        transactionAmountLabel.setForeground(Color.WHITE);
        formPanel.add(transactionAmountLabel, gbc);
        gbc.gridy++;
        JLabel transactionAmountLabe2 = new JLabel("New City:");
		transactionAmountLabe2.setForeground(Color.WHITE);
        formPanel.add(transactionAmountLabe2, gbc);
        gbc.gridy++;
        JLabel transactionAmountLabe3 = new JLabel("New Street:");
        transactionAmountLabe3.setForeground(Color.WHITE);
        formPanel.add(transactionAmountLabe3, gbc);
        gbc.gridy++;
        JLabel transactionAmountLabel9 = new JLabel("New Phone Number:");
		transactionAmountLabel9.setForeground(Color.WHITE);
		formPanel.add(transactionAmountLabel9, gbc);
        gbc.gridy++;
        gbc.gridy = 1;
        gbc.gridx = 1;
        

        gbc.gridy++;
        transactionField = new JTextField(20);
        formPanel.add(transactionField, gbc);

        // Add the amount field
        gbc.gridy++;
        pass2Field = new JTextField(20);
        formPanel.add(pass2Field, gbc);
        gbc.gridy++;
        cityField = new JTextField(20);
        formPanel.add(cityField, gbc);
        gbc.gridy++;
        streetField = new JTextField(20);
        formPanel.add(streetField, gbc);
        gbc.gridy++;
        phoneField = new JTextField(20);
        formPanel.add(phoneField, gbc);
        // Add the enter button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        enterButton = new JButton("Save Changes");
        enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterButton.setFont(new Font("Arial", Font.BOLD, 16));
        enterButton.setBackground(new Color(237, 52, 141));
        enterButton.setForeground(Color.WHITE);
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password1 = transactionField.getText();
                String password2 = pass2Field.getText();
                String city = cityField.getText();
                String street = streetField.getText();
                String phone = phoneField.getText();
                ModifyClientProfileVerification pr = new ModifyClientProfileVerification();
                pr.verify(password1, password2, city, street, phone);
                
            }
        });
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);
        gbc.gridy++;
        formPanel.add(enterButton, gbc);

        // Add the form panel to the frame
        add(formPanel, BorderLayout.CENTER);

        // Set the background color of the JFrame
        getContentPane().setBackground(Color.BLACK);

        // Pack and show the frame
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        ClientModifyProfileGUI form = new ClientModifyProfileGUI();
    }
}