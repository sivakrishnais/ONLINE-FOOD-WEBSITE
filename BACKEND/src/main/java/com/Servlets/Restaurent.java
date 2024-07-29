package com.Servlet;

import DAOINTERFACES.RestaurentDAO;
import DAOIMPLEMENTATION.RestuarentDAOImp;
import MODEL.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/Restaurent")
public class Restaurent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RestaurentDAO restaurentDAO;
    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
 
        this.restaurentDAO = new RestuarentDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CORS configuration
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        // Fetch all restaurants from the database
            List<MODEL.Restaurent> allrestaurants = restaurentDAO.getAllrestaurants();
        // Convert the list to JSON
        String jsonResponse = gson.toJson(allrestaurants);

        // Set response type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write the JSON response
        response.getWriter().write(jsonResponse);
    }
}
