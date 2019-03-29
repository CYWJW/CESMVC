package com.rl.ces.enfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rl.ces.bean.CSUser;

public class LogFliter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)srequest;
			HttpSession session=	request.getSession();
			CSUser user=(CSUser)session.getAttribute("user");
			if(user==null)
			{
				HttpServletResponse res=(HttpServletResponse)response;
				String path=request.getContextPath();
				res.sendRedirect(path+"/login.jsp");
			}
			else {
				chain.doFilter(request, response);
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
