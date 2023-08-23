package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionEmployeeCRUD {
	public static void create(int Amount, int Emp_ID) {
	    String queryTransaction = "INSERT INTO Transaction (T_Amount, T_Type) VALUES (?, 'E') RETURNING T_Code";
	    String queryEmployeeTransaction = "INSERT INTO Employee_Transaction (T_Code, Emp_ID) VALUES (?, ?)";

	    ResultSet rs = null;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psTransaction = conn.prepareStatement(queryTransaction);
	         PreparedStatement psEmployeeTransaction = conn.prepareStatement(queryEmployeeTransaction)) {

	        // Insert into Transaction
	        psTransaction.setInt(1, Amount);
	        rs = psTransaction.executeQuery();

	        if(rs.next()) {
	            int tCode = rs.getInt(1);

	            // Insert into Client_Transaction
	            psEmployeeTransaction.setInt(1, tCode);
	            psEmployeeTransaction.setInt(2, Emp_ID);
	            psEmployeeTransaction.executeUpdate();
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
            ps = conn.prepareStatement("SELECT COALESCE(T_Date, '2023-01-01'), COALESCE(T_Amount, 100), COALESCE(Emp_ID, 5) FROM Employee_Transaction NATURAL JOIN Transaction WHERE T_Code = ?");
            ps.setInt(1, T_Code);
            rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getString("T_Date") + "," + rs.getString("T_Amount") + "," + rs.getString("Emp_ID");
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
