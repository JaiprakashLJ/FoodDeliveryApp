package com.tap;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.MenuDAOIMPL;
import com.tap.daoimpl.RestaurantDAOIMPL;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/getRestaurantById")
public class MenuServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		RestaurantDAOIMPL restaurantdaoimpl=new RestaurantDAOIMPL();
		
		
		Restaurant restaurant=restaurantdaoimpl.getRestaurant(id);
		
		
		MenuDAOIMPL menudaoimpl=new MenuDAOIMPL();
		
		List<Menu>menuList=menudaoimpl.getMenuByRestaurantId(id);
		System.out.println(menuList);
		
		
		req.setAttribute("restaurant", restaurant);
		req.setAttribute("menuList", menuList);
		
		RequestDispatcher rd=req.getRequestDispatcher("Menu.jsp");
		rd.include(req, resp);
		
		
	}

}
