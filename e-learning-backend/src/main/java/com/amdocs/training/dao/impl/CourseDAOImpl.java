package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Course;
import com.amdocs.training.model.User;

public class CourseDAOImpl implements CourseDAO {
	DataSource dataSource=DataSourceUtil.dataSource();
	@Override
	public boolean saveCourse(Course course) {
		String query = "insert into course values(?,?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, course.getCourse_id());
			ps.setString(2, course.getC_name());
			ps.setDouble(3, course.getC_fees());
			ps.setString(4, course.getC_desp());
			ps.setString(5, course.getC_resource());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	@Override
	public List<Course> viewCourse() {
		List<Course> courses=new ArrayList<>();
		String query="select * from course";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("course_id");
				String courseName=rs.getString("c_name");
				double fee=rs.getDouble("c_fees");
				String description=rs.getString("c_desp");
				String resource=rs.getString("c_resource");
				Course course=new Course(id,courseName,fee,description,resource);
				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int deleteCourse(int a) {
		String query="delete  from course where course_id = ?";
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
	public int updateCourseFee(String a, double b, String c, String d, int e) {
		String query="update course set c_name=?,c_fees=?,c_desp=?,c_resource=? where course_id = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, a);
			ps.setDouble(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			ps.setInt(5, e);
			int x=ps.executeUpdate();
			return x;
			}
		catch(Exception x) {
			System.out.println(x.getMessage());
		}
		return 0;
	}
	
	

}
