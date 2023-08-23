package UserInterface;

import javax.swing.*;
import java.awt.*;




public class IncomeGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncomeGUI() {
        // set the frame properties
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK); // set background color

        // create the header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.decode("#ed348d"));
        JLabel headerLabel = new JLabel("Financial Summary");
        headerLabel.setForeground(Color.white);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        // create the table panel
        JPanel tablePanel = new JPanel(new GridBagLayout());
        tablePanel.setBackground(Color.BLACK);
        String[] columnNames = {"Year", "Revenue", "Expenses", "Net Income"};
        Object[][] data = {
                {"2021", "$500,000", "$350,000", "$150,000"},
                {"2022", "$600,000", "$400,000", "$200,000"},
                {"2023", "$700,000", "$450,000", "$250,000"}
        };
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        JScrollPane scrollPane = new JScrollPane(table);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 20, 20, 20);
        tablePanel.add(scrollPane, gbc);

        // add the panels to the frame
        add(headerPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        // set the frame to visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new IncomeGUI();
    }
}
