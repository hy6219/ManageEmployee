package com.js.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.js.dto.MyEmpDto;

public class MyEmpDao {
	private MyEmpDao() {
		
	}
	
	private static MyEmpDao dao = new MyEmpDao();
	
	
	public static MyEmpDao getInstance(){
		return dao;
	}
	
	//connection from database connection pool
	public Connection getConnection() throws Exception {
		Connection conn      = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource    ds    = (DataSource)envContext.lookup("jdbc/myoracle");
		conn                = ds.getConnection();
		
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	//회원 정보 조회
	public MyEmpDto searchUser(String userId,String pwd, String lev) {
		Connection conn      = null;
		PreparedStatement ps = null;
		ResultSet   rs       = null;
		MyEmpDto dto        = new MyEmpDto();
		String  searchQuery= "SELECT USERID, PWD, NAME, LEV, REGDATE, GENDER, PHONE FROM MYEMP WHERE USERID=? AND PWD=? AND LEV=?";
	//	System.out.println("query: "+searchQuery+", userId: "+userId);
		
		try {
			conn  = getConnection();
			ps    = conn.prepareStatement(searchQuery);
			
			ps.setString(1, userId);
			ps.setString(2, pwd);
			ps.setString(3, lev);
			rs    = ps.executeQuery();
			while(rs.next()) {
				dto.setUserId(rs.getString(1));
				dto.setPwd(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setLev(rs.getString(4));
				dto.setRegDate(rs.getDate(5));
				dto.setGender(rs.getString(6));
				dto.setPhone(rs.getString(7));
			}
		}catch(Exception e1) {
			System.out.println("[ERR]SEARCH USER FAILED!");
			e1.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e2) {
				System.out.println("[ERR]CLOSE AFTER SEARCH USER ERROR!");
				e2.printStackTrace();
			}
			
		}
		
		System.out.println(dto.toString());
		return dto;
	}
	
	public int insertEmp(MyEmpDto newEmp) {
		
		int resIns  	   = 0 ;
		String insertQuery = "INSERT INTO MYEMP VALUES(?,?,?,?,SYSDATE,?,?)";
		Connection conn    = null;
		PreparedStatement ps =  null;
		String     name    = newEmp.getName();
		
		
		System.out.println("newEmp: "+newEmp.toString());
//		String     phone   = ;
//		
//		if(phone.equals("")) {
//			phone="-";
//		}
		try {
			conn = getConnection();
			
			ps   = conn.prepareStatement(insertQuery);
			
			ps.setString(1, newEmp.getUserId());
			ps.setString(2, newEmp.getPwd());
			ps.setString(3, name);
			ps.setString(4, newEmp.getLev());
			ps.setString(5, newEmp.getGender());
			ps.setString(6, newEmp.getPhone());
			
			resIns  =ps.executeUpdate();
			
			if(resIns > 0) {
				System.out.println("사원등록 성공");
				conn.commit();
			}else {
				System.out.println("사원등록 실패");
				conn.rollback();
			}
			
		}catch(Exception e1) {
			System.out.println("[ERR]사원 등록 실패");
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e2) {
				System.out.println("[ERR]CLOSE AT INSERTING FAILED");
				e2.printStackTrace();
			}
		}
		
		return resIns;
	}
	
	public int updateMember(MyEmpDto dto) {
		Connection 		  conn 	 = null;
		PreparedStatement ps     = null;
		int              upRes   = 0;
		
		String     updateQuery   = "UPDATE MYEMP SET PWD=?, NAME=?, LEV=?, GENDER=?, PHONE=? WHERE USERID=?";
		
		try {
			
			conn = getConnection();
			ps   = conn.prepareStatement(updateQuery);
			
			ps.setString(1, dto.getPwd());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getLev());
			ps.setString(4, dto.getGender());
			ps.setString(5,dto.getPhone());
			ps.setString(6, dto.getUserId());
			
			upRes = ps.executeUpdate();
			
			if(upRes > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		}catch(Exception e1){
			System.out.println("[ERR]UPDATE MEMBER FAILED");
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e2) {
				System.out.println("[ERR] CLOSE ERROR DURING UPDATING");
				e2.printStackTrace();
			}
		}
		return upRes;
	}
}
