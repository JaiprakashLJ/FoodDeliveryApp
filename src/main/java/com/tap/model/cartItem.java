package com.tap.model;

public class cartItem {
	
	private int menuId;
	private String itemName;
	private double price;
	private int quantity;
	private double totalPrice;
	
	public cartItem() {
		
	}

	public cartItem(int menuId, String itemName, double price, int quantity,double totalPrice) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice=totalPrice;
		
	}
	
	

	public cartItem(int menuId, String itemName, double price, int quantity) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalPrice() {
		return price*quantity;
	}
	

	@Override
	public String toString() {
		return "cartItem [menuId=" + menuId + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + " , totalPrice=" + totalPrice + "]";
	}
	
	
	

}
