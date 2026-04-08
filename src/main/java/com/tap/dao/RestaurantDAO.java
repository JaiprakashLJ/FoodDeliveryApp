package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;
import com.tap.model.user;

public interface RestaurantDAO {
	
	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int restaurant_id);
	void updateRestaurant(Restaurant restaurant);
	user deleteRestaurant(int restaurant_id);
	List<Restaurant>getAllRestaurant();
	

}
