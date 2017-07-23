package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.m3result.M3Result;
import com.book.service.CartService;


public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cs=new CartService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		M3Result m3Result=new M3Result();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if (request.getSession().getAttribute("user_id") == null) {
			System.out.print("abc");

			m3Result.setStatus(1);
			m3Result.setMessage("session错误");

			out.println(m3Result.setM3Result());
			out.flush();
			out.close();

		} else if (request.getParameter("product_id") == null) {

			m3Result.setStatus(2);
			m3Result.setMessage("产品Id不能为空");

			out.println(m3Result.setM3Result());
			out.flush();
			out.close();

		}

		else {

			int product_id = Integer.parseInt(request.getParameter("product_id"));
			int user_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
			System.out.println(product_id);
			System.out.println(request.getSession().getAttribute("user_id"));

			cs.addCart(user_id, product_id);
			
			m3Result.setStatus(0);
			m3Result.setMessage("添加成功");

			out.println(m3Result.setM3Result());
			out.flush();
			out.close();

		}

		//System.out.println(request.getSession().getAttribute("user"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
