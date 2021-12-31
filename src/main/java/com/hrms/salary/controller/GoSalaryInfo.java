package com.hrms.salary.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.hrms.entity.Salary;
import com.hrms.service.SalaryService;
import com.hrms.service.impl.SalaryServiceImpl;
import com.hrms.util.ThUtil;


@WebServlet("/goSalaryInfo")
public class GoSalaryInfo extends HttpServlet {

	
	private SalaryService  sService = new SalaryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Salary> list = sService.getAllList();
		Context context = new Context();
		context.setVariable("list", list);
		ThUtil.write("salaryList.html", context, resp);
		
	
	}
	
	
}
