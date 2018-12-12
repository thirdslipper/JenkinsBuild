package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	private HomeDelegate hd;
	private LoginDelegate ld;
	
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(hd==null) {
			hd=new HomeDelegate();
		}
		if(ld==null) {
			ld=new LoginDelegate();
		}
		// /FrontController/home/hi
		String switchString = req.getRequestURI().substring(req.getContextPath().length()+1);
		// home/hi
		
		while(switchString.indexOf("/")>0) {
			switchString = switchString.substring(0,switchString.indexOf("/"));
		}
		req.setAttribute("uri", switchString);
		switch(switchString) {
		case "home": hd.process(req, resp); break;
		case "login": ld.process(req, resp); break;
		case "logout": ld.process(req, resp); break;
		default: resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
