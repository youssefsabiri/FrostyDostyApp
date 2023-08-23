package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public AdminGUI() {
        setTitle("Navigation Bar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(150, 75, 0));
        navPanel.setLayout(new BorderLayout());
        navPanel.setPreferredSize(new Dimension(getWidth(), 40));

        // create navigation buttons
        String[] links = {"Transactions", "Account", "Income", "Products"};
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonPanel.setBackground(new Color(139, 69, 19)); // set background color to brown
        for (String link : links) {
            JButton linkButton = new JButton(link);
            linkButton.setForeground(Color.WHITE);
            linkButton.setBackground(new Color(139, 69, 19));
            linkButton.setFocusPainted(false);
            linkButton.setBorder(BorderFactory.createEmptyBorder());
            linkButton.setPreferredSize(new Dimension(150, 40));
            linkButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    linkButton.setBackground(Color.GRAY);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    linkButton.setBackground(new Color(139, 69, 19));
                }
            });

            if (link.equals("Transactions")) {
                linkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Transactions");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.getContentPane().add(new AdminTransactionsGUI(), BorderLayout.CENTER);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            } else if (link.equals("Account")) {
                linkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Account");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.getContentPane().add(new AdminProfileGUI(), BorderLayout.CENTER);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            } else if (link.equals("Income")) {
                linkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Income");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.getContentPane().add(new AdminIncomeGUI(), BorderLayout.CENTER);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            } else if (link.equals("Products")) {
                linkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("Products");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.getContentPane().add(new AdminProductsGUI(), BorderLayout.CENTER);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            }

            buttonPanel.add(linkButton);
        }
        navPanel.add(buttonPanel, BorderLayout.CENTER);

        // add navigation panel to north region
        add(navPanel, BorderLayout.NORTH);

        // create image panel
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(getClass().getResource("POP.jpg"));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // add image panel to center region
        add(imagePanel, BorderLayout.CENTER);

        // set frame size to fill the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminGUI();
    }

}
