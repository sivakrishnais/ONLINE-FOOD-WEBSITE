package DAOINTERFACES;

import java.util.List;

import MODEL.User;



public interface UserDAO  {
     public boolean addUser(User user);
     public User getUser(String userId);
     public void updateUser(User user);
     public void deleteUser(User user);
     public List<User> getAllUsers();
   
     
     
     
}
