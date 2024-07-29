package com.Servlet;

import DAOINTERFACES.MenuDAO;
import DAOIMPLEMENTATION.menuDAOIMP;
import MODEL.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Menu")
public class Menu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MenuDAO menuDAO;
    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        menuDAO = new menuDAOIMP(); // Initialize your DAO implementation
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CORS configuration
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        // Fetch all menu items
         List<MODEL.Menu> allMenuByRestaurent = menuDAO.getAllMenuByRestaurent();

        // Convert to JSON and send response
        String jsonResponse = gson.toJson(allMenuByRestaurent);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
