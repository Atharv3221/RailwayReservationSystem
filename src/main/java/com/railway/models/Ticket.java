package com.railway.models;

public class Ticket {
    private final int id;
    private final int userId;
    private final int trainId;

    public Ticket(int id, int userId, int trainId) {
        this.id = id;
        this.userId = userId;
        this.trainId = trainId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getTrainId() {
        return trainId;
    }

    // ✅ Fix: Override toString() to display ticket details
    @Override
    public String toString() {
        return "Ticket ID: " + id + " | User ID: " + userId + " | Train ID: " + trainId;
    }
}
