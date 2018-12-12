package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.data.UserOracle;

public class LoginDelegate implements RequestDelegate{
	private Logger log = Logger.getLogger(LoginDelegate.class);
	private UserDAO ud = new UserOracle();
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String switchString = (String) req.getAttribute("uri");
		switch(switchString) {
		case "login": login(req,resp); break;
		case "logout": logout(req,resp); break;
		default: resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String method = req.getMethod();
		log.trace(method+" method received by logout");
		if("GET".equals(method)) {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		req.getSession().invalidate();
		resp.sendRedirect("login");
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		log.trace(method+" method received by login");
		if("GET".equals(method)) {
			getLogin(req, resp);
		} else {
			postLogin(req,resp);
		}
	}

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		User u = ud.getUser(username, password);
		if(u==null) {
			resp.sendRedirect("login");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			resp.sendRedirect("home");
		}
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null) {
			req.getRequestDispatcher("static/login.html").forward(req, resp);
		} else {
			resp.sendRedirect("home");
		}
	}

}
