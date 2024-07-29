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
@WebServlet("/sivakrishna")
public class Login extends HttpServlet {
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
        User user = gson.fromJson(requestData, User.class);
         System.out.println(user);
        // Check if user is null
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(gson.toJson("Invalid JSON data"));
            return;
        }

        // Get user from database
        User existingUser = userDAO.getUser(user.getEmail());
         System.out.println(existingUser);

        // Check if user exists and passwords match
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("user", existingUser);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(gson.toJson(existingUser)); // Return user details as JSON
        } else {
            // Invalid credentials
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(gson.toJson("Invalid email or password"));
        }
    }
}
