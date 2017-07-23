package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.OrderService;


public class ToOrderCommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os=new OrderService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToOrderCommitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int user_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		String product_ids=request.getParameter("product_ids");
		
		os.getTotalPriceAndCartItem(user_id, product_ids);
		os.commitOrder(user_id);
		
		request.setAttribute("total_price", os.getTotal_price());
		request.setAttribute("cart_items", os.getCart_items_arr());
        request.getRequestDispatcher("order_commit.jsp").forward(request, response);  
		
		
		
		
		
		
	}

}
