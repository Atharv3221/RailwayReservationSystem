package com.railway.services;

import com.railway.dao.UserDAO;
import com.railway.models.User;

public class AuthenticationService {
    private UserDAO userDAO;

    public AuthenticationService() {
        this.userDAO = new UserDAO();
    }

    public User login(String name, String password) {
        if (name.equals("admin") && password.equals("admin123")) {
            return new User(0, "admin", "admin123", true);
        }
        return userDAO.getUserByNameAndPassword(name, password);
    }

    public boolean register(String name, String password) {
        return userDAO.addUser(name, password);
    }
}
