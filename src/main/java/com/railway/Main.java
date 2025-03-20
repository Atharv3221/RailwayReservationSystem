package com.railway;

import com.railway.dao.TrainDAO;
import com.railway.models.Train;
import com.railway.models.User;
import com.railway.services.AdminService;
import com.railway.services.AuthenticationService;
import com.railway.services.ReservationService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthenticationService authService = new AuthenticationService();
        ReservationService reservationService = new ReservationService();
        AdminService adminService = new AdminService();
        TrainDAO trainDAO = new TrainDAO();

        while (true) {  // ✅ Keeps user on main menu until they exit
            System.out.println("\nWelcome to Railway Reservation System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            User user;
            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                user = authService.login(name, password);

                if (user == null) {
                    System.out.println("Invalid credentials! Try again.");
                    continue;  // ✅ Stay on the main menu
                }
            } else if (choice == 2) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                if (authService.register(name, password)) {
                    System.out.println("Registration successful. Logging you in...");
                    user = authService.login(name, password); // Auto-login after registration
                } else {
                    System.out.println("Registration failed. Try again.");
                    continue;
                }
            } else if (choice == 3) {
                System.out.println("Exiting the system. Goodbye!");
                break;  // ✅ Exit the system only when the user chooses "Exit"
            } else {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            if (user.isAdmin()) {
                // 🟢 ADMIN PANEL
                System.out.println("\nWelcome Admin!");

                while (true) {
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. View All Bookings");
                    System.out.println("2. View All Trains");
                    System.out.println("3. Cancel a Ticket");
                    System.out.println("4. Add a New Train");
                    System.out.println("5. Remove a Train");
                    System.out.println("6. Logout");

                    int adminChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (adminChoice) {
                        case 1:
                            adminService.viewAllBookings();
                            break;
                        case 2:
                            adminService.viewAllTrains();
                            break;
                        case 3:
                            System.out.print("Enter Ticket ID to cancel: ");
                            int ticketId = scanner.nextInt();
                            adminService.cancelTicket(ticketId);
                            break;
                        case 4:
                            System.out.print("Enter Train ID: ");
                            int trainId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Source: ");
                            String source = scanner.nextLine();
                            System.out.print("Enter Destination: ");
                            String destination = scanner.nextLine();
                            adminService.addTrain(trainId, source, destination);
                            break;
                        case 5:
                            System.out.print("Enter Train ID to remove: ");
                            int removeTrainId = scanner.nextInt();
                            adminService.cancelTrain(removeTrainId);
                            break;
                        case 6:
                            System.out.println("Logging out...");
                            break;  // ✅ Return to the main menu
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                    if (adminChoice == 6) break;  // ✅ Exit admin menu, return to main menu
                }
            } else {
                // 🟢 USER PANEL
                while (true) {
                    System.out.println("\nAvailable Trains:");
                    List<Train> trains = trainDAO.getAllTrains();
                    for (Train train : trains) {
                        System.out.println(train);
                    }

                    System.out.println("\n1. Book Ticket");
                    System.out.println("2. Logout");
                    int userChoice = scanner.nextInt();

                    if (userChoice == 1) {
                        System.out.print("Enter Train ID: ");
                        int trainId = scanner.nextInt();
                        if (reservationService.bookTicket(user.getId(), trainId)) {
                            System.out.println("Ticket booked successfully.");
                        } else {
                            System.out.println("Booking failed.");
                        }
                    } else if (userChoice == 2) {
                        System.out.println("Logging out...");
                        break;  // ✅ Return to the main menu
                    } else {
                        System.out.println("Invalid choice! Please select 1 or 2.");
                    }
                }
            }
        }
    }
}
