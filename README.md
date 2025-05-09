# RailwayReservationSystem
# Railway Reservation System

A command-line based Railway Reservation System implemented in Java using MySQL as the backend database. 
This project demonstrates core DBMS concepts such as user management, train listings, ticket booking, 
and foreign key constraints, all through a simple terminal interface.

## Features

- User registration and login
- View available trains
- Book tickets
- Secure and normalized database design
- Admin user can be accessed with Username: admin and Password: admin123, which can be used to cancel tickets 
and also to add and cancel the trains.

## Technologies Used

- Java (CLI)
- MySQL (Database)
- JDBC (Java Database Connectivity)
- Maven

## Database Setup

To get started, use the following SQL script to create and initialize the required database and tables. 
This script creates a `railway` database with `users`, `trains`, and `tickets` tables, inserts some sample records, 
and establishes foreign key relationships:

```sql
-- Create and use the railway database
CREATE DATABASE railway;
USE railway;

-- Create users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Create trains table
CREATE TABLE trains (
    id INT AUTO_INCREMENT PRIMARY KEY,
    source VARCHAR(50) NOT NULL,
    destination VARCHAR(50) NOT NULL
);

-- Create tickets table
CREATE TABLE tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    train_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (train_id) REFERENCES trains(id) ON DELETE CASCADE
);

