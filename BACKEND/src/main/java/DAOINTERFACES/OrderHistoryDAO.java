package DAOINTERFACES;

import java.util.List;

import MODEL.Order;
import MODEL.OrderHistory;

public interface OrderHistoryDAO {
	void addOrderHistory(OrderHistory orderHistory);
	   OrderHistory getOrderHistoryId(int orderId);
	   void updateOrderHistory(OrderHistory order);
	   void deleteOrderHistory(int orderId);
	   List<OrderHistory> getAllOrderByUser();
	
}
