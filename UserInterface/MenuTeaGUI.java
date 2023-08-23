package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuTeaGUI {

	public static JPanel createHotDrinksPanel(Color backgroundColor, ActionListener backActionListener) {
	    JPanel hotDrinksPanel = new JPanel(new BorderLayout());
	    hotDrinksPanel.setBackground(backgroundColor);

	    ImageIcon hotDrinksImageIcon = new ImageIcon(MenuHotDrinksGUI.class.getResource("tea.png"));
	    JLabel hotDrinksImageLabel = new JLabel(hotDrinksImageIcon);
	    hotDrinksImageLabel.setBackground(Color.BLACK);
	    hotDrinksImageLabel.setOpaque(true);

	    hotDrinksPanel.add(hotDrinksImageLabel, BorderLayout.CENTER);

	    JPanel topPanel = new JPanel(new BorderLayout());
	    topPanel.setBackground(backgroundColor);

	    JButton backButton = new JButton("Go Back");
	    backButton.setFont(new Font("Arial", Font.BOLD, 16));
	    backButton.setBackground(backgroundColor);
	    backButton.setForeground(Color.BLACK);
	    backButton.setFocusPainted(false);
	    backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	    backButton.addActionListener(backActionListener);

	    topPanel.add(backButton, BorderLayout.WEST);

	    JLabel titleLabel = new JLabel("Tea Menu");
	    titleLabel.setHorizontalAlignment(JLabel.CENTER);
	    titleLabel.setForeground(Color.BLACK);
	    titleLabel.setBackground(backgroundColor);
	    titleLabel.setOpaque(true);
	    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

	    topPanel.add(titleLabel, BorderLayout.CENTER);
	    hotDrinksPanel.add(topPanel, BorderLayout.NORTH);

	    return hotDrinksPanel;
	}
}
