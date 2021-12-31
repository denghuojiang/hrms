package com.hrms.leave.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.hrms.entity.Leave;
import com.hrms.service.LeaveService;
import com.hrms.service.impl.LeaveServiceImpl;
import com.hrms.util.ThUtil;

@WebServlet("/goLeaveInfo")
public class GoLeaveInfo  extends HttpServlet{

	
	private LeaveService lService  = new LeaveServiceImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Leave> list =  lService.getAllLeaveInfo();
		Context context = new Context();
		context.setVariable("list", list);
		ThUtil.write("leaveList.html", context, resp);
		
	}
	
	
	
	
}
