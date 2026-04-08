package com.tap;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.RestaurantDAOIMPL;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/callingRestaurant")
public class restaurantServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAOIMPL restaurantdaoimpl=new RestaurantDAOIMPL();
		
		List<Restaurant> restaurants=restaurantdaoimpl.getAllRestaurant();
		
		req.setAttribute("Restaurant", restaurants);
		
		RequestDispatcher rd=req.getRequestDispatcher("Restaurant.jsp");
		rd.forward(req, resp);
		
	}

}
