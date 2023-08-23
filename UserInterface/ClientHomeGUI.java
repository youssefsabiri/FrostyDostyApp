package UserInterface;

import BusinessIntelligence.Client;
import BusinessIntelligence.Lists;
import BusinessIntelligence.account;
import Database.ClientCRUD;

import Database.clientInfo;
import Database.orderList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientHomeGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    public static final String HOME_PANEL = "Home";
    private static final String MENU_PANEL = "Menu";
    public static final String ORDER_HISTORY_PANEL = "OrderHistory";

    public ClientHomeGUI() {
        setTitle("Navigation Bar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon(ClientHomeGUI.class.getResource("cc.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        CardLayout contentCardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(contentCardLayout);
        contentPanel.add(createHomePanel(imagePanel, contentCardLayout, contentPanel), HOME_PANEL);
        contentPanel.add(ClientMenuGUI.createClientMenuGUI(this, contentCardLayout, contentPanel), MENU_PANEL);
        contentPanel.add(ClientOrdersGUI.createClientOrdersGUI(contentCardLayout, contentPanel), ORDER_HISTORY_PANEL);


        getContentPane().add(contentPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createHomePanel(JPanel imagePanel, CardLayout contentCardLayout, JPanel contentPanel) {
        JPanel homePanel = new JPanel(new BorderLayout());
        homePanel.setBackground(Color.BLACK);

        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.PINK);
        navPanel.setLayout(new GridLayout(1, 3));

        JButton menuButton = new JButton("My Menu");
        menuButton.setBackground(Color.PINK);
        menuButton.setForeground(Color.BLACK);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCardLayout.show(contentPanel, MENU_PANEL);
            }
        });
        navPanel.add(menuButton);

        JButton ordersButton = new JButton("Ordering");
        ordersButton.setBackground(Color.PINK);
        ordersButton.setForeground(Color.BLACK);
        ordersButton.addActionListener(e -> contentCardLayout.show(contentPanel, ORDER_HISTORY_PANEL));
        navPanel.add(ordersButton);

        JButton profileButton = new JButton("My Profile");
        profileButton.setBackground(Color.PINK);
        profileButton.setForeground(Color.BLACK);
        navPanel.add(profileButton);

        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	clientInfo cl = ClientCRUD.display();
                ClientProfileGUI clientProfile = new ClientProfileGUI(cl);
                // close the current window
            }
        });

        homePanel.add(navPanel, BorderLayout.NORTH);
        homePanel.add(imagePanel, BorderLayout.CENTER);
        return homePanel;
    }

    public static void main(String[] args) {

    	account a = new account("blank", "blank");
    	Client cl = new Client("blank", "blank", "blank", a);
        SwingUtilities.invokeLater(() -> new ClientHomeGUI());
    }
}
