package UserInterface;

import BusinessIntelligence.Transaction;

import javax.swing.*;
import java.awt.*;


public class SearchTransactionResultGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public SearchTransactionResultGUI(Transaction t) {
    	//t.code
    	//t.description
    	//t.amount
    	//t.transaction_date
    	//t.discount
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

        JLabel headerLabel = new JLabel("Full Info about the transaction you searched for: ");
        headerLabel.setForeground(new Color(237, 52, 141));
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(headerLabel, gbc);

        gbc.gridwidth = 1; // reset grid width to 1

        JLabel nameLabel = new JLabel("Transaction Code:");
        nameLabel.setForeground(new Color(105, 217, 255));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(nameLabel, gbc);
        
        String ordercode=Integer.toString(t.code);
        JTextField nameField = new JTextField(ordercode, 20);
        nameField.setBackground(mainPanel.getBackground());
        nameField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(nameField, gbc);



        JLabel addressLabel = new JLabel("Transaction Type:");
        addressLabel.setForeground(new Color(105, 217, 255));
        addressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(addressLabel, gbc);
        
       
        String amount=t.description;
        JTextField addressField = new JTextField(amount, 20);
        addressField.setBackground(mainPanel.getBackground());
        addressField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(addressField, gbc);

// Add anchor for the Address label to be on the left side
        JLabel date2Label = new JLabel("Transaction Date:");
        date2Label.setForeground(new Color(105, 217, 255));
        date2Label.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(date2Label, gbc);
        
       
        String date=t.date;
        JTextField date2Field = new JTextField(date, 20);
        date2Field.setBackground(mainPanel.getBackground());
        date2Field.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(date2Field, gbc);
        
        
        
        gbc.anchor = GridBagConstraints.WEST;
        JLabel emailLabel = new JLabel("Transaction Amount:");
        emailLabel.setForeground(new Color(105, 217, 255));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(emailLabel, gbc);

        JTextField dateField = new JTextField(t.amount, 20);
        dateField.setBackground(mainPanel.getBackground());
        dateField.setForeground(Color.WHITE);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST; // align field to right
        mainPanel.add(dateField, gbc);
        
        JLabel priceLabel = new JLabel("Receiver ID (Employee or Supplier):");
        priceLabel.setForeground(new Color(105, 217, 255));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // align label to left
        mainPanel.add(priceLabel, gbc);
        
        
        JTextField priceField = new JTextField(t.discount, 20);
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