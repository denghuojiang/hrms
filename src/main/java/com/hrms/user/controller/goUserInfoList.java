package com.hrms.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.hrms.entity.User;
import com.hrms.service.UserService;
import com.hrms.service.impl.UserServiceImpl;
import com.hrms.util.ThUtil;

@WebServlet("/goUserInfo")
public class goUserInfoList  extends HttpServlet{
	
	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> listAll = userService.listAll();
		Context context = new Context();
		context.setVariable("list", listAll);
		ThUtil.write("userList.html", context, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
