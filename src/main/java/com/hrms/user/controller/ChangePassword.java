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

@WebServlet("/user/change")
public class ChangePassword extends HttpServlet {

	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("eId");
		int intId = Integer.parseInt(id);
		String passwd = req.getParameter("newPasswd");
		ResultResponse rr = userService.changePasswd(intId,passwd);
		resp.getWriter().write(JSON.toJSONString(rr));
		
	}

}
