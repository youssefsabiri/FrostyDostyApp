package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import UserInterface.DeleteProductGUI;


public class ProductCRUD {
	public static void create(String name, double price, double quantity, double treshold, String location) {
	    String queryProduct = "INSERT INTO Product (name, price, quantity, treshold, location) VALUES (?, ?, ?, ?, ?)";

	    ResultSet rs = null;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psProduct = conn.prepareStatement(queryProduct);) {

	        // Insert into Product
	        psProduct.setString(1, name);
	        psProduct.setDouble(2, price);
	        psProduct.setDouble(3, quantity);
	        psProduct.setDouble(4, treshold);
	        psProduct.setString(5, location);
	        
	        rs = psProduct.executeQuery();


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
	
	public static String search(String name) {
        String result = "Not found";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM Product WHERE P_Name = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getString("name");
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
	
	public static void delete(String name) {
		String result = search(name);
		if (result=="Not found") {
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showDeleteProductGUI();
		}
		else {
			String queryProduct = "DELETE FROM Product WHERE name = ?";

		    try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement psProduct = conn.prepareStatement(queryProduct);) {

		        // Delete from Product
		        psProduct.setString(1, name);
		        psProduct.executeUpdate();

		    } catch (SQLException ex) {
		        System.out.println("An error occurred while trying to delete a transaction.");
		        ex.printStackTrace();
		    }
		}
	}
	
	public static void modify(String name, double treshold, String location) {
		String result = search(name);
		if (result=="Not found") {
			JOptionPane.showMessageDialog(null, "Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
			showDeleteProductGUI();
		}
		else {
			String queryProduct = "UPDATE Product SET treshold = ?, location = ? WHERE name = ?";

		    try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement psProduct = conn.prepareStatement(queryProduct);) {

		        // Delete from Product
		        psProduct.setDouble(1, treshold);
		        psProduct.setString(2, location);
		        psProduct.setString(3, name);
		        psProduct.executeUpdate();

		    } catch (SQLException ex) {
		        System.out.println("An error occurred while trying to delete a transaction.");
		        ex.printStackTrace();
		    }
		}
	}
	
	
	private static void showDeleteProductGUI() {
        DeleteProductGUI deleteOrderGUI = new DeleteProductGUI();
        JFrame adminFrame = new JFrame("Add Order GUI");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(800, 600);
        adminFrame.add(deleteOrderGUI);
        adminFrame.setVisible(true);
    }
	
}