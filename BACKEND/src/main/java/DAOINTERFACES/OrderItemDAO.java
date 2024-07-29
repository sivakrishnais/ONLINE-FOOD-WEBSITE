package DAOINTERFACES;

import java.util.List;

import MODEL.OrderItem;



public interface OrderItemDAO {
    void addOrderItem(OrderItem orderItem);
    OrderItem getOrderItem(int orderItemId);
    void updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(int orderItemId);
    List<OrderItem> getOrderItemByOrder();
}
