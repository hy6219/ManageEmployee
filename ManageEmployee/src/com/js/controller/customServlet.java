package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.MyEmpDao;
import com.js.dto.MyEmpDto;

/**
 * Servlet implementation class customServlet
 */
@WebServlet("/custom.do")
public class customServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./admin/custom.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pwd    = request.getParameter("pwd");
		String name   = request.getParameter("name");
		String lev    = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone  = request.getParameter("phone");
		
		MyEmpDto dto  = new MyEmpDto();
		MyEmpDao dao  = MyEmpDao.getInstance();
		int   resIns  = 0;//결과받아오기
		String   msg  = "";//msg 저장하기!
		String   url  = "";
		
		if(name.equals("")) {
			name="-";
		}
		
		if(phone.equals("")) {
			phone="-";
		}
		
		dto.setUserId(userId);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setLev(lev);
		dto.setGender(gender);
		dto.setPhone(phone);
		
		resIns        = dao.insertEmp(dto);
		System.out.println("newEmp: "+dto.toString() );
		if(resIns > 0) {
			msg = "회원 등록에 성공했습니다";
			url ="./admin/customRes.jsp";
			request.setAttribute("newEmp", dto);
		}else {
			msg = "회원 등록에 실패했습니다";
			url = "./admin/adminMain.jsp";
		}
		request.setAttribute("msg", msg);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);
	}

}
