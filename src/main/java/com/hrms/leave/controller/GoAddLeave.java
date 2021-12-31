package com.hrms.leave.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.hrms.util.ThUtil;

@WebServlet("/goAddLeave")
public class GoAddLeave extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eId = Integer.parseInt(req.getParameter("eId"));
		Context context = new Context();
		context.setVariable("eId", eId);
		ThUtil.write("addLeave.html",	 context, resp);
		
	
	}
	
}
