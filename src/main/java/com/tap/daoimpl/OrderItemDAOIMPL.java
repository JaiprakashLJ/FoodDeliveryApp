package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBconnection;

public class OrderItemDAOIMPL implements OrderItemDAO {

	private static final String INSERT = "INSERT INTO order_item (order_item_id,order_id,menu_id,quantity,total_price)"
			+ "values(?,?,?,?,?)";
	private static final String GET_ORDERITEM_BY_ID = "SELECT * FROM order_item WHERE order_id=?";
	private static final String UPDATE_ORDER_ITEM_BY_ID = "UPDATE order_item SET quantity=?,total_price=?";
	private static final String DELETE_ORDER_ITEM_BY_ID = "DELETE order_item WHERE order_id=?";
	private static final String GET_ALL_ORDER_ITEMS = null;

	@Override
	public void addOrderItem(OrderItem orderitem) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT);) {

			pstmt.setInt(1, orderitem.getOrderId());
			pstmt.setInt(2, orderitem.getOrderId());
			pstmt.setInt(3, orderitem.getMenuId());
			pstmt.setInt(4, orderitem.getQuantity());
			pstmt.setDouble(5, orderitem.getTotalPrice());

			int res = pstmt.executeUpdate();

			System.out.println(res);

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public OrderItem getOrderItem(int order_item_id) {

		OrderItem orderitem = null;

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ORDERITEM_BY_ID);) {

			pstmt.setInt(1, order_item_id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int orderitemid = res.getInt("order_item_id");
				int orderid = res.getInt("order_id");
				int menuid = res.getInt("menu_id");
				int quantity = res.getInt("quantity");
				double price = res.getDouble("total_price");

				orderitem = new OrderItem(orderitemid, orderid, menuid, quantity, price);

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return orderitem;
	}

	@Override
	public void updateOrderItem(OrderItem orderitem) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_ORDER_ITEM_BY_ID);) {

			pstmt.setDouble(1, orderitem.getTotalPrice());
			pstmt.setInt(2, orderitem.getQuantity());

			int res = pstmt.executeUpdate();

			System.out.println(res);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public OrderItem deleteOrderItem(int order_item_id) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_ORDER_ITEM_BY_ID);) {

			pstmt.setInt(1, order_item_id);

			int res = pstmt.executeUpdate();

			System.out.println(res);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItem() {

		OrderItem orderitem = null;

		List<OrderItem> list = new ArrayList();

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_ORDER_ITEMS);) {

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int orderitemid = res.getInt("order_item_id");
				int orderid = res.getInt("order_id");
				int menuid = res.getInt("menu_id");
				int quantity = res.getInt("quantity");
				double price = res.getDouble("total_price");

				orderitem = new OrderItem(orderitemid, orderid, menuid, quantity, price);

				list.add(orderitem);

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
