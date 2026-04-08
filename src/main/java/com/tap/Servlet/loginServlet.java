package com.tap.Servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.daoimpl.userDAOIMPL;
import com.tap.model.user;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet ("/loginServlet")
public class loginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		HttpSession session=req.getSession();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		userDAOIMPL userdaoimpl=new userDAOIMPL();
		user user=userdaoimpl.getUserByEmail(email);
		String DBpassword=user.getPassword();
		
		//System.out.println(DBpassword);
		
		if(user!=null && BCrypt.checkpw(password,DBpassword ))
		{
			session.setAttribute("user", user);
			resp.sendRedirect("callingRestaurant");
		}
		else
		{
			resp.sendRedirect("login.html");
		}
		
	}

}
