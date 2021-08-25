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

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;


@WebServlet("/viewUsers")
public class UserView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		List<User> users=new ArrayList<>();
		UserDAO dao=new UserDAOImpl();
		users=dao.viewUser();
		if(users.isEmpty())
			out.println("No Records Available !!!");
		else {
		String str=String.format("|%-9s|%-20s|%-12s|%-20s|%-19s|%-11s|%-15s|", "user_id","name","phone_no","email","address","reg_date","password");
		out.println(str);
		users.forEach((n)->out.println(n));
		}
	}
}
