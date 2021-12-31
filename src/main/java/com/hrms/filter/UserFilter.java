package com.hrms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hrms.entity.User;

/**
 * Servlet Filter implementation class UserFilter
 */
public class UserFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute("user");
		String url = ((HttpServletRequest) request).getRequestURI().toString();
		if (url.endsWith("login.html") || user != null || url.endsWith(".css")

				|| url.endsWith(".js") || url.endsWith(".gif")

				|| url.endsWith(".png") || url.endsWith(".jpg")
				
				|| url.endsWith(".do") || url.endsWith("regist.html")
				|| url.endsWith("regist")) {
			

			
			chain.doFilter(request, response);

		} else {
			System.out.println("非法登录");
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
