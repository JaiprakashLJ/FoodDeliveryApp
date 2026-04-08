package com.tap.Servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.daoimpl.userDAOIMPL;
import com.tap.model.user;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/registerServlet")
public class registerServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String phoneNumber=req.getParameter("phoneNumber");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		
		String hashpw=BCrypt.hashpw(password, BCrypt.gensalt(12));
		
		System.out.println(hashpw);
		
		user user=new user(name,email,hashpw,phoneNumber,address,role);
		
		userDAOIMPL userdaoimpl=new userDAOIMPL();
		int res=userdaoimpl.addUser(user);
		
		if(res==1)
		{
			resp.sendRedirect("login.html");
		}
		else
		{
			resp.sendRedirect("Register.html");
		}
		
	}

}
