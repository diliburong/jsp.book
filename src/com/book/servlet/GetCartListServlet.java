package com.book.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.CartService;


public class GetCartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cs=new CartService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getSession().getAttribute("user_id")==null){
		
			RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			
			return;
		}
			
		
		//System.out.println(request.getSession().getAttribute("user_id"));
		int user_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		//System.out.println(cs.getCartList(Integer.parseInt(request.getSession().getAttribute("user_id").toString())));
		//System.out.println(user_id);
		//cs.getCartList(user_id);
		request.setAttribute("cart_items", cs.getCartList(user_id));  
        request.getRequestDispatcher("cart.jsp").forward(request, response);  
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
	}

}
