package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.AdminUser;

/**
 * 自定义过滤器
 */
@WebFilter("/MyFilter")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpSession session=((HttpServletRequest)request).getSession();
			AdminUser user=(AdminUser) session.getAttribute("user");
			// 登录页面访问的时候
			String url = ((HttpServletRequest)request).getRequestURI();
			if(url.endsWith("login.jsp")||url.endsWith("loginServlet.do")||url.endsWith("register.jsp")||url.endsWith("registerServlet.do")){
				chain.doFilter(request, response);
				return;
			}
			if(user!=null){
				chain.doFilter(request, response);
			}else {
				((HttpServletResponse)response).sendRedirect("login.jsp");
			}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
