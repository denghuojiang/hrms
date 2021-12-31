package com.hrms.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@WebServlet("/temp")
public class Temp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建模板引擎对象
				TemplateEngine te = new TemplateEngine();
				// 创建配置对象
				ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
				// 设置字符集
				r.setCharacterEncoding("UTF-8");
				// 将引擎和配置对象关联
				te.setTemplateResolver(r);
				// 创建上下文对象 用于装载数据的容器
				Context context = new Context();
				context.setVariable("name", "灯火酱");
				// 把容器里面的数据替换到模板页面中
				String html = te.process("mian.html", context);
				
				// 响应
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.print(html);
				pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
	
}
