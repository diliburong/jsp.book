package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.ProductService;

/**
 * Servlet implementation class GetPdtContentServlet
 */

public class GetPdtContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps=new ProductService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPdtContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		
		request.setAttribute("pdt_images", ps.getPdtImages(product_id));
		request.setAttribute("pdt_content",ps.getPdtContent(product_id));  
		request.setAttribute("product",ps.getProductById(product_id));
        request.getRequestDispatcher("pdt_content.jsp").forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
