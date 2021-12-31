package com.hrms.leave.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.entity.Leave;
import com.hrms.service.LeaveService;
import com.hrms.service.impl.LeaveServiceImpl;
import com.hrms.util.DateUtil;

@WebServlet("/addLeave")
public class AddLeave extends HttpServlet {

	private LeaveService lService = new LeaveServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eId = req.getParameter("eId");

		String start = req.getParameter("start");
		String end = req.getParameter("end");
		String desc = req.getParameter("desc");
		Leave leave = new Leave();
		leave.seteId(Integer.parseInt(eId));
		leave.setStart(DateUtil.parse(start));
		leave.setEnd(DateUtil.parse(end));
		leave.setDesc(desc);
		lService.addLeave(leave);
		resp.sendRedirect("/hrms/toHome");
	}

}
