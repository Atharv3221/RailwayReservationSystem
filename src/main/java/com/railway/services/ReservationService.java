package com.railway.services;

import com.railway.dao.TicketDAO;

public class ReservationService {
    private TicketDAO ticketDAO;

    public ReservationService() {
        this.ticketDAO = new TicketDAO();
    }

    public boolean bookTicket(int userId, int trainId) {
        return ticketDAO.bookTicket(userId, trainId);
    }
}
