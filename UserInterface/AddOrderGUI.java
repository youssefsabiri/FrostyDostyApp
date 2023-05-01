package UserInterface;

import BusinessIntelligence.Main;
import Database.Store;
import Database.orderList;
import RemoteInterface.AddOrderVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrderGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField productnameField;
    private JTextField quantityField;
    private JButton enterButton;

    public AddOrderGUI(orderList list, CardLayout contentCardLayout, JPanel contentPanel) {
        // Set up the frame
        setTitle("Product Name");
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
        JLabel titleLabel = new JLabel("Add Order");
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
        JLabel productnameLabel = new JLabel("Product Name:");
        productnameLabel.setForeground(Color.WHITE);
        formPanel.add(productnameLabel, gbc);



        gbc.gridy++;
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setForeground(Color.WHITE);
        formPanel.add(quantityLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        productnameField = new JTextField(20);
        formPanel.add(productnameField, gbc);

        

        // Add the amount field
        gbc.gridy++;
        quantityField = new JTextField(20);
        formPanel.add(quantityField, gbc);

        // Add the enter button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        enterButton = new JButton("Add Order");
        enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterButton.setFont(new Font("Arial", Font.BOLD, 16));
        enterButton.setBackground(new Color(237, 52, 141));
        enterButton.setForeground(Color.WHITE);
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String productname = productnameField.getText();
            	String quantity = quantityField.getText();
            	AddOrderVerification vr = new AddOrderVerification();
            	vr.verify(productname, quantity, list, contentCardLayout, contentPanel);
            	
            	
                // TODO: Handle the "Enter" button click
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
    	Store.loadMenu();
        CardLayout contentCardLayout = new CardLayout();
        JPanel contentPanel = new JPanel();
        AddOrderGUI form = new AddOrderGUI(Main.orders, contentCardLayout, contentPanel);
    }
}