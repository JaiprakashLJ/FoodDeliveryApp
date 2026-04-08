package com.tap.dao;

import java.util.List;

import com.tap.model.Orders;
import com.tap.model.Restaurant;
import com.tap.model.user;

public interface OrdersDAO {
	

	int addOrders(Orders order);
	Orders getOrders(int order_id);
	void updateOrders(Orders order);
	Orders deleteOrders(int order_id);
	List<Orders>getAllOrders();

}
