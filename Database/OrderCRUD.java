package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import RemoteInterface.Main;
import UserInterface.DeleteOrderGUI;


public class OrderCRUD {
	
	public static void create(int amount, int quantity, int Itm_code) {
		String query = "INSERT INTO ClientOrder (O_TotalAmount, C_ID, O_Status) VALUES (?, ?, 'In Process') RETURNING O_Code";
		String query2 = "INSERT INTO Order_Details (O_Code, Itm_Code, Quantity_Ordered) VALUES (?, ?, ?)";
		
		ResultSet rs = null;
		
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query);
	    	 PreparedStatement ps2 = conn.prepareStatement(query2)	) {

	        ps.setInt(1, amount);
	        ps.setInt(2, Main.clientID);
	        ps.executeUpdate();
	        
	        if(rs.next()) {
	            int oCode = rs.getInt(1);

	            // Insert into Client_Transaction
	            ps2.setInt(1, oCode);
	            ps2.setInt(2, Itm_code);
	            ps2.setInt(3, quantity);
	            ps2.executeUpdate();
	        }

	    } catch (SQLException ex) {
	        System.out.println("An error occurred while trying to add an order.");
	        ex.printStackTrace();
	    }


	}
	
	
	public static String search(int O_Code) {
        String result = "Not found";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM ClientOrder WHERE O_Code = ?");
            ps.setInt(1, O_Code);
            rs = ps.executeQuery();

            while (rs.next()) {
            	result = rs.getString("O_Date") + "," + rs.getString("O_TotalAmount")+ "," + rs.getString("O_Status");
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
	
	public static void delete(int O_Code) {
		String queryOrder = "DELETE FROM ClientOrder WHERE O_Code = ?";
		String queryOrder2 = "DELETE FROM Order_Details WHERE O_Code = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psOrder = conn.prepareStatement(queryOrder);
	         PreparedStatement psOrder2 = conn.prepareStatement(queryOrder2)) {

	        // Delete from Product
	    	psOrder.setInt(1, O_Code);
	    	psOrder.executeUpdate();
	    	
	    	psOrder2.setInt(1, O_Code);
	    	psOrder2.executeUpdate();

	    } catch (SQLException ex) {
	        System.out.println("An error occurred while trying to delete an order.");
	        ex.printStackTrace();
	    }
	}
	
	

	public static  void display(int C_ID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM ClientOrder WHERE C_ID = ?");
            ps.setInt(1, C_ID);
            rs = ps.executeQuery();

            while (rs.next()) {
            	String oCode = rs.getString("O_Code");
                int order_code = Integer.parseInt(oCode);
            	String oDate = rs.getString("O_Date");
                String oTotalAmount = rs.getString("O_TotalAmount");
                String oStatus = rs.getString("O_Status");
                int amount = Integer.parseInt(oTotalAmount);

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


    }
	
	
	
	
}