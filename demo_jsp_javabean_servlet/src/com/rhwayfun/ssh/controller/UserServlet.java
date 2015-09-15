package com.rhwayfun.ssh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rhwayfun.ssh.bean.UserBean;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		//获取客户端传递的处理请求
		String action = request.getParameter("action");
		//根据action的不同选择不同的操作
		if(action == null){
			PrintWriter out = response.getWriter();
			out.print("非法的请求");
		}else if(action.equals("login")){
			login(request,response);
		}else if(action.equals("register")){
			register(request,response);
		}else if(action.equals("logout")){
			logout(request,response);
		}
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("login.jsp");
	}

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取注册信息
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
		String email = request.getParameter("email");
		
		UserBean userBean = new UserBean();
		boolean isExist = userBean.isExist(username);
		if(!isExist){
			userBean.register(username, password, email);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else{
			response.sendRedirect("register.jsp");
			return;
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取用户名和密码
		String usr = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		//判断有效性
		UserBean userBean = new UserBean();
		boolean isValid = userBean.valid(usr, pwd);
		if(isValid){
			//获取会话对象
			HttpSession session = request.getSession();
			session.setAttribute("username", usr);
			response.sendRedirect("welcome.jsp");
			return;
		}else{
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
