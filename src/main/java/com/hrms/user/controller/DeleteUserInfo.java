package com.hrms.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.service.UserService;
import com.hrms.service.impl.UserServiceImpl;
import com.hrms.util.ResultResponse;

@WebServlet("/user/del")
public class DeleteUserInfo extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ResultResponse result = userService.deleteUserInfo(Integer.parseInt(id));
		resp.getWriter().write(JSON.toJSONString(result));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
