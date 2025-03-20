package com.railway.models;

public class Train {
    private int id;
    private String source;
    private String destination;

    public Train(int id, String source, String destination) {
        this.id = id;
        this.source = source;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    // ✅ Fix: Properly display train details
    @Override
    public String toString() {
        return "Train ID: " + id + " | From: " + source + " | To: " + destination;
    }
}
