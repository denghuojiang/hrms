package com.hrms.attendance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.hrms.entity.Attendance;
import com.hrms.service.AttendanceService;
import com.hrms.service.impl.AttendanceServiceImpl;
import com.hrms.util.ThUtil;

@WebServlet("/selectAttendance")
public class SelectAttendance extends HttpServlet {
	private AttendanceService attendanceServiece = new AttendanceServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("eId");
		int intId = Integer.parseInt(id);
		List<Attendance> list = attendanceServiece.getAttendenceById(intId);
		Context context = new Context();
		context.setVariable("byId", list);
		ThUtil.write("attenList.html", context, resp);
		
	}
}
