package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;

public class HomeDelegate implements RequestDelegate {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Check to see if wee're logged in
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if(u == null) {
			resp.sendRedirect("login");
		} else {
			PrintWriter pw =resp.getWriter();
			pw.write("<html><head><title>Welcome, " + u.getUsername() + "</title></head><body>");
			pw.write("<div><h1>Welcome back, " + u.getFirst() + " " + u.getLast() + "</h1>"
					+ "<form action=\"logout\" method=\"post\">" + "<input type=\"submit\" value=\"Logout\"/>"
					+ "</form></div>" + "</body></html>");
		}
	}

}
