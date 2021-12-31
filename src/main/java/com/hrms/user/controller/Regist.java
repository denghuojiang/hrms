package com.hrms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.entity.User;
import com.hrms.service.UserService;
import com.hrms.service.impl.UserServiceImpl;
import com.hrms.util.ResultResponse;

@WebServlet("/regist")
public class Regist extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String passwd = req.getParameter("passwd");
		int deptId = Integer.parseInt(req.getParameter("dept"));
		String email = req.getParameter("email");
		String gender = req.getParameter("eGender");
		User user = new User();
		user.seteName(name);
		user.seteDepartment(deptId);
		user.setEmail(email);
		user.setPasswd(passwd);
		user.setPhone(phone);
		user.seteGender(gender);
		ResultResponse addUser = userService.addUser(user);
		if(addUser.getStatusCode() != "200") {
			req.getRequestDispatcher("regist.html").forward(req, resp);
			
		}else {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}

}
