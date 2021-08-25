package com.amdocs.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.CourseDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Course;




@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		UserDAO dao=new UserDAOImpl();
		int value=dao.deleteUser(id);
		if(value>0)
			out.println("User Deleted SuccessFully !!!!!!");
		else
			out.println("Invalid User Details");
		
	}
}
