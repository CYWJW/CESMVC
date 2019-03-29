package com.rl.ces.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rl.ces.bean.CSUser;
import com.rl.ces.service.CSUserService;
import com.rl.ces.service.impl.CSUserServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String password=request.getParameter("password");
		String path=request.getContextPath();
		CSUserService service = new CSUserServiceImpl();
		CSUser user=service.loginByNamePassword(name, password);
		if(user!=null)
		{
		HttpSession session=	request.getSession();
		session.setAttribute("user", user);
		response.sendRedirect(path+"/ecs/main.html");
		}
		else {
			response.getWriter().write("密码错误  3秒后跳到登陆页面");
			response.setHeader("refresh", "3;url="+path+"/login.jsp");
		}
	}

}
