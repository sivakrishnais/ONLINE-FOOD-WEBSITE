package DAOIMPLEMENTATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAOINTERFACES.OrderHistoryDAO;
import MODEL.Order;
import MODEL.OrderHistory;

public class OrderHistoryDAOiMP implements OrderHistoryDAO{
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String userName = "root";
	String password = "root";
	Connection connection = null;
	public OrderHistoryDAOiMP() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	

	@Override
	public void addOrderHistory(OrderHistory orderHistory){
		String query="insert into orderhistory(UserId,OrderId,TotalAmount,Status,RestaurentImage) values (?,?,?,?,?)";
	  try {
	    PreparedStatement statement = connection.prepareStatement(query);
	  
        statement.setInt(1, orderHistory.getUserId()); // Correct parameter order
        statement.setInt(2, orderHistory.getOrderId());
        statement.setDouble(3, orderHistory.getTotalAmount());
        statement.setString(4, orderHistory.getStatus());
        statement.setString(5, orderHistory.getRestaruentImage());
      
	  
	    statement.executeUpdate();
	  }
	  
	  catch(Exception e) {
		   e.printStackTrace();
	  }
		
	}
	

	@Override
	public OrderHistory getOrderHistoryId(int orderId) {
	     String query="select * from orderhistory where  OrderHistoryId=?";
	     OrderHistory orderHistory=null;
	     try {
	    	  PreparedStatement statement = connection.prepareStatement(query);
	    	  statement.setInt(1, orderId);
	    	  ResultSet result = statement.executeQuery();
	    	  if(result.next()) {
	    		   orderHistory= exstractResultFromOrderHistory(result);
	    	  }
	     }
	    	  
	    	
	     catch(Exception e) {
	    	  e.printStackTrace();
	     }
		return orderHistory;
	}
	public OrderHistory exstractResultFromOrderHistory(ResultSet result) throws Exception {
	      OrderHistory orderHistory = new OrderHistory();
	      orderHistory.setOrderHistoryId(result.getInt("OrderHistoryId"));
	      orderHistory.setOrderId(result.getInt("OrderId"));
	      orderHistory.setUserId(result.getInt("UserId"));
	      orderHistory.setOrderDate(result.getDate("OrderDate"));
	      orderHistory.setTotalAmount(result.getDouble("TotalAmount"));
	      orderHistory.setStatus(result.getString("Status"));
	      orderHistory.setRestaruentImage(result.getString("RestaurentImage"));
	      
	     
		  return orderHistory;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory)   {
		// TODO Auto-generated method stub
	     String querye="update orderhistory set TotalAmount=?,Status=? where OrderHistoryId=?";
	     try {
			PreparedStatement statement = connection.prepareStatement(querye);
			statement.setDouble(1, orderHistory.getTotalAmount());
			statement.setString(2,orderHistory.getStatus());
			statement.setInt(3,orderHistory.getOrderHistoryId());
			int executeUpdate = statement.executeUpdate();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		
	}

	@Override
	public void deleteOrderHistory(int orderId) {
		 String querye="delete from orderhistory where OrderId=?";
	    try {
			PreparedStatement statement = connection.prepareStatement(querye);
			statement.setInt(1, orderId);
		    statement.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderHistory> getAllOrderByUser() {
		String querey="select * from orderhistory";
		List<OrderHistory> al=new ArrayList();
	    try {
	          Statement statement = connection.createStatement();
	          ResultSet result= statement.executeQuery(querey);
	          while(result.next()) {
	        	  OrderHistory orderHistory = exstractResultFromOrderHistory(result);
	        	  al.add(orderHistory);
	          }
	          
	    }catch(Exception e) {
	    	 e.printStackTrace();
	    }
		return al;
	}

}
