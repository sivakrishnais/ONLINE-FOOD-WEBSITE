package DAOIMPLEMENTATION;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAOINTERFACES.OrderDAO;
import MODEL.Order;

public class OrderDAOimp implements OrderDAO {
    private String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
    private String userName = "root";
    private String password = "root";
    private Connection connection = null;

    public OrderDAOimp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrder(Order order) {
        String query = "INSERT INTO ordertable(UserId, RestaurantId, TotalAmount, Status, PaymentMethod) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, order.getUserId());
            prepareStatement.setInt(2, order.getRestaurentId());
            prepareStatement.setDouble(3, order.getTotalAmount());
            prepareStatement.setString(4, order.getStatus());
            prepareStatement.setString(5, order.getPaymentMethod());

            int executeUpdate = prepareStatement.executeUpdate();
            System.out.println(executeUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrder(int orderId) {
        String query = "SELECT * FROM ordertable WHERE OrderId = ?";
        Order order = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, orderId);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                order = exstractResultFromOrderResult(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    private Order exstractResultFromOrderResult(ResultSet result) {
        Order order = new Order();
        try {
            order.setOrderId(result.getInt("OrderId"));
            order.setUserId(result.getInt("UserId"));
            order.setRestaurentId(result.getInt("RestaurantId"));
            Date date = result.getDate("OrderDate");
            if (date != null) {
                order.setOrderDate(date.toLocalDate());
            }
            order.setTotalAmount(result.getDouble("TotalAmount"));
            order.setStatus(result.getString("Status"));
            order.setPaymentMethod(result.getString("PaymentMethod"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        String query = "UPDATE ordertable SET OrderDate = ?, TotalAmount = ?, Status = ?, PaymentMethod = ? WHERE OrderId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, Date.valueOf(order.getOrderDate()));
            statement.setDouble(2, order.getTotalAmount());
            statement.setString(3, order.getStatus());
            statement.setString(4, order.getPaymentMethod());
            statement.setInt(5, order.getOrderId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing order was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        String query = "DELETE FROM ordertable WHERE OrderId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Order deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrderByUser() {
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM ordertable";
        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {
            while (result.next()) {
                Order order = exstractResultFromOrderResult(result);
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public int getMaxValueFromOrderTable() {
        int maxOrderId = 0;
        String query = "SELECT MAX(OrderId) AS maxOrderId FROM ordertable";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                maxOrderId = resultSet.getInt("maxOrderId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return maxOrderId;
    }
    @Override
    public String getImagePathByOrderId(int orderId) {
        String imagePath = null;
        String query = "SELECT r.ImagePath FROM ordertable o JOIN restaurant r ON o.RestaurantId = r.RestaurantId WHERE o.OrderId = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    imagePath = resultSet.getString("ImagePath");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return imagePath;
    }
    

  
    
  

}
