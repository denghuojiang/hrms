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

@WebServlet("/goAttendceInfo")
public class GoAttendanceInfo extends HttpServlet {

	private AttendanceService attendanceServiece = new AttendanceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Attendance> all = attendanceServiece.getAllAttendances();
		List<Attendance> now = attendanceServiece.getCurrentAmonthAtdnc();
		Context context = new Context();
		context.setVariable("list", now);
		context.setVariable("listAll", all);
		
		ThUtil.write("attenList.html", context, resp);
	
	
	}
	
	
	
	
}
