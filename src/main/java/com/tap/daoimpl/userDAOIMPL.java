package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.userDAO;
import com.tap.model.user;
import com.tap.util.DBconnection;

public class userDAOIMPL implements userDAO{
	
	private static final String INSERT="INSERT into user (userid,name,email,password,phoneNumber,address,role,createdDate,lastLoginDate)"
			+ "values (?,?,?,?,?,?,?,?,?)";
	
	private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE userid=?";

	private static final String UPDATE_USER = "UPDATE user SET name=?, email=?, password=?, address=?, "
            + "lastLoginDate=? WHERE userId=?";

	private static final String DELETE_USER = "DELETE FROM user WHERE userid=?";

	private static final String GET_ALL_USERS = "SELECT * FROM user";
	
	private static final String LOGIN = "Select * FROM user WHERE email=?";


	

	@Override
	public int addUser(user user) {
		
		int res=0;
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(INSERT);){
			
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2,user.getName());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getPassword());
			pstmt.setString(5,user.getPhoneNumber());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			pstmt.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9,new Timestamp(System.currentTimeMillis()));
			
			res=pstmt.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
		
		
	}

	@Override
	public user getUser(int userId) {
		
		user user=null;
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(GET_USER_BY_ID);){
			
			pstmt.setInt(1, userId);
			
			ResultSet resultset=pstmt.executeQuery();
			
			while(resultset.next())
			{
				int id=resultset.getInt("userId");
				String name=resultset.getString("name");
				String email=resultset.getString("email");
				String password=resultset.getString("password");
				String address=resultset.getString("address");
				String role=resultset.getString("role");
				Timestamp createddate=resultset.getTimestamp("createdDate");
				Timestamp lastlogindate=resultset.getTimestamp("lastLoginDate");
				
				user=new user(id,name,email,password,address,role,role, createddate,lastlogindate);
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	

	@Override
	public void updateUser(user user) {
		
		
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(UPDATE_USER);){
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getAddress());
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(6,user.getUserid());
			
			int res=pstmt.executeUpdate();
			
			System.out.println(res);
			
		}
		
		
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public user deleteUser(int userId) {
		
			
			
			try (Connection connection=DBconnection.getDBConnection();
					PreparedStatement pstmt=connection .prepareStatement(DELETE_USER);){
				
				
				pstmt.setInt(1, userId);
				
				int res=pstmt.executeUpdate();
				
				System.out.println(res);
				
				
			}
			
			
			
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
		
		
		
		return null;
	}

	@Override
	public List<user> getAllUser() {
		
		List<user>list=new ArrayList();
		
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection .prepareStatement(GET_ALL_USERS);){
			
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("userId");
				String name=res.getString("name");
				String email=res.getString("email");
				String password=res.getString("password");
				String address=res.getString("address");
				String role=res.getString("role");
				Timestamp createddate=res.getTimestamp("createdDate");
				Timestamp lastlogindate=res.getTimestamp("lastLoginDate");
				
				user user=new user(id,name,email,password,address,role, role, createddate,lastlogindate);
				
				list.add(user);
			}
			
			
			
		}
		
		
		
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	return list;
	}
	
	public user getUserByEmail(String email) {
		 
		 user user=null;
		 
		 try (Connection connection=DBconnection.getDBConnection();
					PreparedStatement pstmt=connection.prepareStatement(LOGIN);){
				
				
				pstmt.setString(1, email);
				
				
				ResultSet res=pstmt.executeQuery();
				
			
				
				if(res.next())
				{
					user=new user();
					user.setEmail(res.getString("email"));
					user.setPassword(res.getString("password"));
					
				}
				
				
				
				
			} 
			
			
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		 
		 
		
		return user;
	 }

}
