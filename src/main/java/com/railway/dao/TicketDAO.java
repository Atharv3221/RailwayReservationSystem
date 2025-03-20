package com.railway.dao;

import com.railway.db.DatabaseConnection;
import com.railway.models.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    // ✅ Book a ticket (Already defined)
    public boolean bookTicket(int userId, int trainId) {
        String sql = "INSERT INTO tickets (user_id, train_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, trainId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Get all tickets (Used by Admin)
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tickets.add(new Ticket(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("train_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    // ✅ Cancel a ticket by ID (Newly Added)
    public boolean cancelTicket(int ticketId) {
        String sql = "DELETE FROM tickets WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticketId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
