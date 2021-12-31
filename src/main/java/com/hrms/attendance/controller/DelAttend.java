package com.hrms.attendance.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.service.AttendanceService;
import com.hrms.service.impl.AttendanceServiceImpl;
import com.hrms.util.ResultResponse;

@WebServlet("/atten/del")
public class DelAttend extends HttpServlet {

	private AttendanceService attendanceService = new AttendanceServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("eId");
		String[] date = req.getParameter("aMonth").split("T");
		ResultResponse resultResponse = attendanceService.delAttend(Integer.parseInt(id), date[0]);
		
		resp.getWriter().write(JSON.toJSONString(resultResponse));

	}

}
