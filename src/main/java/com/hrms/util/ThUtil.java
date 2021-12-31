package com.hrms.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThUtil {
private static TemplateEngine te;
	
	static {
		// 创建模板引擎对象
		te = new TemplateEngine();
		// 创建配置对象
		ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
		// 设置字符集
		r.setCharacterEncoding("UTF-8");
		// 将引擎和配置对象关联
		te.setTemplateResolver(r);
	}
	
	public static void write(String fileName,Context context,HttpServletResponse resp) throws IOException {
		// 将容器里面的数据替换到模板页面中
		String html = te.process(fileName, context);
		// 响应
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(html);
		pw.close();
	}

}
