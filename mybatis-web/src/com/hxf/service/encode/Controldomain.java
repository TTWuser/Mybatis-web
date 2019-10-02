package com.hxf.service.encode;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Controldomain
 */
@WebFilter("/*")
public class Controldomain implements Filter {

    /**
     * Default constructor. 
     */
    public Controldomain() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;  
		// 指定允许其他域名访问 
		response.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有
		// response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1, http://locahost"); // 允许白名单IP
		// 响应类型
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
		// 预检请求的结果缓存60分钟
		response.setHeader("Access-Control-Max-Age", "3600");  
		// 响应头设置 
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
