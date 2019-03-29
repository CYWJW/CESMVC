package com.rl.ces.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rl.ces.bean.CSUser;
import com.rl.ces.service.impl.CSUserServiceImpl;

public class QueryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=	request.getSession();
		String path=request.getContextPath();
		if(session.getAttribute("user")==null)
		{
			response.getWriter().write("禁止非法登陆");
			response.setHeader("refresh", "3;url="+path+"/login.jsp");
		}
		else {
			List<CSUser> list=new LinkedList<CSUser>();
			list=new CSUserServiceImpl().listUser();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/tab/tab.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
