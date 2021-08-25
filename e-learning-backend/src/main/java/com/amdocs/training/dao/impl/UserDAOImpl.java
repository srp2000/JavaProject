package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.User;

public class UserDAOImpl implements UserDAO {
	DataSource dataSource=DataSourceUtil.dataSource();
	//Connection conn = null;
	@Override
	public boolean saveUser(User user) {
		String query = "insert into user values(?,?,?,?,?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user.getUser_id());
			ps.setString(2, user.getName());
			ps.setLong(3, user.getPhone_no());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getReg_date());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getUpload_photo());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<User> viewUser() {
		List<User> users=new ArrayList<>();
		String query="select * from user";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("user_id");
				String name=rs.getString("name");
				Long phone=rs.getLong("phone_no");
				String mail=rs.getString("email");
				String address=rs.getString("address");
				String date=rs.getString("reg_date");
				String password=rs.getString("password");
				String photo=rs.getString("upload_photo");
				User user=new User(id,name,phone,mail,address,date,password,photo);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getUserById(int a) {
		User user;
		String query="select * from user where user_id = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, a);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("user_id");
				String name=rs.getString("name");
				Long phone=rs.getLong("phone_no");
				String mail=rs.getString("email");
				String address=rs.getString("address");
				String date=rs.getString("reg_date");
				String password=rs.getString("password");
				String photo=rs.getString("upload_photo");
				user=new User(id,name,phone,mail,address,date,password,photo);
				return user;
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	@Override
	public int deleteUser(int a) {
		User user;
		String query="delete  from user where user_id = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, a);
			int x=ps.executeUpdate();
			return x;
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	@Override
	public boolean isValidUser(User user) {
		
		String query="select user_id,password from user where user_id = ? and password=?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user.getUser_id());
			ps.setString(2,user.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
