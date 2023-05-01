package UserInterface;

import BusinessIntelligence.Client;
import BusinessIntelligence.account;
import Database.Store;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class Indexpage {
    public static void main(String[] args) {
    	Store.loadMenu();
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Frosty Dosty");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(Indexpage.class.getResource("frosty.png"));

        if (imageIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Error loading image");
        }

        JLabel imageLabel = new JLabel(imageIcon);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.add(imageLabel);

        frame.getContentPane().add(imagePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;

        JButton signUpButton = new JButton("SIGN UP");
        signUpButton.setBackground(new Color(237, 52, 141));
        signUpButton.addActionListener(e -> {
            SignupGUI signupGUI = new SignupGUI();
            signupGUI.setVisible(true);
            frame.dispose();
        });

        JButton logInButton = new JButton("LOGIN");
        logInButton.setBackground(new Color(105, 217, 255));
        logInButton.addActionListener(e -> {
        	account a = new account("blank", "blank");
        	Client cl = new Client("blank", "blank", "blank", a);
            LoginGUI loginGUI = new LoginGUI(cl);
            loginGUI.setVisible(true);
            frame.dispose();
        });



        buttonPanel.add(Box.createVerticalGlue(), gbc);
        buttonPanel.add(signUpButton, gbc);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 2)), gbc);
        buttonPanel.add(logInButton, gbc);
        buttonPanel.add(Box.createVerticalGlue(), gbc);

        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(233, 30, 99));
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints infoGbc = new GridBagConstraints();
        infoGbc.gridwidth = GridBagConstraints.REMAINDER;
        infoGbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Welcome to our website!");
        titleLabel.setForeground(Color.WHITE);

        JLabel phoneNumberLabel = new JLabel("Phone numbers: +212 643835906 OR +212 625153626");
        phoneNumberLabel.setForeground(Color.WHITE);

        JLabel instagramLabel = new JLabel("Instagram: ");
        instagramLabel.setForeground(Color.WHITE);
        JButton instagramButton = new JButton("@Frosty Dosty");
        instagramButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.instagram.com/frosty.dosty/"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JLabel locationLabel = new JLabel("Location: ");
        locationLabel.setForeground(Color.WHITE);
        JButton locationButton = new JButton("Click here");
        locationButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://goo.gl/maps/Bu21wksFx7hUijJK6"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        infoPanel.add(titleLabel, infoGbc);
        infoPanel.add(phoneNumberLabel, infoGbc);
        infoPanel.add(instagramLabel, infoGbc);
        infoPanel.add(instagramButton, infoGbc);
        infoPanel.add(locationLabel, infoGbc);
        infoPanel.add(locationButton, infoGbc);

        frame.getContentPane().add(infoPanel, BorderLayout.SOUTH);

        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}