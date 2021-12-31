package com.hrms.salary.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.service.SalaryService;
import com.hrms.service.impl.SalaryServiceImpl;

@WebServlet("/salary/add")
public class AddSalary extends HttpServlet {

	
	private SalaryService  sService = new SalaryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	
			String id = req.getParameter("eId");
			String amount = req.getParameter("amount");
			
			sService.SaveSalary(Integer.parseInt(id),new BigDecimal(amount));
			  // 要重定向的新位置
		      String site = new String("/hrms/goSalaryInfo");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);    
	}
	
}
