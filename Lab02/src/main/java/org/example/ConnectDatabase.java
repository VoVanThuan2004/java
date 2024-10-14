package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection getConnection(String[] args) {
        Connection con = null;
        if (args.length != 0) {
            String jdbcURL = args[0].split("\\?")[0];
            String params[] = args[0].split("\\?")[1].split("\\&");
            String username = "";
            String password = "";

            for (String param : params) {
                if (param.startsWith("user=")) {
                    username = param.substring(5);
                } else if (param.startsWith("password=")) {
                    password = param.substring(9);
                }
            }

            try {
                con = DriverManager.getConnection(jdbcURL, username, password);
                System.out.println("Connected to " + jdbcURL + " successfully");
            } catch (SQLException e) {
                System.out.println("Failed to connect to " + jdbcURL);
            }

            return con;
        }
        else {
            System.out.println("You must provide a connection URL");
            return null;
        }
    }
}
