package Database;

import java.sql.*;

import RemoteInterface.Main;

public class ClientCRUD {
	public static String search(String email) {
        String result = "Not found";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM Client WHERE C_Email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getString("C_Email") + "," + rs.getString("C_Password")+ "," + rs.getString("C_ID");
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

	
	public static void create(String first_name, String middle_name, String last_name, String phone, String city, String street, String email, String password) {
	    String queryClient = "INSERT INTO Client (C_Fname, C_Mname, C_Lname, C_Phone, C_City, C_Street, C_Email, C_Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    ResultSet rs = null;

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psProduct = conn.prepareStatement(queryClient);) {

	        // Insert into Product
	        psProduct.setString(1, first_name);
	        psProduct.setString(2, middle_name);
	        psProduct.setString(3, last_name);
	        psProduct.setString(4, phone);
	        psProduct.setString(5, city);
	        psProduct.setString(6, street);
	        psProduct.setString(7, email);
	        psProduct.setString(8, password);
	        

	        
	        rs = psProduct.executeQuery();


	        
	        
	    } catch (SQLException ex) {
	        System.out.println("An error occurred while trying to add a product.");
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
	
	public static clientInfo display() {
		String queryClient = "SELECT * FROM Client WHERE C_ID = ?";
	    ResultSet rs = null;
	    String result = null;
	    clientInfo ci = null;
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement psClient = conn.prepareStatement(queryClient);) {

	        // Insert into Product
	    	psClient.setInt(1, Main.clientID);	        
	        rs = psClient.executeQuery();

            while (rs.next()) {
            	result = rs.getString("C_Fname") + "," + rs.getString("C_Mname")+ "," + rs.getString("C_Lname") + "," + 
            rs.getString("C_Phone")+ "," + rs.getString("C_City") + "," + rs.getString("C_Street")+ "," + rs.getString("C_Email");
            }
            
            String[] details = result.split(",");
            ci = new clientInfo(details[0], details[1], details[2], details[3], details[4], details[5], details[6]);


	        
	        
	    } catch (SQLException ex) {
	        System.out.println("An error occurred while trying to add a product.");
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
	    
	    
	   return ci;
	    
	}
	
	public static void modify(String password, String city, String street, String phone) {
	    String queryClient = "UPDATE Client SET C_Phone = ?, C_City = ?, C_Street = ?, C_Password = ? WHERE C_ID = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(queryClient);) {
	        // Set the new values
	        ps.setString(1, phone);
	        ps.setString(2, city);
	        ps.setString(3, street);
	        ps.setString(4, password);
	        ps.setInt(5, Main.clientID);
	        // Execute the update
	        ps.executeUpdate();
	    } catch (SQLException ex) {
	        System.out.println("An error occurred while trying to modify a client.");
	        ex.printStackTrace();
	    }
	}


}







