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
import com.amdocs.training.dao.impl.CourseDAOImpl;




@WebServlet("/deleteCourse")
public class DeleteCourse extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		CourseDAO dao=new CourseDAOImpl();
		int value=dao.deleteCourse(id);
		if(value > 0)
			out.println("Course Deleted SuccessFully !!!!!!");
		else
			out.println("Invalid Course Details");
		
	}
}
