package MODEL;

import java.util.Date;

public class OrderHistory {

	private int OrderHistoryId ;
	private int userId;
	private int orderId;
	private Date OrderDate;
	private double totalAmount;
	private String status;
	private String restaruentImage;
	

	public OrderHistory() {
		
	}
	
	
	public String getRestaruentImage() {
		return restaruentImage;
	}


	public void setRestaruentImage(String restaruentImage) {
		this.restaruentImage = restaruentImage;
	}


	public OrderHistory(int orderHistoryId, double totalAmount,
			String status) {
	
		this.OrderHistoryId = orderHistoryId;

		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getOrderHistoryId() {
		return OrderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		OrderHistoryId = orderHistoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
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

	@Override
	public String toString() {
		return "OrderHistory [OrderHistoryId=" + OrderHistoryId + ", userId=" + userId + ", orderId=" + orderId
				+ ", OrderDate=" + OrderDate + ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	
	
	

}
