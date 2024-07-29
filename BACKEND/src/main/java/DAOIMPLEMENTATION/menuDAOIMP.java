package DAOIMPLEMENTATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MODEL.Menu;
import MODEL.Restaurent;
import MODEL.User;
import DAOINTERFACES.MenuDAO;

public class menuDAOIMP implements MenuDAO {
	String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
	String userName = "root";
	String password = "root";
	Connection connection = null;

	public menuDAOIMP() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addMenu(Menu menu) {
		String query = "INSERT INTO menu(ItemName,Description,Price,IsAvaliable)" + "values(?,?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(query);

			prepareStatement.setString(1, menu.getItemName());
			prepareStatement.setString(2, menu.getDescription());
			prepareStatement.setInt(3, menu.getPrice());
			prepareStatement.setBoolean(4, menu.getIsAvaliable() );
			prepareStatement.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Menu getMenu(int menuId) {
		String query = "SELECT * FROM menu WHERE MenuId = ?";
        Menu menu = null;
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, menuId);
            ResultSet res = prepareStatement.executeQuery();
            if (res.next()) {
                menu = extractMenuFromResultSet(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		  String query="update menu set ItemName=?,Description=?,Price=?,IsAvaliable=?,ImagePath=? where MenuId=?" ;
		  try {
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, menu.getItemName());
			prepareStatement.setString(2,menu.getDescription());
			prepareStatement.setInt(3, menu.getPrice());
			prepareStatement.setBoolean(4, menu.getIsAvaliable());
			prepareStatement.setString(5,menu.getImagePath());
			prepareStatement.setInt(6, menu.getMenuId());
			prepareStatement.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  

	}
	public Menu extractMenuFromResultSet(ResultSet res) {
		   Menu menu = new Menu();
	       try {
			menu.setMenuId(res.getInt("MenuId"));
			menu.setItemName(res.getString("ItemName"));
			menu.setRestaurantId(res.getInt("RestaurantId"));
			menu.setDescription(res.getString("Description"));
			menu.setPrice(res.getInt("Price"));
			menu.setIsAvaliable(res.getBoolean("IsAvaliable"));
			menu.setImagePath(res.getString("ImagePath"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return menu;
		
	}

	@Override
	public void deleteMenu(int menuId) {
	   String query="DELETE FROM `menu` WHERE MenuId=?";
	   try {
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, menuId);
		prepareStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   

	}

	@Override
	public List<Menu> getAllMenuByRestaurent() {
		// TODO Auto-generated method stub
        String query="select * from `menu`";
        List<Menu> list=new ArrayList();
        try {
			Statement createStatement = connection.createStatement();
			ResultSet resultSet = createStatement.executeQuery(query);
			while(resultSet.next()) {
			   Menu menu= extractMenuFromResultSet(resultSet);
			     list.add(menu);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
