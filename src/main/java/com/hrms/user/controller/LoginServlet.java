package com.hrms.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.alibaba.fastjson.JSON;
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
import com.hrms.util.ResultResponse;
import com.hrms.util.ThUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SalaryService  sService = new SalaryServiceImpl();
	private UserService userService = new UserServiceImpl();
	private AttendanceService aService = new AttendanceServiceImpl();
	private LeaveService lService = new LeaveServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"   "+ password);
		ResultResponse result = userService.loginService(username, password);
		if("200"== result.getStatusCode()) {
			User user = (User) result.getObj();
			request.getSession().setAttribute("user", user);
			Context context  = new Context();
			context.setVariable("user",  user);
			
			if ("管理员".equals(user.geteJob())) {
				ThUtil.write("mian.html", context, response);				
			}else {
				String state = lService.searchNowStateByEid(user.geteId());
				System.out.println(state);
				List<Attendance> attendenceById = aService.getAttendenceById(user.geteId());
				List<Salary> salaryId = sService.getBySalaryById(user.geteId());
				context.setVariable("byId", attendenceById);
				context.setVariable("sList", salaryId);
				context.setVariable("state", state);
				ThUtil.write("home.html", context, response);
			}
			
			
			
		}
		response.getWriter().write(JSON.toJSONString(result));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
