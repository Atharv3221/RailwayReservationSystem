# RailwayReservationSystem
A CLI based Railway Reservation System


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

-- Insert sample trains
INSERT INTO trains (source, destination) VALUES
('New York', 'Washington'),
('Los Angeles', 'San Francisco'),
('Chicago', 'Houston');

-- Insert sample users
INSERT INTO users (name, password) VALUES
('user1', 'password1'),
('user2', 'password2');
