package UserInterface;


import BusinessIntelligence.Main;
import BusinessIntelligence.product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProductsGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable transactionsTable;
    private DefaultTableModel transactionsTableModel;

    public AdminProductsGUI() {
        // set up the JFrame
        setTitle("Product Inventory");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // set the background color of the content pane to black
        getContentPane().setBackground(Color.BLACK);

        // create the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(237, 52, 141));
        headerPanel.setPreferredSize(new Dimension(0, 80));
        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // create the "Order History" text label and center it in the header
        JLabel titleLabel = new JLabel("Product Inventory");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(titleLabel);

        // create navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.BLACK);
        navPanel.setLayout(new GridLayout(1, 4));
        getContentPane().add(navPanel, BorderLayout.NORTH);

        // create navigation buttons
        String[] navLabels = {"Add Product", "Modify Product", "Delete Product", "Search Product"};
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
                    if (label.equals("Add Product")) {
                        // create an instance of AddTransaction class and display it
                        AddProductGUI addProduct = new AddProductGUI();
                        addProduct.setVisible(true);
                    } else if (label.equals("Modify Product")) {
                        // create an instance of ModifyTransaction class and display it
                        ModifyProduct1GUI modifyProduct= new ModifyProduct1GUI();
                        modifyProduct.setVisible(true);
                    } else if (label.equals("Delete Product")) {
                        // create an instance of DeleteTransaction class and display it
                        DeleteProductGUI deleteProduct = new DeleteProductGUI();
                        deleteProduct.setVisible(true);
                    } else if (label.equals("Search Product")) {
                        // create an instance of SearchTransaction class and display it
                        SearchProductGUI searchProduct = new SearchProductGUI();
                        searchProduct.setVisible(true);
                    }
                }
            });
            navPanel.add(navButton);
        }


        // create the transactions table
        String[] columns = {"Inventory Number", "Article Description", "Purchase Price", "Quantity", "location"};
        
        transactionsTableModel = new DefaultTableModel(columns, 0);
        transactionsTable = new JTable(transactionsTableModel);
        
        populateTableWithProductData();

        // Set the preferred column width
        int[] columnWidths = {200, 200, 300, 100, 200, 200};
        for (int i = 0; i < transactionsTable.getColumnCount(); i++) {
            transactionsTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }

        // style the table
        transactionsTable.setPreferredScrollableViewportSize(new Dimension(1200, 150));
        transactionsTable.setFillsViewportHeight(true);
        transactionsTable.setAutoCreateRowSorter(true);
        transactionsTable.getTableHeader().setBackground(new Color(237, 52, 141));
        transactionsTable.getTableHeader().setForeground(Color.WHITE);
        transactionsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        transactionsTable.setRowHeight(25);
        transactionsTable.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(transactionsTable);
        // create a JLabel for the text
        JLabel userLabel = new JLabel("Current Inventory");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        // create a JPanel with a GridBagLayout
        // to center the JScrollPane and JLabel
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
        gbc.insets = new Insets(0, 0, 0, 0); // reset the insets
        panel.add(scrollPane, gbc);

        // add components to the content pane
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(headerPanel);
        getContentPane().add(navPanel);
        getContentPane().add(panel);

        // adjust the JFrame size to fit the enlarged table
        pack();

        // display the frame
        setVisible(true);
    }
    
    private void populateTableWithProductData() {
        for (product prod : Main.products.products) {
            Object[] rowData = {
                prod.inventoryNumber,
                prod.Description,
                prod.price,
                prod.quantity,
                prod.location
            };
            transactionsTableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        AdminProductsGUI gui = new AdminProductsGUI();
    }
    
}

