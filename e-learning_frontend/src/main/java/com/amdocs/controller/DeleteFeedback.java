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


@WebServlet("/deleteFeedback")
public class DeleteFeedback extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		FeedbackDAO dao=new FeedbackDAOImpl();
		int value=dao.deleteFeedback(id);
		if(value > 0)
			out.println("Feedback Deleted SuccessFully !!!!!!");
		else
			out.println("Invalid Feedback Details");
		
	}
}
