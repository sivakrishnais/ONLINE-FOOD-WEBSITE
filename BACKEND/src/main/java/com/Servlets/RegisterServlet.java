 package com.Servlet;

import DAOINTERFACES.UserDAO;
import DAOIMPLEMENTATION.UserDAOIMP;
import MODEL.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOIMP(); // Initialize your DAO implementation
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CORS configuration
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        // Handling request and response
        String requestData = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        // Parse JSON data into User object
        User newUser = gson.fromJson(requestData, User.class);
        System.out.println(newUser);

        // Check if user object is null or required fields are empty
        if (newUser == null || newUser.getEmail() == null || newUser.getPassword() == null || newUser.getUserName() == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(gson.toJson("Invalid JSON data or missing required fields"));
            return;
        }

        // Check if user already exists in the database
        User existingUser = userDAO.getUser(newUser.getEmail());
        if (existingUser != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT); // Conflict status for existing user
            response.getWriter().write(gson.toJson("User already exists"));
            return;
        }

        // Register new user into the database
        boolean success = userDAO.addUser(newUser);
        if (success) {
            HttpSession session = request.getSession();
            session.setAttribute("user", newUser);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write(gson.toJson(newUser)); // Return registered user details as JSON
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(gson.toJson("Registration failed. Please try again."));
        }
    }
}