package UserInterface;

import BusinessIntelligence.product;

import javax.swing.*;
import java.awt.*;


public class SearchProductResultGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public SearchProductResultGUI(product p) {
    	//p.inventoryNumber
    	//p.Description
    	//p.quantity
    	//p.location
    	//p.price
        setTitle("Search Results");
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

        JLabel headerLabel = new JLabel("Full Info about the product you searched for: ");
        headerLabel.setForeground(new Color(237, 52, 141));
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(headerLabel, gbc);

        gbc.gridwidth = 1; // reset grid width to 1

        JLabel nameLabel = new JLabel("Product Code:");
        nameLabel.setForeground(new Color(105, 217, 255));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(nameLabel, gbc);
        
        String ordercode=Integer.toString(p.inventoryNumber);
        JTextField nameField = new JTextField(ordercode, 20);
        nameField.setBackground(mainPanel.getBackground());
        nameField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(nameField, gbc);

        JLabel phoneLabel = new JLabel("Product Name:");
        phoneLabel.setForeground(new Color(105, 217, 255));
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(phoneLabel, gbc);

        JTextField phoneField = new JTextField(p.name, 20);
        phoneField.setBackground(mainPanel.getBackground());
        phoneField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(phoneField, gbc);

        JLabel addressLabel = new JLabel("Quantity:");
        addressLabel.setForeground(new Color(105, 217, 255));
        addressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(addressLabel, gbc);
        
        
        String quantity=Double.toString(p.quantity);
        JTextField addressField = new JTextField(quantity, 20);
        addressField.setBackground(mainPanel.getBackground());
        addressField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(addressField, gbc);
        
        
        JLabel minLabel = new JLabel("Min Quantity Threshold:");
        minLabel.setForeground(new Color(105, 217, 255));
        minLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(minLabel, gbc);
        
        
        String min=Double.toString(p.min);
        JTextField minField = new JTextField(min, 20);
        minField.setBackground(mainPanel.getBackground());
        minField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(minField, gbc);

// Add anchor for the Address label to be on the left side
        gbc.anchor = GridBagConstraints.WEST;
        JLabel emailLabel = new JLabel("Location");
        emailLabel.setForeground(new Color(105, 217, 255));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(emailLabel, gbc);

        JTextField dateField = new JTextField(p.location, 20);
        dateField.setBackground(mainPanel.getBackground());
        dateField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(dateField, gbc);
        
        JLabel priceLabel = new JLabel("Purchase Price:");
        priceLabel.setForeground(new Color(105, 217, 255));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(priceLabel, gbc);
        
        
        String price=Double.toString(p.price);
        JTextField priceField = new JTextField(price, 20);
        priceField.setBackground(mainPanel.getBackground());
        priceField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(priceField, gbc);
        
        

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Main method
    
}