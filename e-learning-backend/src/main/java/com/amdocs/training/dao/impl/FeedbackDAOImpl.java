package com.amdocs.training.dao.impl;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Feedback;
import com.amdocs.training.model.User;
public class FeedbackDAOImpl implements FeedbackDAO {
	DataSource dataSource=DataSourceUtil.dataSource();
	@Override
	public boolean saveFeedback(Feedback feedback) {
		String query = "insert into feedback values(?,?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, feedback.getUser_id());
			ps.setString(2, feedback.getName());
			ps.setString(3, feedback.getEmail());
			ps.setInt(4, feedback.getF_id());
			ps.setString(5, feedback.getFeedback());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Feedback> viewFeedback() {
		List<Feedback> feedbacks=new ArrayList<>();
		String query="select * from feedback";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("user_id");
				String name=rs.getString("name");
				String mail=rs.getString("email");
				int f_id=rs.getInt("f_id");
				String feedback1=rs.getString("feedback");
				Feedback feedback=new Feedback(id,name,mail,f_id,feedback1);
				feedbacks.add(feedback);
			}
			return feedbacks;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int deleteFeedback(int a) {
		
		String query="delete  from feedback where f_id = ?";
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
