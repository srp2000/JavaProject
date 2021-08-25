package com.amdocs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

@WebServlet("/register")
public class UserContoller extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("name");
		long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("mail");
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		String photo = request.getParameter("photo");
		String password = request.getParameter("password");

		User user = new User(id, username, phone,email,address,date,password,photo);
		
		UserDAO dao = new UserDAOImpl();
		
		boolean saveUser = dao.saveUser(user);
		
		if(saveUser) {
			out.println("User Saved Successfully!");
		}
		else {
			out.println("try again");
		}
	}

}
