package UserInterface;

import RemoteInterface.AddProductVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddProductGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField priceField;
    private JTextField quantityField;
    private JTextField locationField;
    private JButton enterButton;

    public AddProductGUI() {
        // Set up the frame
        setTitle("New Transaction");
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
        JLabel titleLabel = new JLabel("Add Product");
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

        // Add the transaction code, date, and description fields


        gbc.gridy++;
        JLabel transactionDateLabel = new JLabel("Article Description:");
        transactionDateLabel.setForeground(Color.WHITE);
        formPanel.add(transactionDateLabel, gbc);

        gbc.gridy++;
        JLabel transactionLabel = new JLabel("Purchase Price:");
        transactionLabel.setForeground(Color.WHITE);
        formPanel.add(transactionLabel, gbc);

        gbc.gridy++;
        JLabel transactionAmountLabel = new JLabel("Quantity:");
        transactionAmountLabel.setForeground(Color.WHITE);
        formPanel.add(transactionAmountLabel, gbc);

        gbc.gridy++;
        JLabel transactionDiscountLabel = new JLabel("Location:");
        transactionDiscountLabel.setForeground(Color.WHITE);
        formPanel.add(transactionDiscountLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;


        gbc.gridy++;
        JTextField descriptionField = new JTextField(20);
        formPanel.add(descriptionField, gbc);

        gbc.gridy++;
        priceField = new JTextField(20);
        formPanel.add(priceField, gbc);

        // Add the amount field
        gbc.gridy++;
        quantityField = new JTextField(20);
        formPanel.add(quantityField, gbc);

        // Add the discount field
        gbc.gridy++;
        locationField = new JTextField(20);
        formPanel.add(locationField, gbc);

        // Add the enter button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        enterButton = new JButton("Add Product");
        enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterButton.setFont(new Font("Arial", Font.BOLD, 16));
        enterButton.setBackground(new Color(237, 52, 141));
        enterButton.setForeground(Color.WHITE);
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                String price = priceField.getText();
                String quantity = quantityField.getText();
                String location = locationField.getText();
                AddProductVerification pv = new AddProductVerification();
            	pv.verify(description, price, quantity, location);
            	
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
        AddProductGUI form = new AddProductGUI();
    }
}