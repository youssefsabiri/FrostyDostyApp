package UserInterface;

import javax.swing.*;

import Exceptions.ModifyProductVerification2;

import java.awt.*;
import java.awt.event.*;

public class ModifyProduct2GUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTextField amountField;
    private JButton enterButton;

    public ModifyProduct2GUI(int code) {
        // Set up the frame
        setTitle("Modify Product");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel titleLabel = new JLabel("Modify Product");
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
        JLabel transactionCodeLabel = new JLabel("Product Quantity:");
        transactionCodeLabel.setForeground(Color.WHITE);
        formPanel.add(transactionCodeLabel, gbc);



        gbc.gridy++;
        

        gbc.gridy = 1;
       

        

        // Add the amount field
        gbc.gridy++;
        amountField = new JTextField(20);
        formPanel.add(amountField, gbc);

        // Add the enter button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        enterButton = new JButton("Modify");
        enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterButton.setFont(new Font("Arial", Font.BOLD, 16));
        enterButton.setBackground(new Color(237, 52, 141));
        enterButton.setForeground(Color.WHITE);
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String new_quantity = amountField.getText();
                ModifyProductVerification2 dov = new ModifyProductVerification2();
                dov.verify(code, new_quantity);
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
    	int code = 0;
        ModifyProduct2GUI form = new ModifyProduct2GUI(code);
    }
}