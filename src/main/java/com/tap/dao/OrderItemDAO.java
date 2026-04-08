package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItem;
import com.tap.model.Orders;

public interface OrderItemDAO {

	public void addOrderItem(OrderItem orderitem);

	public OrderItem getOrderItem(int order_item_id);

	public void updateOrderItem(OrderItem orderitem);

	public OrderItem deleteOrderItem(int order_item_id);

	public List<OrderItem> getAllOrderItem();

}
