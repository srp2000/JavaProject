package com.amdocs.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amdocs.training.dao.AdminDAO;

import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.model.Admin;

@WebServlet("/LoginServletAdmin")
public class LoginServletAdmin extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
		
		try
		{	    
			 AdminDAO dao= new AdminDAOImpl();
			 Admin admin = new Admin();
			 admin.setId(Integer.parseInt(request.getParameter("userId")));
			 admin.setPassword(request.getParameter("password"));
			 boolean isValid=dao.validAdmin(admin);    
			 if (isValid)
			    {
		    	 HttpSession session = request.getSession(true);	    
			     session.setAttribute("currentSessionUser",admin); 
			     response.sendRedirect("Admin.jsp"); //logged-in page      		
			     }     
			     else 
			          response.sendRedirect("invalidLogin.jsp"); //error page 
			
		}
						
		catch (Throwable theException){
		     System.out.println(theException); 
			}
		}
}
