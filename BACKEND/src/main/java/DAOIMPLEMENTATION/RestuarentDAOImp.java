package DAOIMPLEMENTATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAOINTERFACES.RestaurentDAO;
import MODEL.Restaurent;



public class RestuarentDAOImp implements RestaurentDAO {
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
    String userName = "root";
    String password = "root";
    Connection connection = null;
	
	
	public RestuarentDAOImp() {
		  try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(url, userName, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void addResturant(Restaurent restaurent) {
	
		String query="INSERT INTO restaurant(Name,CuisineType,DeliveryTime,Address,Rating,IsActive)"+
	              "values(?,?,?,?,?,?)";
	    
	
	try {
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		 prepareStatement.setString(1,restaurent.getName());
		 prepareStatement.setString(2,restaurent.getCuisineType());
         prepareStatement.setInt(3,restaurent.getDeliverTimel() );
         prepareStatement.setString(4, restaurent.getAddress());
         prepareStatement.setDouble(5,restaurent.getRating());
         prepareStatement.setInt(6,restaurent.getIsActive());
         prepareStatement.executeUpdate();
         
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public Restaurent getRestaurant(int restaurantId)  {
		  String query="SELECT * FROM restaurant where RestaurantId=?";
		  Restaurent  getRestaurentFromResultSet=null;
		  try {
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, restaurantId);
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				getRestaurentFromResultSet= getRestaurentFromResultSet(resultSet);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getRestaurentFromResultSet;
	}
	public Restaurent getRestaurentFromResultSet(ResultSet resultSet) {
		        Restaurent restaurant= new Restaurent();
		        try {
					restaurant.setRestaurantId(resultSet.getInt("RestaurantId"));
					restaurant.setName(resultSet.getString("Name"));
					restaurant.setCuisineType(resultSet.getString("CuisineType"));
					restaurant.setAddress(resultSet.getString("Address"));
					restaurant.setDeliverTimel(resultSet.getInt("DeliveryTime"));
					restaurant.setIsActive(resultSet.getInt("IsActive"));
					restaurant.setRating(resultSet.getDouble("Rating"));
					restaurant.setImagePath(resultSet.getString("ImagePath"));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		        return restaurant;
	}

	@Override
	public void updateRestaurent(Restaurent restaurent) {
	
	String sql="UPDATE `restaurant` SET Name=?,CuisineType=?,DeliveryTime=?,Address=?,"
				+"Rating=?, IsActive=? WHERE RestaurantId=? ";
		        
		    	try {
					PreparedStatement prepareStatement = connection.prepareStatement(sql);
					 prepareStatement.setString(1,restaurent.getName());
					 prepareStatement.setString(2,restaurent.getCuisineType());
			         prepareStatement.setInt(3,restaurent.getDeliverTimel() );
			         prepareStatement.setString(4, restaurent.getAddress());
			         //prepareStatement.setInt(5, restaurent.getAdminUserId());
			         prepareStatement.setDouble(5,restaurent.getRating());
			         prepareStatement.setInt(6,restaurent.getIsActive());
			         prepareStatement.setInt(7,restaurent.getRestaurantId() );
			         prepareStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
		
				
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		       String query="DELETE FROM `restaurant` WHERE RestaurantId=?";
		       try {
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				prepareStatement.setInt(1, restaurantId);
				prepareStatement.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       
	}

	@Override
	public List<Restaurent> getAllrestaurants()  {
        String query="select * from `restaurant`";
        List<Restaurent> list=new ArrayList();
        try {
			Statement createStatement = connection.createStatement();
			ResultSet resultSet = createStatement.executeQuery(query);
			while(resultSet.next()) {
				Restaurent res= getRestaurentFromResultSet(resultSet);
				list.add(res);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

}
