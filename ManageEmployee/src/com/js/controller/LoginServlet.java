package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.js.dao.MyEmpDao;
import com.js.dto.MyEmpDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("./login.do");
		String url ="./login.jsp";
		HttpSession session=request.getSession();
		MyEmpDto dto = (MyEmpDto)session.getAttribute("loginUser");
		
		if(dto!=null) {
			url="./admin/adminMain.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userId = request.getParameter("userId");
		String pwd    = request.getParameter("pwd");
		String lev    = request.getParameter("level");
		
		MyEmpDao dao  =MyEmpDao.getInstance();
		MyEmpDto dto  =dao.searchUser(userId, pwd, lev);
		HttpSession session=request.getSession();
		String   url   ="";
		
		//url 노출 없이 메인 페이지로 이동하기
		session.setAttribute("loginUser",dto);
		
		if(lev.equals("A")) {
			url = "./admin/adminMain.jsp";
		}else {
			url = "./user/userMain.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
