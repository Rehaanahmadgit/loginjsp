import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc {


    public static Connection getConnection() {

            Connection connection=null;

            final String URL = "jdbc:mysql://localhost:3306/b_tech";
             final String USER = "root";
            final String PASS = "9336119497";


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(URL, USER, PASS);
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USER,PASS);
                System.out.println("Connection Established Successfully");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
    }
    public static void main(String[] args) {
//        try {
//            // Load the JDBC driver explicitly (optional)
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(URL, USER, PASS);
//            System.out.println("Connection established successfully.");
//        } catch (ClassNotFoundException e) {
//            System.err.println("MySQL JDBC Driver not found.");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.err.println("Connection failed.");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                    System.out.println("Connection closed.");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
