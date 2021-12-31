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

@WebServlet("/user/update")
public class UpdateUser extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		// 'uId': uId, 'uName': uName, 'eGender': eGender, 'phone': phone, 'passwd': passwd,
//        'eJob': eJob, 'lead': lead
		
		System.out.println(req.getParameter("eId"));
		user.seteId(Integer.parseInt(req.getParameter("eId")) ); 
		user.seteName(req.getParameter("eName"));
		user.seteGender(req.getParameter("eGender"));
		user.setPhone(req.getParameter("phone"));
		user.setPasswd(req.getParameter("passwd"));
		user.seteJob(req.getParameter("eJob"));
		user.setEmail(req.getParameter("email"));
		user.setLead(Integer.parseInt( req.getParameter("lead")));
		ResultResponse addUser = userService.updateUserInfo(user);
		resp.getWriter().write(JSON.toJSONString(addUser));
	
	}

}
