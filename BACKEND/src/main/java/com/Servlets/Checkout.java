package com.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import MODEL.*;
import DAOIMPLEMENTATION.*;
import DAOINTERFACES.*;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();
    private OrderDAOimp orderDAOimp;
    private OrderItemDAOImp orderItemDAOImp;
    private OrderHistoryDAO  orderHistoryDao;

    @Override
    public void init() throws ServletException {
        orderDAOimp = new OrderDAOimp();
        orderItemDAOImp = new OrderItemDAOImp();
        orderHistoryDao = new OrderHistoryDAOiMP();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CORS configuration
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        PrintWriter out = response.getWriter();
        BufferedReader reader = null;

        try {
            // Read JSON data from request
            reader = request.getReader();
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString();

            // Log the raw JSON data
            System.out.println("Received JSON: " + json);

            // Parse JSON data into CheckoutDetails object
            CheckoutDetails checkoutDetails = gson.fromJson(json, CheckoutDetails.class);

            // Check if checkoutDetails object is null or required fields are missing
            if (checkoutDetails == null || checkoutDetails.getAddress() == null || checkoutDetails.getPaymentMethod() == null || checkoutDetails.getTotalAmount() <= 0 || checkoutDetails.getMenuArray() == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("application/json");
                out.write("{\"message\":\"Invalid JSON data or missing required fields\"}");
                return;
            }

            // Process the checkout details
            System.out.println("User ID: " + checkoutDetails.getUserId());
            System.out.println("Restaurant ID: " + checkoutDetails.getRestaurantId());
            System.out.println("Address: " + checkoutDetails.getAddress());
            System.out.println("Payment Method: " + checkoutDetails.getPaymentMethod());
            System.out.println("Total Amount: " + checkoutDetails.getTotalAmount());

            // Create Order entity and insert into database
            Order order = new Order();
            order.setUserId(checkoutDetails.getUserId());
            order.setRestaurentId(checkoutDetails.getRestaurantId());
            order.setTotalAmount(checkoutDetails.getTotalAmount());
            order.setStatus("pending");
            order.setPaymentMethod(checkoutDetails.getPaymentMethod());
            orderDAOimp.addOrder(order);

            int orderId= orderDAOimp.getMaxValueFromOrderTable();
            // Process each menu item in the checkout
            for (MenuItem item : checkoutDetails.getMenuArray()) {
                // Create OrderItem entity
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(orderId);
                orderItem.setMenuId(item.getMenuId());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setItemTotal(item.getPrice() * item.getQuantity());

                // Insert OrderItem into database
                orderItemDAOImp.addOrderItem(orderItem);
            }
           
            OrderHistory orderHistory = new OrderHistory();
            String imagePathByOrderId = orderDAOimp.getImagePathByOrderId(orderId);
            orderHistory.setOrderId(orderId);
            orderHistory.setUserId(checkoutDetails.getUserId());
            orderHistory.setTotalAmount(checkoutDetails.getTotalAmount());
            orderHistory.setStatus("Delivered");
            orderHistory.setRestaruentImage(imagePathByOrderId);
           
            
            // Assuming the order is marked as Delivered upon checkout
            orderHistoryDao.addOrderHistory(orderHistory);

            // Respond with success message
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            out.write("{\"message\":\"Order placed successfully\"}");

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            out.write("{\"message\":\"There was an error processing your request.\"}");
        } finally {
            if (reader != null) {
                reader.close();
            }
            out.close();
        }
    }

    private static class CheckoutDetails {
        private int restaurantId;
        private int userId;
        private String address;
        private String paymentMethod;
        private double totalAmount;
        private MenuItem[] menuArray;

        // Getters and setters...
        public int getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(int restaurantId) {
            this.restaurantId = restaurantId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public MenuItem[] getMenuArray() {
            return menuArray;
        }

        public void setMenuArray(MenuItem[] menuArray) {
            this.menuArray = menuArray;
        }
    }

    private static class MenuItem {
        private int menuId;
        private int quantity;
        private double price;

        // Getters and setters...
        public int getMenuId() {
            return menuId;
        }

        public void setMenuId(int menuId) {
            this.menuId = menuId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
