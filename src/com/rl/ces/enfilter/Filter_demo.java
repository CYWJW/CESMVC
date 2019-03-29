package com.rl.ces.enfilter;

import java.io.IOException;

import javax.ejb.Init;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class Filter_demo implements Filter {
	private String encode;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		response.setContentType("text/html;charset="+encode);
		
		HttpServletRequest req=(HttpServletRequest)request;
		String method= req.getMethod();
		if(method.equalsIgnoreCase("get"))
		{
			req=new MyHttpServletRequsetWrapper(req, encode);
		}
		chain.doFilter(req, response);
		req.getParameter("user");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String	Iniencode=config.getInitParameter("encode").trim();
		if(Iniencode!=null&&!"".equals(encode))
		{
			encode=Iniencode;
		}
	}

}
