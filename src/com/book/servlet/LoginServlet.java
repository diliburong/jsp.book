package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.entity.User;
import com.book.service.LoginService;

import com.book.m3result.*;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService ls = new LoginService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		M3Result m3Result = new M3Result();

		if (username == null || password == null) {

		} else {
			User user = new User();
			user.setName(username);
			user.setPassword(password);

			User ruser = ls.check(user);

			if (ruser != null) {
				m3Result.setStatus(0);
				m3Result.setMessage("登陆成功");

				// System.out.println(ruser.getId());

				HttpSession session = request.getSession(false);
				session.setAttribute("user", ruser);
				session.setAttribute("user_id", ruser.getId());
				session.setAttribute("flag", "success");

				// System.out.println(session.getAttribute("user"));
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(m3Result.setM3Result().toString());
				out.flush();
				out.close();

			} else {

				m3Result.setStatus(1);
				m3Result.setMessage("登陆失败");
				// System.out.println(m3Result.setM3Result());

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(m3Result.setM3Result());
				out.close();

				// request.setAttribute("msg", "用户名或者密码输入错误");
				// forward="/error.jsp";

			}

			// rd=request.getRequestDispatcher(forward);
			// rd.forward(request, response);

		}
	}

}
