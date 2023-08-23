package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientMenuGUI {
    private static JFrame frame;
    private static Color backgroundColor;
    private static CardLayout contentCardLayout;
    private static JPanel contentPanel;

    public static JPanel createClientMenuGUI(JFrame parentFrame, CardLayout cardLayout, JPanel panel) {
        frame = parentFrame;
        backgroundColor = new Color(105, 217, 255);
        contentCardLayout = cardLayout;
        contentPanel = panel;

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(backgroundColor);
        showMainMenu(mainPanel);

        return mainPanel;
    }

    private static void showMainMenu(JPanel mainPanel) {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());

        ImageIcon frostyImageIcon = new ImageIcon(ClientMenuGUI.class.getResource("frosty.png"));
        JLabel frostyImageLabel = new JLabel(frostyImageIcon);
        frostyImageLabel.setBackground(Color.BLACK);
        frostyImageLabel.setOpaque(true);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(backgroundColor);

        JButton backButton = new JButton("Go Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(backgroundColor);
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentCardLayout.show(contentPanel, ClientHomeGUI.HOME_PANEL);
            }
        });

        topPanel.add(backButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Frosty Dosty Menu");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBackground(backgroundColor);
        titleLabel.setOpaque(true);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        topPanel.add(titleLabel, BorderLayout.CENTER);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(backgroundColor);

        String[] buttonNames = {"Hot Drinks", "Cocktails", "Food", "Iced Coffee", "Tea"};
        for (String buttonName : buttonNames) {
            JButton button = new JButton(buttonName);
            button.setBackground(backgroundColor);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (buttonName.equals("Hot Drinks")) {
                        showHotDrinksMenu(mainPanel);
                    } else if (buttonName.equals("Cocktails")) {
                        showCocktailsMenu(mainPanel);
                    } else if (buttonName.equals("Food")) {
                        showFoodMenu(mainPanel);
                    } else if (buttonName.equals("Iced Coffee")) {
                        showIcedCoffeeMenu(mainPanel);
                    } else if (buttonName.equals("Tea")) {
                        showTeaMenu(mainPanel);
                    }
                }
            });
            buttonPanel.add(button);
        }

        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(frostyImageLabel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // ... (keep the existing showHotDrinksMenu, showCocktailsMenu, showFoodMenu, showIcedCoffeeMenu, and showTeaMenu methods the same)


    
    private static void showHotDrinksMenu(JPanel mainPanel) {
        ActionListener backActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu(mainPanel);
            }
        };

        JPanel hotDrinksPanel = MenuHotDrinksGUI.createHotDrinksPanel(backgroundColor, backActionListener);
        mainPanel.removeAll();
        mainPanel.add(hotDrinksPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    
    private static void showCocktailsMenu(JPanel mainPanel) {
        ActionListener backActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu(mainPanel);
            }
        };

        JPanel CocktailsPanel = MenuCocktailsGUI.createCocktailsPanel(backgroundColor, backActionListener);
        mainPanel.removeAll();
        mainPanel.add(CocktailsPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private static void showFoodMenu(JPanel mainPanel) {
        ActionListener backActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu(mainPanel);
            }
        };

        JPanel hotDrinksPanel = MenuFoodGUI.createHotDrinksPanel(backgroundColor, backActionListener);
        mainPanel.removeAll();
        mainPanel.add(hotDrinksPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private static void showIcedCoffeeMenu(JPanel mainPanel) {
        ActionListener backActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu(mainPanel);
            }
        };

        JPanel hotDrinksPanel = MenuIcedCoffeeGUI.createHotDrinksPanel(backgroundColor, backActionListener);
        mainPanel.removeAll();
        mainPanel.add(hotDrinksPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private static void showTeaMenu(JPanel mainPanel) {
        ActionListener backActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu(mainPanel);
            }
        };

        JPanel hotDrinksPanel = MenuTeaGUI.createHotDrinksPanel(backgroundColor, backActionListener);
        mainPanel.removeAll();
        mainPanel.add(hotDrinksPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
}
