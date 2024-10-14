package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetDataBase {
    private static final String CREATE_DATABASE = "CREATE database IF NOT EXISTS productmanagement";
    private static final String USE_DATABASE = "USE productmanagement";
    private static final String DROP_TABLE = "DROP table IF EXISTS product";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS product("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "name VARCHAR(70) NOT NULL, "
            + "price DOUBLE NOT NULL, "
            + "color VARCHAR(70) NOT NULL)";

    public static void setUpDB(Connection connection) {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(CREATE_DATABASE);
            System.out.println("Database has created");
        } catch (SQLException e) {
            System.out.println("Database does not create!" + e.getMessage());
        }

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(USE_DATABASE);
            System.out.println("Database has used");
        } catch (SQLException e) {
            System.out.println("Database does not use!" + e.getMessage());
        }

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(DROP_TABLE);
            System.out.println("Database has dropped");
        } catch (SQLException e) {
            System.out.println("Database does not drop!" + e.getMessage());
        }

        try (Statement stmt = connection.createStatement()){
            stmt.execute(CREATE_TABLE);
            System.out.println("Database has created");
        } catch (SQLException e) {
            System.out.println("Database does not create!" + e.getMessage());
        }
    }
}
