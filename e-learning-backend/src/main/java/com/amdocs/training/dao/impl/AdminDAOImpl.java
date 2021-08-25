package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;
public class AdminDAOImpl implements AdminDAO {
	DataSource dataSource=DataSourceUtil.dataSource();
	@Override
	public boolean saveAdmin(Admin admin) {
		String query = "insert into admin values(?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, admin.getId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getEmail());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean validAdmin(Admin admin) {
		String query="select admin_id,password from admin where admin_id = ? and password=?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, admin.getId());
			ps.setString(2,admin.getPassword());
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
