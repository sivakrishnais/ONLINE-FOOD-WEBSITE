package DAOINTERFACES;

import java.util.List;


import MODEL.Order;
public interface OrderDAO {
   void addOrder(Order order);
   Order getOrder(int orderId);
   void updateOrder(Order order);
   void deleteOrder(int orderId);
   List<Order> getAllOrderByUser();
   public int getMaxValueFromOrderTable() ;
   public String getImagePathByOrderId(int orderId) ;
 
   

}
