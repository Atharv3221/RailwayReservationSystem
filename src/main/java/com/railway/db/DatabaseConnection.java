package com.railway.db;

import java.sql.Connection;
import java.sql.DriverManager;
```java
import java.sql.SQLException;

/**
 * Provides a connection to the database.
 * 
 * @author [Your Name]
 */
public class DatabaseConnection {
    /**
     * The URL of the database.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/railway";
    /**
     * The username to use for the database connection.
     */
    private static final String USER = "root";
    /**
     * The password to use for the database connection.
     */
    private static final String PASSWORD = "Enter_Password";
```
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
