package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.model.Restaurant;
import com.tap.util.DBconnection;

public class MenuDAOIMPL implements MenuDAO{

	private static final String INSERT = "INSERT INTO Menu (menu_id,restaurant_id,item_name,"
			+ "description,price,is_available) values(?,?,?,?,?,?)";
	private static final String GET_MENU_BY_ID = "SELECT * FROM menu WHERE menu_id=?";
	private static final String UPDATE_MENU_BY_ID = "UPDATE Menu SET item_name=?,description=?,price=?,is_available=? WHERE menu_id=?";
	private static final String DELETE_MENU_BY_ID = "DELETE FROM menu WHERE menu_id=?";
	private static final String GET_ALL_MENU = "SELECT * FROM menu";
	private static final String GET_MENU_BY_RESTAURANT_ID = "SELECT * FROM menu WHERE restaurant_id = ?";
	private Menu menu;

	@Override
	public void addMenu(Menu menu) {
		
		
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(INSERT);){
			
			pstmt.setInt(1, menu.getMenuId());
			pstmt.setInt(2,menu.getRestaurantId());
			pstmt.setString(3, menu.getItemName());
			pstmt.setString(4, menu.getDescription());
			pstmt.setDouble(5, menu.getPrice());
			pstmt.setBoolean(6, false);
			
			int res=pstmt.executeUpdate();
			
			System.out.println(res);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int menu_id) {
		
		
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(GET_MENU_BY_ID);){
			
			pstmt.setInt(1, menu_id);
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("menu_id");
				int restaurant_id=res.getInt("restaurant_id");
				String itemname=res.getString("item_name");
				String description=res.getString("description");
				
				double price=res.getDouble("price");
				boolean isavailable=res.getBoolean("is_available");
				String imagePath=res.getString("image_Path");
				
				
				
				 menu = new Menu(id,restaurant_id,itemname,description,price,isavailable,imagePath);
				
			}
			
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		
		
		
		
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(UPDATE_MENU_BY_ID);){
			
			
			pstmt.setString(1,menu.getItemName());
			pstmt.setString(2, menu.getDescription());
			pstmt.setDouble(3,menu.getPrice());
			pstmt.setBoolean(4, menu.isAvailable());
			pstmt.setInt(5, menu.getMenuId());
			
			int res=pstmt.executeUpdate();
			
			System.out.println(res);
			
		} 
		
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu deleteMenu(int menu_id) {
		
		
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(DELETE_MENU_BY_ID);){
			
			pstmt.setInt(1, menu_id);
			
			int res=pstmt.executeUpdate();
			
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public List<Menu> getAllMenu() {
		
		List<Menu>list=new ArrayList();
		
		try (Connection connection=DBconnection.getDBConnection();
				PreparedStatement pstmt=connection.prepareStatement(GET_ALL_MENU);){
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("menu_id");
				int restaurant_id=res.getInt("restaurant_id");
				String itemname=res.getString("item_name");
				String description=res.getString("description");
				
				double price=res.getDouble("price");
				boolean isavailable=res.getBoolean("is_available");
				String imagePath=res.getString("imagePath");
				
				
				
				 menu = new Menu(id,restaurant_id,itemname,description,price,isavailable,imagePath);
				 
				 list.add(menu);
				
			}
			
			
			
		} 
		
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return list;
	}
	
	
	public List<Menu> getMenuByRestaurantId(int restaurantId) {

	    List<Menu> menuList = new ArrayList<>();

	    

	    try (Connection con = DBconnection.getDBConnection();
	         PreparedStatement ps = con.prepareStatement(GET_MENU_BY_RESTAURANT_ID)) {

	        ps.setInt(1, restaurantId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Menu m = new Menu();

	            m.setMenuId(rs.getInt("menu_id"));
	            m.setRestaurantId(rs.getInt("restaurant_id"));
	            m.setItemName(rs.getString("item_name"));
	            m.setPrice(rs.getDouble("price"));
	            m.setImagePath(rs.getString("image_path"));

	            menuList.add(m);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return menuList;
	}
	
	
	

}
