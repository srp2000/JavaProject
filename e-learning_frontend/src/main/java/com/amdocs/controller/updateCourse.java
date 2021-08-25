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




@WebServlet("/updateCourse")
public class updateCourse extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		double fee=Double.parseDouble(req.getParameter("fee"));
		String name=req.getParameter("name");
		String resource=req.getParameter("resource");
		String desp=req.getParameter("desp");
		
		CourseDAO dao=new CourseDAOImpl();
		
		int value=dao.updateCourseFee(name, fee, desp, resource, id);
		if(value > 0)
			out.println("Course Updated SuccessFully !!!!!!");
		else
			out.println("Invalid Course Details");
		
	}
}
