package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionCRUD {
	
	public static String search(int code) {
        String result = "Not found";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT T_Type FROM Transaction WHERE T_Code = ?");
            ps.setInt(1, code);
            rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getString("T_Type");
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
	
	public static void modify(int code, int amount) {
	    String queryModifyTransaction2 = "UPDATE Transaction SET T_Amount = ? where T_Code = ?";

	    ResultSet rs = null;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psTransaction = conn.prepareStatement(queryModifyTransaction2);) {

	        psTransaction.setInt(1, amount);
	        psTransaction.setInt(2, code);
	        rs = psTransaction.executeQuery();

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
	
	public static void delete(int code) {
	    String queryDeleteTransaction = "DELETE FROM Transaction where T_Code = ?";

	    ResultSet rs = null;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psTransaction = conn.prepareStatement(queryDeleteTransaction);) {

	        psTransaction.setInt(1, code);
	        rs = psTransaction.executeQuery();

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

}
