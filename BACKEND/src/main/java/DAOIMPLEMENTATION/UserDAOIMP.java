package DAOIMPLEMENTATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MODEL.User;
import DAOINTERFACES.UserDAO;

public class UserDAOIMP implements UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/online_food_delivery_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection = null;

    public UserDAOIMP() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addUser(User user) {
        String query = "INSERT INTO user (UserName, Password, Email, Address, Role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, user.getUserName());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getAddress());
            prepareStatement.setString(5, user.getRole());

            int executeUpdate = prepareStatement.executeUpdate();
            if (executeUpdate != 0) {
                return true;
            }
            System.out.println("Rows affected in addUser(): " + executeUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public User getUser(String userId) {
        String query = "SELECT * FROM user WHERE Email = ?";
        User user = null;
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, userId);
            ResultSet res = prepareStatement.executeQuery();
            if (res.next()) {
                user = extractUserFromResultSet(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User extractUserFromResultSet(ResultSet res) throws SQLException {
        User user = new User();
        user.setUserId(res.getInt("UserId"));
        user.setUserName(res.getString("UserName"));
        user.setPassword(res.getString("Password"));
        user.setEmail(res.getString("Email"));
        user.setAddress(res.getString("Address"));
        user.setRole(res.getString("Role"));
        return user;
    }

    @Override
    public void deleteUser(User user) {
        String query = "DELETE FROM user WHERE UserId = ?";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setInt(1, user.getUserId());
            int executeUpdate = prepareStatement.executeUpdate();
            System.out.println("Rows affected in deleteUser(): " + executeUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {
            while (result.next()) {
                User user = extractUserFromResultSet(result);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE user SET UserName = ?, Password = ?, Email = ?, Address = ?, Role = ? WHERE UserId = ?";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            prepareStatement.setString(1, user.getUserName());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getAddress());
            prepareStatement.setString(5, user.getRole());
            prepareStatement.setInt(6, user.getUserId());
            int executeUpdate = prepareStatement.executeUpdate();
            System.out.println("Rows affected in updateUser(): " + executeUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close resources
    private void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Override finalize() to ensure resources are closed when the object is garbage collected
    @Override
    protected void finalize() throws Throwable {
        try {
            closeResources(connection, null, null);
        } finally {
            super.finalize();
        }
    }
}
