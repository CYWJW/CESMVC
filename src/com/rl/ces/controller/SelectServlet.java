package com.rl.ces.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rl.ces.bean.CSUser;
import com.rl.ces.service.CSUserService;
import com.rl.ces.service.impl.CSUserServiceImpl;

public class SelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CSUserService service =new CSUserServiceImpl();
		String userIdstr = request.getParameter("userId");
		Integer userId = new Integer(userIdstr);
		//调用查询页面
		CSUser user = service.getUserId(userId);
		request.setAttribute("user", user);
		request.setAttribute("userId", userId);
		//返回查询页面
		request.getRequestDispatcher("/tab/toUpdate.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
