package UserInterface;

import RemoteInterface.AddTransactionVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddTransactionGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField amountField;
    private JTextField discountField;
    private JButton enterButton;

    public AddTransactionGUI() {
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
        JLabel titleLabel = new JLabel("Add Transaction");
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
        JLabel transactionLabel = new JLabel("Transaction Name:");
        transactionLabel.setForeground(Color.WHITE);
        formPanel.add(transactionLabel, gbc);

        gbc.gridy++;
        JLabel transactionAmountLabel = new JLabel("Transaction Amount:");
        transactionAmountLabel.setForeground(Color.WHITE);
        formPanel.add(transactionAmountLabel, gbc);

        gbc.gridy++;
        JLabel transactionDiscountLabel = new JLabel("Client Discount:");
        transactionDiscountLabel.setForeground(Color.WHITE);
        formPanel.add(transactionDiscountLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;



        gbc.gridy++;
        nameField = new JTextField(20);
        formPanel.add(nameField, gbc);

        // Add the amount field
        gbc.gridy++;
        amountField = new JTextField(20);
        formPanel.add(amountField, gbc);

        // Add the discount field
        gbc.gridy++;
        discountField = new JTextField(20);
        formPanel.add(discountField, gbc);

        // Add the enter button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        enterButton = new JButton("Enter");
        enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterButton.setFont(new Font("Arial", Font.BOLD, 16));
        enterButton.setBackground(new Color(237, 52, 141));
        enterButton.setForeground(Color.WHITE);
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String amount = amountField.getText();
                String discount = discountField.getText();
                AddTransactionVerification tv = new AddTransactionVerification();
                tv.verify(name, amount, discount);
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
        AddTransactionGUI form = new AddTransactionGUI();
    }
}
