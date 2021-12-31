package com.hrms.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.hrms.entity.Attendance;
import com.hrms.entity.Salary;
import com.hrms.entity.User;
import com.hrms.service.AttendanceService;
import com.hrms.service.LeaveService;
import com.hrms.service.SalaryService;
import com.hrms.service.UserService;
import com.hrms.service.impl.AttendanceServiceImpl;
import com.hrms.service.impl.LeaveServiceImpl;
import com.hrms.service.impl.SalaryServiceImpl;
import com.hrms.service.impl.UserServiceImpl;
import com.hrms.util.ThUtil;

@WebServlet("/toHome")
public class ToHome extends HttpServlet {

    
	private SalaryService  sService = new SalaryServiceImpl();
	private UserService userService = new UserServiceImpl();
	private AttendanceService aService = new AttendanceServiceImpl();
	private LeaveService lService = new LeaveServiceImpl();
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		Context context = new Context();
		context.setVariable("user", user);
		if ("管理员".equals(user.geteJob())) {			
			ThUtil.write("mian.html", context, resp);
		}else {
			String state = lService.searchNowStateByEid(user.geteId());
			System.out.println("当前状态"+state);
			List<Attendance> attendenceById = aService.getAttendenceById(user.geteId());
			List<Salary> salaryId = sService.getBySalaryById(user.geteId());
			context.setVariable("byId", attendenceById);
			context.setVariable("sList", salaryId);
			context.setVariable("state", state);
			ThUtil.write("home.html", context, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
