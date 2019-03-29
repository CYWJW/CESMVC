package com.rl.ces.enfilter;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequsetWrapper extends HttpServletRequestWrapper {
	private String encode;
	public MyHttpServletRequsetWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public MyHttpServletRequsetWrapper(HttpServletRequest request,String encode)
	{
		super(request);
		this.encode=encode.trim();
	}
	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String value= super.getParameter(name);
		try {
			value=(value==null)?null:new String(value.getBytes("ISO-8859-1"),this.encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
		
	}

}
