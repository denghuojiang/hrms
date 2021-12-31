package com.hrms.leave.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.entity.Leave;
import com.hrms.service.LeaveService;
import com.hrms.service.UserService;
import com.hrms.service.impl.LeaveServiceImpl;
import com.hrms.service.impl.UserServiceImpl;
import com.hrms.util.MailUtils;
import com.hrms.util.ResultResponse;

@WebServlet("/leave/reply")
public class ReplyLeave extends HttpServlet{

	
	private LeaveService lService = new LeaveServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int lId = Integer.parseInt(req.getParameter("lId")); 
		int eId = Integer.parseInt(req.getParameter("eId")); 
		int state = Integer.parseInt(req.getParameter("state")); 
		String reply = req.getParameter("reply");
		Leave leave = new Leave();
		leave.setState(state);
		leave.setlId(lId);
		leave.setReply(reply);
		leave.seteId(eId);
		ResultResponse resultResponse = lService.replyLeave(leave);
		// 发送邮件
		
		resp.getWriter().write(JSON.toJSONString(resultResponse));
	
	}
	
	
	
}
