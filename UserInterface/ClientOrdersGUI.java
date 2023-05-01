package UserInterface;

import BusinessIntelligence.order;
import Database.orderList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientOrdersGUI extends JFrame {
    private static JTable transactionsTable;
    private static DefaultTableModel transactionsTableModel;
    private static final long serialVersionUID = 1L;

    public ClientOrdersGUI(orderList list, CardLayout contentCardLayout, JPanel contentPanel) {
        setTitle("Order History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel ordersPanel = createClientOrdersGUI(list, contentCardLayout, contentPanel);
        add(ordersPanel, BorderLayout.CENTER);

        // set frame size to fill the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        setVisible(true);
    }

    public static JPanel createClientOrdersGUI(orderList list, CardLayout contentCardLayout, JPanel contentPanel) {
        JPanel ordersPanel = new JPanel(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(237, 52, 141));
        headerPanel.setPreferredSize(new Dimension(0, 80));
        ordersPanel.add(headerPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Order History");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        JButton goBackButton = new JButton("Go back");
        goBackButton.addActionListener(e -> contentCardLayout.show(contentPanel, ClientHomeGUI.HOME_PANEL));
        goBackButton.setBackground(new Color(237, 52, 141));
        goBackButton.setForeground(Color.BLACK);
        goBackButton.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));
        headerPanel.add(goBackButton, BorderLayout.WEST);

        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.BLACK);
        navPanel.setLayout(new GridLayout(1, 4));
        navPanel.setPreferredSize(new Dimension(0, 25));
        ordersPanel.add(navPanel, BorderLayout.CENTER);

        String[] navLabels = {"Add Order", "Modify Order", "Delete Order", "Search Order"};
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
                    if (label.equals("Add Order")) {
                        // create an instance of AddTransaction class and display it
                        AddOrderGUI addOrder = new AddOrderGUI(list, contentCardLayout, contentPanel);
                        addOrder.setVisible(true);
                    } else if (label.equals("Modify Order")) {
                        // create an instance of ModifyTransaction class and display it
                        ModifyOrder1GUI modifyOrder = new ModifyOrder1GUI();
                        modifyOrder.setVisible(true);
                    } else if (label.equals("Delete Order")) {
                        // create an instance of DeleteTransaction class and display it
                        DeleteOrderGUI deleteOrder = new DeleteOrderGUI();
                        deleteOrder.setVisible(true);
                    } else if (label.equals("Search Order")) {
                        // create an instance of SearchTransaction class and display it
                        SearchOrderGUI searchOrder = new SearchOrderGUI();
                        searchOrder.setVisible(true);
                    }
                }
            });
            navPanel.add(navButton);
        }
        String[] columns = {"Order Code", "Date", "Items", "Quantity"};
        transactionsTableModel = new DefaultTableModel(columns, 0);
        transactionsTable = new JTable(transactionsTableModel);
        
        populateTableWithOrderData(list);

        int[] columnWidths = {200, 200, 300, 100, 200};
        for (int i = 0; i < transactionsTable.getColumnCount(); i++) {
            transactionsTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }

        transactionsTable.setPreferredScrollableViewportSize(new Dimension(1200, 150));
        transactionsTable.setFillsViewportHeight(true);
        transactionsTable.setAutoCreateRowSorter(true);
        transactionsTable.getTableHeader().setBackground(new Color(237, 52, 141));
        transactionsTable.getTableHeader().setForeground(Color.WHITE);
        transactionsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        transactionsTable.setRowHeight(25);
        transactionsTable.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(transactionsTable);

        JLabel userLabel = new JLabel("Here Are Your Latest Orders");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 0, 10, 0);
        panel.add(userLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(scrollPane, gbc);

        ordersPanel.add(panel, BorderLayout.SOUTH);
        return ordersPanel;
    }

    private static void populateTableWithOrderData(orderList list) {
        transactionsTableModel.setRowCount(0); // Clear existing rows in the table

        for (order ord : list.orders) {
            System.out.println("Adding order to table: " + ord.toString()); // debug statement
            Object[] rowData = {
                    ord.orderCode,
                    ord.transaction_date,
                    ord.item,
                    ord.quantity
            };
            transactionsTableModel.addRow(rowData);
        }
    }




}
