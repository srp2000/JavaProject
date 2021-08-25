package com.amdocs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.ContactDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Contact;
import com.amdocs.training.model.User;

@WebServlet("/contact")
public class ContactController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("name");
		String email = request.getParameter("mail");
		long phone = Long.parseLong(request.getParameter("phone"));
		int contactId = Integer.parseInt(request.getParameter("contactId"));
		String message = request.getParameter("message");
		
		Contact contact = new Contact(id, username,email, phone,message,contactId);
		
		ContactDAO dao = new ContactDAOImpl();
		
		boolean saveContact = dao.saveContact(contact);
		
		if(saveContact) {
			out.println("Contact Saved Successfully!");
		}
		else {
			out.println("try again");
		}
		
	}
}
