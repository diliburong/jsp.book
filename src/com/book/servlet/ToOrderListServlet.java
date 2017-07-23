package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.OrderService;



public class ToOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os=new OrderService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int user_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		
		
		
		
		request.setAttribute("orders", os.getOrderList(user_id));
        request.getRequestDispatcher("order_list.jsp").forward(request, response);  
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
