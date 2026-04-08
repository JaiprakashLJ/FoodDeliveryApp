package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.model.user;
import com.tap.util.DBconnection;

public class RestaurantDAOIMPL implements RestaurantDAO {

	private static final String INSERT = "INSERT into restaurant (restaurant_Id,name,cuisine_Type,delivery_Time,"
			+ "address,admin_User_Id," + "rating,is_Active,image_Path)" + "values (?,?,?,?,?,?,?,?,?)";
	private static final String GET_RESTAURANT_BY_ID = "SELECT * FROM Restaurant WHERE restaurant_id=?";
	private static final String UPDATE_RESTAURANT_BY_ID = "UPDATE Restaurant SET name=?,cuisine_type=?,delivery_time=?,"
			+ "address=?,is_active=?,image_path=? WHERE restaurant_id=?";
	private static final String DELETE_RESTAURANT_BY_ID = "DELETE FROM Restaurant WHERE restaurant_id=?";
	private static final String GET_ALL_RESTAURANT = "SELECT * FROM restaurant";
	private Restaurant restaurant;

	@Override
	public void addRestaurant(Restaurant restaurant) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT);) {

			pstmt.setInt(1, restaurant.getRestaurantId());
			pstmt.setString(2, restaurant.getName());
			pstmt.setString(3, restaurant.getCuisineType());
			pstmt.setInt(4, restaurant.getDeliveryTime());
			pstmt.setString(5, restaurant.getAddress());
			pstmt.setInt(6, restaurant.getAdminUserId());
			pstmt.setDouble(7, restaurant.getRating());
			pstmt.setBoolean(8, restaurant.isActive());
			pstmt.setString(9, restaurant.getImagePath());

			int res = pstmt.executeUpdate();

			System.out.println(res);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Restaurant getRestaurant(int restaurant_id) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_RESTAURANT_BY_ID);) {

			pstmt.setInt(1, restaurant_id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int id = res.getInt("restaurant_id");
				String name = res.getString("name");
				String cuisinetype = res.getString("cuisine_type");
				int deliverytime = res.getInt("delivery_time");
				String address = res.getString("address");
				int adminid = res.getInt("admin_user_id");
				double rating = res.getDouble("rating");
				boolean isactive = res.getBoolean("is_active");
				String imagepath = res.getString("image_path");

				restaurant = new Restaurant(id, name, cuisinetype, deliverytime, address, adminid, rating, isactive,
						imagepath);

			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {

		try (Connection connection = DBconnection.getDBConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_RESTAURANT_BY_ID);) {

			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setBoolean(5, restaurant.isActive());
			pstmt.setString(6, restaurant.getImagePath());
			pstmt.setInt(7, restaurant.getRestaurantId());

			int res = pstmt.executeUpdate();

			System.out.println(res);

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public user deleteRestaurant(int restaurant_id) {

		Connection connection = DBconnection.getDBConnection();

		try {
			PreparedStatement pstmt = connection.prepareStatement(DELETE_RESTAURANT_BY_ID);

			pstmt.setInt(1, restaurant_id);

			int res = pstmt.executeUpdate();

			System.out.println(res);

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {

		List<Restaurant> list = new ArrayList();

		Connection connection = DBconnection.getDBConnection();

		try {
			PreparedStatement pstmt = connection.prepareStatement(GET_ALL_RESTAURANT);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int id = res.getInt("restaurant_id");
				String name = res.getString("name");
				String cuisinetype = res.getString("cuisine_type");
				int deliverytime = res.getInt("delivery_time");
				String address = res.getString("address");
				int adminid = res.getInt("admin_user_id");
				double rating = res.getDouble("rating");
				boolean isactive = res.getBoolean("is_active");
				String imagepath = res.getString("image_path");

				Restaurant restaurant = new Restaurant(id, name, cuisinetype, deliverytime, address, adminid, rating,
						isactive, imagepath);

				list.add(restaurant);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
	
	
	

}
