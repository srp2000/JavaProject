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

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.dao.impl.ContactDAOImpl;
import com.amdocs.training.model.Contact;

@WebServlet("/viewContacts")
public class ContactView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		List<Contact> contacts=new ArrayList<>();
		ContactDAO dao=new ContactDAOImpl();
		contacts=dao.viewContact();
		if(contacts.isEmpty())
			out.println("No Records Available !!!");
		else {
		String str=String.format("|%-9s|%-15s|%-20s|%-12s|%-5s|", "user_id","name","email","phone_no","contact_id");
		out.println(str);
		contacts.forEach((n)->out.println(n));
		}
	}
}
