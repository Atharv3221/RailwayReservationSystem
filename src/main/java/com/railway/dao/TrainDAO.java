package com.railway.dao;

```java
import com.railway.db.DatabaseConnection;
import com.railway.models.Train;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainDAO {
```
    // ✅ Get all trains (Already defined)
    public List<Train> getAllTrains() {
        List<Train> trains = new ArrayList<>();
        String sql = "SELECT * FROM trains";
        try (Connection conn = DatabaseConnection.getConnection();
```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while (rs.next()) {
    trains.add(new Train(rs.getInt("id"), rs.getString("source"), rs.getString("destination")));
}
```
        }
        return trains;
    }

```java
/**
 * Add a new train (Newly Added)
 * 
 * @param trainId      the id of the train
 * @param source       the source of the train
 * @param destination  the destination of the train
 * @return true if the train is added successfully, false otherwise
 */
public boolean addTrain(int trainId, String source, String destination) {
    String sql = "INSERT INTO trains (id, source, destination) VALUES (?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, trainId);
        stmt.setString(2, source);
        stmt.setString(3, destination);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        return false;
    }
}
```
            stmt.setString(3, destination);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
} 

  // ✅ Delete a train by ID (Newly Added)
  public boolean deleteTrain(int trainId) {
    String sql = "DELETE FROM trains WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, trainId);
            return stmt.executeUpdate() > 0;
} catch (SQLException e) {
    e.printStackTrace();
    return false;
}
