package com.tap;

import java.io.IOException;

import com.tap.daoimpl.MenuDAOIMPL;
import com.tap.model.Cart;
import com.tap.model.Menu;
import com.tap.model.cartItem;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet ("/cart")
public class cartServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		HttpSession session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		
		
		
		int newRestaurantID=Integer.parseInt(req.getParameter("restaurantId"));
		Integer oldRestaurantID=(Integer)session.getAttribute("id");
		
		if(cart == null || oldRestaurantID != newRestaurantID)
		{
			cart=new Cart();
			
			session.setAttribute("cart", cart);
			session.setAttribute("id", newRestaurantID);
		}
		
		
		
		String action=req.getParameter("action");
		
		
		
		if(action.equals("add"))
		{
			addItemToCart(req,cart);
		}
		else if(action.equals("update"))
		{
			updateItemToCart(req,cart);
		}
		else if(action.equals("delete"))
		{
			deleteItemFromCart(req,cart);
		}
		
		resp.sendRedirect("cart.jsp");
		
	}

	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		
		int menuID=Integer.parseInt(req.getParameter("menuId"));
		
		cart.removeItem(menuID);
		
	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) {
		
		
		int menuID=Integer.parseInt(req.getParameter("menuId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		cart.UpdateItem(menuID, quantity);
		
		
		
		
		
		
		
		
		
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		int menuID=Integer.parseInt(req.getParameter("menuId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		
		MenuDAOIMPL menudaoimpl=new MenuDAOIMPL();
		
		Menu menu=menudaoimpl.getMenu(menuID);
		System.out.println(menu);
		
		cartItem cartitem=new cartItem(menuID,menu.getItemName(),menu.getPrice(),quantity);
		cart.addItem(cartitem);
		
	}

}
