package com.book.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class IsLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IsLoginFilter() {

    }
    
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		String servletPath=req.getServletPath();
		HttpSession session=req.getSession();
		

		
		if(session.getAttribute("flag")==null){
			System.out.println("session is null");
		}
		
		
		String flag=(String)session.getAttribute("flag");
		
		
		if(servletPath!=null 
				&&(servletPath.equals("/login.jsp"))
				||(servletPath.equals("/LoginServlet"))
				||(servletPath.equals("/error.jsp"))
				||(servletPath.equals("/register.jsp"))
				||(servletPath.contains(".js"))
				||(servletPath.contains(".css"))
				){
			chain.doFilter(request, response);
			
		}else{
			if(flag!=null){
				
				chain.doFilter(request, response);
			}else{
				
				RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
				rd.forward(req, response);
				
			}
				
			
			
		}
		
		
		
		
		
	}



}
