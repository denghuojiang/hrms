package com.hrms.detp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hrms.entity.Dept;
import com.hrms.service.DeptService;
import com.hrms.service.impl.DeptServiceImpl;
import com.hrms.util.ResultResponse;

@WebServlet("/dept/update")
public class UpdateDeptInfo extends HttpServlet {

	private DeptService deptService = new DeptServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int ID = Integer.parseInt(req.getParameter("deptId"));
		String deptName = req.getParameter("deptName");
		int status = Integer.parseInt(req.getParameter("status"));
		int pDept = Integer.parseInt(req.getParameter("pDept"));
		String deptLocal = req.getParameter("deptLocal");
		Dept dept = new Dept();
		dept.setDeptId(ID);
		dept.setDeptName(deptName);
		dept.setStatus(status);
		dept.setpDept(pDept);
		dept.setDeptLocal(deptLocal);
		ResultResponse updaetDept = deptService.updateUserInfo(dept );
		resp.getWriter().write(JSON.toJSONString(updaetDept));

	}

}
