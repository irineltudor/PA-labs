package com.lab8.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectToDB{

    private static Connection conn = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/lab8java";
        String user = "root";
        String pass = "root";
        try {

            conn = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
}
