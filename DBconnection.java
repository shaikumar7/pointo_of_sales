import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/pos_system";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpassword";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("? Database Connected Successfully");
        } catch (SQLException e) {
            System.out.println("? Database Connection Failed: " + e.getMessage());
        }
        return conn;
    }
}