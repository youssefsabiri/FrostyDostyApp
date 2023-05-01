package UserInterface;

import BusinessIntelligence.CalculateExpenses;
import BusinessIntelligence.CalculateIncome;
import BusinessIntelligence.CalculateRevenues;
import BusinessIntelligence.Main;

import javax.swing.*;
import java.awt.*;



public class AdminIncomeGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminIncomeGUI() {
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
        
        //Calculating the entries
        CalculateExpenses ex = new CalculateExpenses();
        CalculateRevenues rv = new CalculateRevenues();
        CalculateIncome in = new CalculateIncome();
        double tran_expenses = ex.Expenses(Main.transactions);
        double tran_revenues = rv.Revenues(Main.transactions);
        double tran_income = in.NetIncome(Main.transactions);
        
        String expenses = Double.toString(tran_expenses);
        String revenues = Double.toString(tran_revenues);
        String income = Double.toString(tran_income);
        
        
        // create the table panel
        JPanel tablePanel = new JPanel(new GridBagLayout());
        tablePanel.setBackground(Color.BLACK);
        String[] columnNames = {"Year", "Revenue", "Expenses", "Net Income"};
        Object[][] data = {
                {"2023", revenues, expenses, income},
              
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
    	
        new AdminIncomeGUI();
    }
}