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
 * Servlet implementation class myPageServlet
 */
@WebServlet("/myPage.do")
public class myPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String lev = request.getParameter("lev");
//		
//		request.setAttribute("lev", lev);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("myPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pwd    = request.getParameter("pwd");
		String name   = request.getParameter("name");
		String lev    = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone  = request.getParameter("phone");
		
		MyEmpDto dto  = new MyEmpDto();
		MyEmpDao dao   =MyEmpDao.getInstance();
		int    upRes  = 0;
		String msg    ="";
		
		dto.setUserId(userId);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setLev(lev);
		dto.setGender(gender);
		dto.setPhone(phone);
		
		upRes        = dao.updateMember(dto);
		
		MyEmpDto    update = dao.searchUser(userId, pwd, lev);
		HttpSession session = request.getSession();
		if(upRes > 0) {
			msg      = "회원 정보가 수정되었습니다";
		}else {
			msg      = "회원 정보 수정에 실패했습니다";
		}
		
		request.setAttribute("msg", msg);
		session.setAttribute("loginUser",update);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateInfo.jsp");
		dispatcher.forward(request, response);
	}

}
