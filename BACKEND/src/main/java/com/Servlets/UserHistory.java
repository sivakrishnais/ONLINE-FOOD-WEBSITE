package com.Servlet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import DAOIMPLEMENTATION.OrderHistoryDAOiMP;
import DAOIMPLEMENTATION.RestuarentDAOImp;
import DAOINTERFACES.RestaurentDAO;
import MODEL.OrderHistory;

@WebServlet("/history")
public class UserHistory extends  HttpServlet {

    
	private static final long serialVersionUID = 1L;
    private OrderHistoryDAOiMP orderHistory;
    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
 
            this.orderHistory=new OrderHistoryDAOiMP();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CORS configuration
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        // Fetch all restaurants from the database
             List<OrderHistory> allOrderByUser = orderHistory.getAllOrderByUser();
        // Convert the list to JSON
        String jsonResponse = gson.toJson(allOrderByUser);

        // Set response type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write the JSON response
        response.getWriter().write(jsonResponse);
    }
}
