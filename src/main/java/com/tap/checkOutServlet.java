package com.tap;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.daoimpl.OrderItemDAOIMPL;
import com.tap.daoimpl.OrdersDAOIMPL;
import com.tap.model.Cart;
import com.tap.model.OrderItem;
import com.tap.model.Orders;
import com.tap.model.cartItem;
import com.tap.model.user;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet ("/checkout")
public class checkOutServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession session=req.getSession();
		
		Cart cart=(Cart)session.getAttribute("cart");
		user user=(user)session.getAttribute("user");
		Integer restaurantId=(Integer)session.getAttribute("id");
		
		
		String paymentMethod=req.getParameter("paymentMethod");
		String address=req.getParameter("address");
		
		double totalAmount=0;
		
		if(user != null)
		{
		
		if(cart != null &&  !cart.getItems().isEmpty())
		{
				for(cartItem item:cart.getItems().values()) {
					
					totalAmount += item.getPrice() * item.getQuantity();
				}
				
				Orders orders=new Orders(
						user.getUserid(),
						restaurantId,
						new Timestamp(System.currentTimeMillis()),
						totalAmount,
						"pending",
						paymentMethod,
						address);
				
				
				OrdersDAOIMPL ordersdaoimpl=new OrdersDAOIMPL();
				int orderId=(Integer)ordersdaoimpl.addOrders(orders);
				
				OrderItemDAOIMPL orderitemdaoimpl=new OrderItemDAOIMPL();
				
				for(cartItem items:cart.getItems().values())
				{
					int menuId=items.getMenuId();
					double price=items.getPrice();
					int quantity=items.getQuantity();
					double totalPrice=price * quantity;
					
					OrderItem orderitem=new OrderItem(orderId,menuId,quantity,totalPrice);
					
					orderitemdaoimpl.addOrderItem(orderitem);
				}
		}
		else
		{
			resp.sendRedirect("restaurantServlet");
		}
		}
		
		else
		{
			resp.sendRedirect("login.html");
		}
	}

}
	