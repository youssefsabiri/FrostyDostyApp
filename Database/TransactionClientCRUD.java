package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import RemoteInterface.Main;
import UserInterface.DeleteTransactionGUI;

public class TransactionClientCRUD {
	public static void create(int Amount) {
	    String queryTransaction = "INSERT INTO Transaction (T_Amount, T_Type) VALUES (?, 'C') RETURNING T_Code";
	    String queryClientTransaction = "INSERT INTO Client_Transaction (T_Code, C_ID) VALUES (?, ?)";

	    ResultSet rs = null;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psTransaction = conn.prepareStatement(queryTransaction);
	         PreparedStatement psClientTransaction = conn.prepareStatement(queryClientTransaction)) {

	        // Insert into Transaction
	        psTransaction.setInt(1, Amount);
	        rs = psTransaction.executeQuery();

	        if(rs.next()) {
	            int tCode = rs.getInt(1);

	            // Insert into Client_Transaction
	            psClientTransaction.setInt(1, tCode);
	            psClientTransaction.setInt(2, Main.clientID);
	            psClientTransaction.executeUpdate();
	        }

	    } catch (SQLException ex) {
	        System.out.println("An error occurred while trying to add a transaction.");
	        ex.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public static String search(int T_Code) {
        String result = "Not found";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM Client_Transaction WHERE T_Code = ?");
            ps.setInt(1, T_Code);
            rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getString("T_Code");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
	
	public static void delete(int T_Code) {
		String result = search(T_Code);
		if (result=="Not found") {
			JOptionPane.showMessageDialog(null, "Transaction Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showDeleteTransactionGUI();
		}
		else {
			String queryClientTransaction = "DELETE FROM Client_Transaction WHERE T_Code = ?";
		    String queryTransaction = "DELETE FROM Transaction WHERE T_Code = ?";

		    try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement psClientTransaction = conn.prepareStatement(queryClientTransaction);
		         PreparedStatement psTransaction = conn.prepareStatement(queryTransaction)) {

		        // Delete from Client_Transaction
		        psClientTransaction.setInt(1, T_Code);
		        psClientTransaction.executeUpdate();

		        // Delete from Transaction
		        psTransaction.setInt(1, T_Code);
		        psTransaction.executeUpdate();

		    } catch (SQLException ex) {
		        System.out.println("An error occurred while trying to delete a transaction.");
		        ex.printStackTrace();
		    }
		}
		
	}
	
	
	

	private static void showDeleteTransactionGUI() {
        DeleteTransactionGUI deleteOrderGUI = new DeleteTransactionGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
}
