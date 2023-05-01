package UserInterface;

import BusinessIntelligence.Main;
import BusinessIntelligence.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminTransactionsGUI extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable transactionsTable;
    private DefaultTableModel transactionsTableModel;

    public AdminTransactionsGUI() {
        setLayout(new BorderLayout());
        // create the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(237, 52, 141));
        headerPanel.setPreferredSize(new Dimension(0, 80));
        add(headerPanel, BorderLayout.NORTH);

        // create the "Transaction Management" text label and center it in the header
        JLabel titleLabel = new JLabel("Transaction Management");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(titleLabel);

        // create navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.BLACK);
        navPanel.setLayout(new GridLayout(1, 4));
        add(navPanel, BorderLayout.CENTER);

        // create navigation buttons
        String[] navLabels = {"Add Transaction", "Modify Transaction", "Delete Transaction", "Search Transaction"};

        for (String label : navLabels) {
            JButton navButton = new JButton(label);
            navButton.setForeground(Color.WHITE);
            navButton.setBackground(Color.BLACK);
            navButton.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));
            navButton.setFocusPainted(false);
            navButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // determine which button was clicked
                    if (label.equals("Add Transaction")) {
                        // create an instance of AddTransaction class and display it
                        AddTransactionGUI addTransaction = new AddTransactionGUI();
                        addTransaction.setVisible(true);
                    } else if (label.equals("Modify Transaction")) {
                        // create an instance of ModifyTransaction class and display it
                        ModifyTransaction1GUI modifyTransaction = new ModifyTransaction1GUI();
                        modifyTransaction.setVisible(true);
                    } else if (label.equals("Delete Transaction")) {
                        // create an instance of DeleteTransaction class and display it
                        DeleteTransactionGUI deleteTransaction = new DeleteTransactionGUI();
                        deleteTransaction.setVisible(true);
                    } else if (label.equals("Search Transaction")) {
                        // create an instance of SearchTransaction class and display it
                        SearchTransactionGUI searchTransaction = new SearchTransactionGUI();
                        searchTransaction.setVisible(true);
                    }
                }
            });
            navPanel.add(navButton);
        }


        // create the transactions table
        String[] columns = {"Transaction Code", "Date", "Transaction", "Amount"};
        
        transactionsTableModel = new DefaultTableModel(columns, 0);
        transactionsTable = new JTable(transactionsTableModel);
        
        populateTableWithProductData();
        // style the table
        transactionsTable.setPreferredScrollableViewportSize(new Dimension(700, 150));
        transactionsTable.setFillsViewportHeight(true);
        transactionsTable.setAutoCreateRowSorter(true);
        transactionsTable.getTableHeader().setBackground(new Color(237, 52, 141));
        transactionsTable.getTableHeader().setForeground(Color.WHITE);
        transactionsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        transactionsTable.setRowHeight(25);
        transactionsTable.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(transactionsTable);

        // create a JLabel for the text
        JLabel userLabel = new JLabel("Here are your latest transactions, Mr. Riyad!");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // create a JPanel with a GridBagLayout to center the JScrollPane and JLabel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();

        // position the userLabel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 0, 10, 0); // add space above the label
        panel.add(userLabel, gbc);

        // position the scrollPane
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(scrollPane,gbc);
    // add components to the content pane
    add(panel, BorderLayout.SOUTH);
}
    
    
    private void populateTableWithProductData() {
        for (Transaction trans : Main.transactions.transactions) {
            Object[] rowData = {
            		trans.code,
            		trans.transaction_date,
            		trans.description,
            		trans.amount,
            };
            transactionsTableModel.addRow(rowData);
        }
    }
    
    
}