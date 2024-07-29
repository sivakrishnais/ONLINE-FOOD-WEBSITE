package MODEL;

import java.time.LocalDate;
import java.util.Date;

public class Order {
	private int orderId;
	private int userId;
	private int restaurentId;
	private LocalDate orderDate;
	private double totalAmount;
	private String status;
	private String paymentMethod;
     public  Order() {
		
	}
	public Order(int orderId,  LocalDate now, double totalAmount, String status,
			String paymentMethod) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurentId = restaurentId;
		this.orderDate = now;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate date) {
		this.orderDate = date;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurentId=" + restaurentId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMethod=" + paymentMethod
				+ "]";
	}
	
	

}
