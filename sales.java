import java.sql.*;
import java.util.*;

public class Sales {
    private Connection conn;

    public Sales() {
        conn = DBConnection.getConnection();
    }

    // Display available products
    public void displayProducts() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            System.out.println("\n--- Product List ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") +
                                   " | Price: ?" + rs.getDouble("price") +
                                   " | Qty: " + rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Purchase product
    public void purchaseProduct(int id, int qty) {
        try {
            String query = "UPDATE products SET quantity = quantity - ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, qty);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("? Purchase Successful! " + qty + " item(s) bought.");
            } else {
                System.out.println("? Product not found or insufficient stock.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}