package com.hxf.service.encode;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebFilter(
		description="encode-and-isuser",
		urlPatterns="/*",
		filterName="test-1",
		initParams= {
				@WebInitParam(name="encode",value="utf-8")
		}
		)
public class Encodeing implements Filter {

    private String encode="";
    public Encodeing() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//ֻ�������
		System.out.println("encode running");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		if("GET".equals(request.getMethod())) {
			request=new Requestencoding(request,encode);//����
		}else {
			request.setCharacterEncoding("utf-8");
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fig) throws ServletException {
		System.out.println("encode is running");
		encode=fig.getInitParameter("encode");//��ʼ��
	}

}
