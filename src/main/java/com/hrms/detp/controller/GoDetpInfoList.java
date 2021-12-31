package com.hrms.detp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import com.hrms.entity.Dept;
import com.hrms.service.DeptService;
import com.hrms.service.impl.DeptServiceImpl;
import com.hrms.util.ThUtil;

@WebServlet("/goDeptInfo")
public class GoDetpInfoList extends HttpServlet {

	
	private DeptService deptService = new DeptServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Dept> list =  deptService.getAllDeptList();
		Context context = new Context();
		context.setVariable("list", list);
		ThUtil.write("deptList.html", context, resp);
		
	}
	
}
