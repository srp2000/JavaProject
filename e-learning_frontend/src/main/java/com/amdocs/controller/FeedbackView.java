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

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.dao.impl.FeedbackDAOImpl;
import com.amdocs.training.model.Feedback;
import com.amdocs.training.model.User;


@WebServlet("/viewFeedbacks")
public class FeedbackView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		List<Feedback> feedbacks=new ArrayList<>();
		FeedbackDAO dao=new FeedbackDAOImpl();
		feedbacks=dao.viewFeedback();
		if(feedbacks.isEmpty())
			out.println("No Records Available !!!");
		else {
		String str=String.format("| %-9s| %-15s| %-25s| %-5s| %-10s|", "user_id","name","email","f_id","feedback");
		out.println(str);
		feedbacks.forEach((n)->out.println(n));
		}
	}
}
