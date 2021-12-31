package com.hrms.leave.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.service.LeaveService;
import com.hrms.service.impl.LeaveServiceImpl;
import com.hrms.util.ResultResponse;

@WebServlet("/leave/del")
public class DelLeave extends HttpServlet {

	private LeaveService lService = new LeaveServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("lId"));
		
		ResultResponse rr =  lService.delLeaveInfo(id);
		resp.getWriter().write(JSON.toJSONString(rr));
	}

}
