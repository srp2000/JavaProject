package com.amdocs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.FeedbackDAO;

import com.amdocs.training.dao.impl.FeedbackDAOImpl;

import com.amdocs.training.model.Feedback;


@WebServlet("/feedback")
public class FeedbackController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("name");
		String email = request.getParameter("mail");
		int feedbackId = Integer.parseInt(request.getParameter("feedbackId"));
		String feedback1 = request.getParameter("feedback");
		
		Feedback feedback = new Feedback(id, username,email,feedbackId,feedback1);
	
		FeedbackDAO dao = new FeedbackDAOImpl();
		
		boolean saveFeedback = dao.saveFeedback(feedback);
		
		if(saveFeedback) {
			out.println("Feedback Saved Successfully!");
		}
		else {
			out.println("try again");
		}
		
	}

}
