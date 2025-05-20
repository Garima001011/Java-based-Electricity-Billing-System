import java.sql.*;

public class DBConnection {
    static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/electricity", "root", "your_password"
            );
        } catch (Exception e) {
            System.out.println("DB Error: " + e);
        }
        return conn;
    }
}