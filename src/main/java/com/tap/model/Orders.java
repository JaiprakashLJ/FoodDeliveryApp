package com.tap.model;

import java.security.Timestamp;
import java.sql.Date;

public class Orders {
	

    private int orderId;
    private int userId;
    private int restaurantId;
    private Timestamp orderDate;
    private double totalAmount;
    private String status;
    private String paymentMode;
    private String address;
    
    public Orders() {
    	
    }
    
    
    
    public Orders(int orderId, int userId, int restaurantId, java.sql.Timestamp orderdate2, double totalAmount, String status, String paymentMode) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		
	}



	public Orders(int orderId, int userId, int restaurantId,
    		Timestamp orderDate, double totalAmount,
            String status, String paymentMode,String address) {
    	this.orderId = orderId;
    	this.userId = userId;
    	this.restaurantId = restaurantId;
    	this.orderDate = orderDate;
    	this.totalAmount = totalAmount;
    	this.status = status;
    	this.paymentMode = paymentMode;
    	this.address=address;
    }
    
    public Orders(int orderid2, int userid2, int restaurantid2, java.sql.Timestamp orderdate2, double totalamount2,
			String status2, String status3, String paymentmode2) {
		// TODO Auto-generated constructor stub
	}


	public Orders(int userid2, Integer restaurantId2, java.sql.Timestamp timestamp, double totalAmount2, String string,
			String paymentMethod, String address2) {
		// TODO Auto-generated constructor stub
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

    public int getRestaurantId() {
    	return restaurantId;
    	}
    public void setRestaurantId(int restaurantId) {
    	this.restaurantId = restaurantId; 
    	}

    public Timestamp getOrderDate() { 
    	return orderDate; 
    	}
    public void setOrderDate(Timestamp orderDate) {
    	this.orderDate = orderDate; 
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

    public String getPaymentMode() { 
    	return paymentMode; 
    	}
    public void setPaymentMode(String paymentMode) { 
    	this.paymentMode = paymentMode; 
    	}
    
	  



	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode=" + paymentMode
				+ "]";
	}
    
    
}


