package com.hrms.attendance.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.entity.Attendance;
import com.hrms.service.AttendanceService;
import com.hrms.service.impl.AttendanceServiceImpl;
import com.hrms.util.DateUtil;
import com.hrms.util.ResultResponse;

@WebServlet("/atten/update")
public class UpdateAttend extends HttpServlet {

	private AttendanceService attendanceService = new AttendanceServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amount = req.getParameter("amount");
		String id = req.getParameter("eId");
		String[] split = req.getParameter("aMonth").split("T");
		Attendance attendance = new Attendance();
		attendance.setAmount(Integer.parseInt(amount));
		attendance.seteId(Integer.parseInt(id));

		attendance.setaMonth(DateUtil.parse(split[0]));

		ResultResponse resultResponse = attendanceService.updateAttend(attendance);
		resp.getWriter().write(JSON.toJSONString(resultResponse));

	}

}
