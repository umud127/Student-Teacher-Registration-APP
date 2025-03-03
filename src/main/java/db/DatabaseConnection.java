package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //database info
    private static final String baseUrl = "jdbc:mysql://localhost:3306/";
    private static final String user = "The_Best";
    private static final String password = "VANDAMburusli@127";

    //getting connection
    public static Connection connect(String database_Name) throws SQLException {
        String url = baseUrl + database_Name + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        return DriverManager.getConnection(url,user,password);
    }

    public static void checkConnection() {
        try (Connection conn = DatabaseConnection.connect("student")) {
            System.out.println("✅ MySQL bağlantısı uğurludur!");
        } catch (SQLException e) {
            System.out.println("❌ Bağlantı xətası: " + e.getMessage());
        }
    }
}