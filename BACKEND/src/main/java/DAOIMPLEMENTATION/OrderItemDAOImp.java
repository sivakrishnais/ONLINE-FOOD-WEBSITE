package DAOIMPLEMENTATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAOINTERFACES.OrderItemDAO;
import MODEL.OrderItem;

public class OrderItemDAOImp  implements OrderItemDAO{
	
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String userName = "root";
	String password = "root";
	Connection connection = null;
	
	 public OrderItemDAOImp() {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(url, userName, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }

	@Override
	public void addOrderItem(OrderItem orderItem) {
		String query="INSERT INTO OrderItem(OrderId,MenuId,Quantity,ItemTotal) values(?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, orderItem.getOrderId());
			statement.setInt(2,orderItem.getMenuId());
			statement.setInt(3, orderItem.getQuantity());
			statement.setDouble(4,orderItem.getItemTotal());
			int i = statement.executeUpdate();
			if(i==1) {
				System.out.println(i);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
        String query="SELECT * FROM orderitem where OrderItemId=?";
        OrderItem orderItem=null;
        try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, orderItemId);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				orderItem = extractGetOrderItemFromResult(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return orderItem;
	
	}
	public  OrderItem  extractGetOrderItemFromResult(ResultSet result) {
		    OrderItem orderItem = new OrderItem();
		    try {
				orderItem.setOrderItemId(result.getInt("OrderItemId"));
				orderItem.setQuantity(result.getInt("Quantity"));
				orderItem.setItemTotal(result.getDouble("ItemTotal"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			     e.printStackTrace();
			}
		    return orderItem;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
	 String query="UPDATE ordertable SET Quantity=?,ItemTotal=? WHERE OrderItemId=?";
	 try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1,orderItem.getQuantity());
		statement.setDouble(2,orderItem.getItemTotal());
		statement.setInt(3,orderItem.getOrderItemId());
		int i = statement.executeUpdate();
		if(i==0) {
			System.out.println(i);
		}
		
		
	  ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		String query="DELETE FROM WHERE ordertable=?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1,orderItemId);
			int i = statement.executeUpdate();
			if(i==1) {
				System.out.println(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}

	@Override
	public List<OrderItem> getOrderItemByOrder() {
		List<OrderItem> list=new ArrayList();
		String query="SELECT * FROM `orderhistory`";
		OrderItem orderItem=null;
	     try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				orderItem = extractGetOrderItemFromResult(result);
				list.add(orderItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
