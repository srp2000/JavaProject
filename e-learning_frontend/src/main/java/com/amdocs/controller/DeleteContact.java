package com.amdocs.controller;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.dao.impl.ContactDAOImpl;

@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		ContactDAO dao=new ContactDAOImpl();
		int value=dao.deleteContact(id);
		if(value > 0)
			out.println("Contact Deleted SuccessFully !!!!!");
		else
			out.println("Invalid Contact Details ");
		
	}
}

