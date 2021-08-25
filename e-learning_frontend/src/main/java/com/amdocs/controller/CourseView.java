package com.amdocs.controller;

import java.util.*;

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
import com.amdocs.training.model.Course;




@WebServlet("/viewCourses")
public class CourseView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		List<Course> courses=new ArrayList<>();
		CourseDAO dao=new CourseDAOImpl();
		courses=dao.viewCourse();
		if(courses.isEmpty())
			out.println("No Records Available !!!");
		else {
		String str= new String(String.format(("|%-10s |%-15s |%-25s |%-15s |%-25s|"), "course_id","c_name","c_desp","c_fees","c_resource"));
		out.println(str);
		courses.forEach((n)->out.println(n));
		}
	}
}
