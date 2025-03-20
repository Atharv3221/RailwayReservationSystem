package com.railway.services;

import com.railway.dao.TicketDAO;
import com.railway.dao.TrainDAO;
import com.railway.models.Ticket;
import com.railway.models.Train;
import java.util.List;

public class AdminService {
    final private TicketDAO ticketDAO = new TicketDAO();
    final private TrainDAO trainDAO = new TrainDAO();

    // ✅ View all booked tickets
    public void viewAllBookings() {
        List<Ticket> tickets = ticketDAO.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("\nBooked Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    // ✅ View all available trains
    public void viewAllTrains() {
        List<Train> trains = trainDAO.getAllTrains();
        if (trains.isEmpty()) {
            System.out.println("No trains available.");
        } else {
            System.out.println("\nAvailable Trains:");
            for (Train train : trains) {
                System.out.println(train);
            }
        }
    }

    // ✅ Cancel a ticket by ID
    public void cancelTicket(int ticketId) {
        if (ticketDAO.cancelTicket(ticketId)) {
            System.out.println("Ticket ID " + ticketId + " has been cancelled.");
        } else {
            System.out.println("Failed to cancel ticket. Check Ticket ID.");
        }
    }

    // ✅ Add a new train
    public void addTrain(int trainId, String source, String destination) {
        if (trainDAO.addTrain(trainId, source, destination)) {
            System.out.println("Train added successfully!");
        } else {
            System.out.println("Failed to add train. Train ID might already exist.");
        }
    }

    // ✅ Cancel (remove) a train by ID
    public void cancelTrain(int trainId) {
        if (trainDAO.deleteTrain(trainId)) {
            System.out.println("Train ID " + trainId + " has been removed.");
        } else {
            System.out.println("Failed to remove train. Check Train ID.");
        }
    }
}
