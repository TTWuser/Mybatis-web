package com.hxf.service.encode;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Requestencoding extends HttpServletRequestWrapper{

	private String encode="";
	
	public Requestencoding(HttpServletRequest request) {
		super(request);
	}
	
	public Requestencoding(HttpServletRequest request,String encode) {
		super(request);
		this.encode=encode;
	}

	public String gerParameter(String name) {
		String value=getRequest().getParameter(name);
		try {
			if(value!=null&&!"".equals(value)) {
				value=new String(value.trim().getBytes("ISO-8859-1"),encode);
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return value;
	}
}
