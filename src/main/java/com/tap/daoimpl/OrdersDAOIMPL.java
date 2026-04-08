package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrdersDAO;
import com.tap.model.Orders;
import com.tap.util.DBconnection;

public class OrdersDAOIMPL implements OrdersDAO {

	private static final String INSER = "INSERT INTO orders (order_id,user_id,restaurant_id,"
			+ "order_date,total_amount,status,payment_mode) values(?,?,?,?,?,?,?)";
	private static final String GET_ORDERS_BY_ID = "SELECT * FROM orders WHERE order_id=?";
	private static final String UPDATE_ORDERS_BY_ID = "UPDATE orders SET total_amount=?,"
			+ "status=?,payment_mode=? WHERE order_id=?";
	private static final String DELETE_ORDERS_BY_ID = "DELETE orders WHERE order_id=?";
	private static final String GET_ALL_ORDERS = null;

	@Override
	public int addOrders(Orders order) {

	    try (Connection connection = DBconnection.getDBConnection();
	         PreparedStatement pstmt = connection.prepareStatement(INSER, Statement.RETURN_GENERATED_KEYS)) {

	        pstmt.setInt(1, order.getOrderId());
	        pstmt.setInt(2, order.getUserId());
	        pstmt.setInt(3, order.getRestaurantId());
	        pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
	        pstmt.setDouble(5, order.getTotalAmount());
	        pstmt.setString(6, order.getStatus());
	        pstmt.setString(7, order.getPaymentMode());

	        int res = pstmt.executeUpdate();

	        if (res == 0) {
	            throw new SQLException("Creating order failed, no rows affected.");
	        }

	        ResultSet ids = pstmt.getGeneratedKeys();

	        if (ids.next()) {
	            return ids.getInt(1);   // ✔️ return int
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return -1;   // ✔️ fallback
	}

	@Override
	public Orders getOrders(int order_id) {

		Orders order = null;

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ORDERS_BY_ID);) {

			pstmt.setInt(1, order_id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int orderid = res.getInt("order_id");
				int userid = res.getInt("user_id");
				int restaurantid = res.getInt("restaurant_id");
				Timestamp orderdate = res.getTimestamp("order_date");
				double totalamount = res.getDouble("total_amount");
				String status = res.getString("status");
				String paymentmode = res.getString("payment_mode");

				order = new Orders(orderid, userid, restaurantid, orderdate, totalamount, status, paymentmode);
			}
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return order;
	}

	@Override
	public void updateOrders(Orders order) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_ORDERS_BY_ID);) {

			pstmt.setDouble(1, order.getTotalAmount());
			pstmt.setString(2, order.getStatus());
			pstmt.setString(3, order.getPaymentMode());
			pstmt.setInt(4, order.getOrderId());

			int res = pstmt.executeUpdate();

			System.out.println(res);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Orders deleteOrders(int order_id) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_ORDERS_BY_ID);) {

			pstmt.setInt(1, order_id);

			int res = pstmt.executeUpdate();

			System.out.println(res);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Orders> getAllOrders() {

		Orders order = null;

		List<Orders> list = new ArrayList();

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_ORDERS);) {

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int orderid = res.getInt("order_id");
				int userid = res.getInt("user_id");
				int restaurantid = res.getInt("restaurant_id");
				Timestamp orderdate = res.getTimestamp("order_date");
				double totalamount = res.getDouble("total_amount");
				String status = res.getString("status");
				String paymentmode = res.getString("payment_mode");

				order = new Orders(orderid, userid, restaurantid, orderdate, totalamount, status, paymentmode);

				list.add(order);
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

}
