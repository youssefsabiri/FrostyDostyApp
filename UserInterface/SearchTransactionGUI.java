package UserInterface;

import RemoteInterface.SearchTransactionVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchTransactionGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField transactionCodeField;
    private JButton enterButton;

    public SearchTransactionGUI() {
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
        JLabel titleLabel = new JLabel("Search Transactions");
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

        // Add the transaction code field
        JLabel transactionCodeLabel = new JLabel("Transaction Code:");
        transactionCodeLabel.setForeground(Color.WHITE);
        formPanel.add(transactionCodeLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        transactionCodeField = new JTextField(20);
        formPanel.add(transactionCodeField, gbc);

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
            	String code = transactionCodeField.getText();
                SearchTransactionVerification dov = new SearchTransactionVerification();
                dov.verify(code);
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
        SearchTransactionGUI form = new SearchTransactionGUI();
    }
}
