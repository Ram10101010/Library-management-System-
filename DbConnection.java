package javanew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Scanner;

public class DbConnection {
    
    static Connection con = null;
    
    public static Connection GetConnection() 
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/libary_ms";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,userName,password);
            System.out.println("Database connection established");
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
        }
        return con;
    } 
}
