package com.hrms.detp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.service.DeptService;
import com.hrms.service.impl.DeptServiceImpl;
import com.hrms.util.ResultResponse;

@WebServlet("/dept/del")
public class DeleteDeptInfo extends HttpServlet {

	
	private DeptService deptService = new DeptServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
		 ResultResponse result  = deptService.delDept(id);
		System.out.println(JSON.toJSON(result));
		resp.getWriter().write(JSON.toJSONString(result));
		
		
	}

	
	
}
