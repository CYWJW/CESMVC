package com.rl.ces.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rl.ces.bean.CSUser;
import com.rl.ces.dao.impl.CSUserDaoImpl;
import com.rl.ces.service.CSUserService;
import com.rl.ces.service.impl.CSUserServiceImpl;

public class DeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 CSUserService service=	new CSUserServiceImpl();
		 String userIdstr= request.getParameter("userId");
		  //System.out.print(userIdstr);
		  Integer userId=new Integer(userIdstr);
		  service.deleteUser(userId);
		  String path=request.getContextPath();
		  response.sendRedirect(path+"/QueryServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
