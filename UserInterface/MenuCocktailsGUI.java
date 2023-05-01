package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuCocktailsGUI {
	public static JPanel createCocktailsPanel(Color backgroundColor, ActionListener backActionListener) {
	    JPanel CocktailsPanel = new JPanel(new BorderLayout());
	    CocktailsPanel.setBackground(backgroundColor);

	    ImageIcon CocktailsImageIcon = new ImageIcon(MenuHotDrinksGUI.class.getResource("cocktails.png"));
	    JLabel CocktailsImageLabel = new JLabel(CocktailsImageIcon);
	    CocktailsImageLabel.setBackground(Color.BLACK);
	    CocktailsImageLabel.setOpaque(true);

	    CocktailsPanel.add(CocktailsImageLabel, BorderLayout.CENTER);

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

	    JLabel titleLabel = new JLabel("Cocktails Menu");
	    titleLabel.setHorizontalAlignment(JLabel.CENTER);
	    titleLabel.setForeground(Color.BLACK);
	    titleLabel.setBackground(backgroundColor);
	    titleLabel.setOpaque(true);
	    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

	    topPanel.add(titleLabel, BorderLayout.CENTER);
	    CocktailsPanel.add(topPanel, BorderLayout.NORTH);

	    return CocktailsPanel;
	}
}

