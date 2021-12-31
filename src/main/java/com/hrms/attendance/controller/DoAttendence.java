package com.hrms.attendance.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.alibaba.fastjson.JSON;
import com.hrms.entity.Attendance;
import com.hrms.service.AttendanceService;
import com.hrms.service.impl.AttendanceServiceImpl;
import com.hrms.util.ResultResponse;
import com.hrms.util.ThUtil;

@WebServlet("/doAttendance")
public class DoAttendence extends HttpServlet {

	private AttendanceService aService = new AttendanceServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Context context = new Context();
		String id = req.getParameter("eId").trim();
		List<Attendance> all = aService.getAllAttendances();
		List<Attendance> now = aService.getCurrentAmonthAtdnc();
		context.setVariable("list", now);
		context.setVariable("listAll", all);

		int intId = Integer.parseInt(id);
		List<Attendance> attendances = aService.getAttendenceById(intId);
		context.setVariable("byId", attendances);
		ResultResponse rr = aService.doAttendance(id, new Date());

		resp.getWriter().write(JSON.toJSONString(rr));
	}

}
