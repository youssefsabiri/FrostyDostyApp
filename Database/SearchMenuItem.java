package Database;

import java.sql.*;

public class SearchMenuItem {

    public static String search(String Item) {
        String result = "Not found";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM Menu_Item WHERE Itm_Name = ?");
            ps.setString(1, Item);
            rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getString("Itm_Code") + "," + rs.getString("Itm_Price");
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
