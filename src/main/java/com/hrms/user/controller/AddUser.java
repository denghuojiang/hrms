package com.hrms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.entity.User;
import com.hrms.service.UserService;
import com.hrms.service.impl.UserServiceImpl;
import com.hrms.util.ResultResponse;

import javassist.expr.NewArray;

@WebServlet("/user/add")
public class AddUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.seteName(req.getParameter("eName"));
		user.seteGender(req.getParameter("eGender"));
		user.seteDepartment(Integer.parseInt(req.getParameter("eDepartment")) );
		user.setPhone(req.getParameter("phone"));
		user.setPasswd(req.getParameter("passwd"));
		user.seteJob(req.getParameter("eJob"));
		user.setEmail(req.getParameter("email"));
		user.setLead(Integer.parseInt( req.getParameter("lead")));
		userService.addUser(user);
		ResultResponse rr = new ResultResponse();
		rr.setStatusCode("200");
		resp.getWriter().write(JSON.toJSONString(rr));
		
	}

}
