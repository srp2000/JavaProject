package com.amdocs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.dao.impl.CourseDAOImpl;
import com.amdocs.training.model.Course;

@WebServlet("/course")
public class CourseController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("name");
		String description = request.getParameter("description");
		double fee = Double.parseDouble(request.getParameter("fee"));
		String resource = request.getParameter("resource");
		
		CourseDAO dao=new CourseDAOImpl();
		Course course=new Course(id,username,fee,description,resource);
		boolean saveCourser = dao.saveCourse(course);
		
		if(saveCourser) {
			out.println("Course Saved Successfully!");
		}
		else {
			out.println("try again");
		}
	}
}
