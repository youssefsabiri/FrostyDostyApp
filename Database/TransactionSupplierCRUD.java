package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionSupplierCRUD {
	public static void create(int Amount, int S_ID) {
	    String queryTransaction = "INSERT INTO Transaction (T_Amount, T_Type) VALUES (?, 'S') RETURNING T_Code";
	    String querySupplierTransaction = "INSERT INTO Supplier_Transaction (T_Code, S_ID) VALUES (?, ?)";

	    ResultSet rs = null;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psTransaction = conn.prepareStatement(queryTransaction);
	         PreparedStatement psSupplierTransaction = conn.prepareStatement(querySupplierTransaction)) {

	        // Insert into Transaction
	        psTransaction.setInt(1, Amount);
	        rs = psTransaction.executeQuery();

	        if(rs.next()) {
	            int tCode = rs.getInt(1);

	            // Insert into Client_Transaction
	            psSupplierTransaction.setInt(1, tCode);
	            psSupplierTransaction.setInt(2, S_ID);
	            psSupplierTransaction.executeUpdate();
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

	public static String display(int T_Code) {
        String result = "Not found";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT T_Amount, S_ID FROM Supplier_Transaction NATURAL JOIN Transaction WHERE T_Code = ?");
            ps.setInt(1, T_Code);
            rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getString("T_Amount") + "," + rs.getString("S_ID");
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
	
	

}
