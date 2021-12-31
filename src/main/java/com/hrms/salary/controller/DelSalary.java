package com.hrms.salary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.service.SalaryService;
import com.hrms.service.impl.SalaryServiceImpl;
import com.hrms.util.ResultResponse;

@WebServlet("/salary/del")
public class DelSalary extends HttpServlet{
	private SalaryService  sService = new SalaryServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("eId");
		String[] date = req.getParameter("sMonth").split("T");
		ResultResponse resultResponse = sService.delSalary(Integer.parseInt(id), date[0]);
		
		resp.getWriter().write(JSON.toJSONString(resultResponse));
		
	}
	
	
}
