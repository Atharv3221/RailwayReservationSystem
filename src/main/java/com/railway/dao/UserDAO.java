package com.railway.dao;

```java
import com.railway.db.DatabaseConnection;
import com.railway.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public User getUserByNameAndPassword(String name, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
```
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
```java
ResultSet rs = stmt.executeQuery();
if (rs.next()) {
    return new User(
        rs.getInt("id"), 
        rs.getString("name"), 
        rs.getString("password"), 
        false
    );
}
```
        return null;
    }

    public boolean addUser(String name, String password) {
        String sql = "INSERT INTO users (name, password) VALUES (?, ?)";
```java
try (Connection conn = DatabaseConnection.getConnection();
     PreparedStatement stmt = conn.prepareStatement(sql))
{
    stmt.setString(1, name);
    stmt.setString(2, password);
    return stmt.executeUpdate() > 0;
} catch (SQLException e) {
    e.printStackTrace();
}
```
            return false;
        }
    }
}
