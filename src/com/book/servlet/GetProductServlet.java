package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.ProductService;

/**
 * Servlet implementation class GetProductServlet
 */

public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ProductService ps=new ProductService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int category_id=Integer.parseInt(request.getParameter("category_id"));
		
		
		
		
		
		request.setAttribute("products", ps.getProductByCategoryId(category_id));  
        request.getRequestDispatcher("product.jsp").forward(request, response);  
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
