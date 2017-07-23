package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.m3result.M3Result;
import com.book.service.CartService;


public class CartDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	M3Result m3result=new M3Result();
	CartService cs=new CartService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int user_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if(request.getParameter("product_ids")==null){
			m3result.setStatus(1);
			m3result.setMessage("书籍ID为空");
			

	        out.println(m3result.setM3Result().toString());
	        out.flush();
	        out.close();
			return ;
			
		}
		String product_ids=request.getParameter("product_ids");
		cs.delete(user_id, product_ids);
		
		
		String[] abc=product_ids.split(",");
		
		
		
		for(String x:abc){
			
			System.out.println("shuchu"+x);
			
		}
		
		
		m3result.setStatus(0);
		m3result.setMessage("删除成功");
		

        out.println(m3result.setM3Result().toString());
        out.flush();
        out.close();		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
