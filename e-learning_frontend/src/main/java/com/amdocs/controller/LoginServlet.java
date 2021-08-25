package com.amdocs.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
		

	try
	{	    
		 UserDAO dao= new UserDAOImpl();
	     User user = new User();
		 user.setUser_id(Integer.parseInt(request.getParameter("userId")));
		 user.setPassword(request.getParameter("password"));
		 boolean isValid=dao.isValidUser(user);		    
		 if (isValid)
		    {
	    	 HttpSession session = request.getSession(true);	    
		     session.setAttribute("currentSessionUser",user); 
		     response.sendRedirect("userLogged.jsp"); //logged-in page      		
		     }     
		     else 
		          response.sendRedirect("invalidLogin.jsp"); //error page 
		
	}
					
	catch (Throwable theException){
	     System.out.println(theException); 
		}
	}
}
