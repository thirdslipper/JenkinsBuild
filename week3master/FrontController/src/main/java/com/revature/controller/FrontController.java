package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.delegates.RequestHelper;

public class FrontController extends DefaultServlet{
	private static final long serialVersionUID = 4807799638038773525L;
	private Logger log = Logger.getLogger(FrontController.class);
	private RequestHelper rh = new RequestHelper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.trace(req.getRequestURI());
		log.trace(req.getContextPath());
		if(req.getRequestURI().substring(req.getContextPath()
				.length()).startsWith("/static")) {
			log.trace("This is a request for static content");
			
			super.doGet(req, resp);
		} else {
			log.trace("Our Front Controller will handle it!");
			rh.process(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}

}
