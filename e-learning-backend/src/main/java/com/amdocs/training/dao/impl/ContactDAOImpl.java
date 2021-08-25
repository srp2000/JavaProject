package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Contact;
import com.amdocs.training.model.Course;
import com.amdocs.training.model.Feedback;
public class ContactDAOImpl implements ContactDAO {
	DataSource dataSource=DataSourceUtil.dataSource();
	@Override
	public boolean saveContact(Contact contact) {
		String query = "insert into contact values(?,?,?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, contact.getUser_id());
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getEmail());
			ps.setLong(4, contact.getPhone_no());
			ps.setString(5, contact.getMessage());
			ps.setInt(6, contact.getContact_id());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Contact> viewContact() {
		List<Contact> contacts=new ArrayList<>();
		String query="select * from contact";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("user_id");
				String name=rs.getString("name");
				String mail=rs.getString("email");
				long phone =rs.getLong("phone_no");
				String message=rs.getString("messege");
				int contactId=rs.getInt("contact_id");
				Contact contact=new Contact(id,name,mail,phone,message,contactId);
				contacts.add(contact);
			}
			return contacts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int deleteContact(int a) {
		
		String query="delete  from contact where contact_id = ?";
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
}
