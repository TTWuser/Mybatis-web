package com.hxf.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxf.pojo.Student;
import com.hxf.service.Student_Service_API;
import com.hxf.service.Student_Service_Impl;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqtype=request.getParameter("reqtype");
		Student_Service_API score=null;
		System.out.println(reqtype);
		response.setCharacterEncoding("utf-8");
		
		
		if(reqtype.equals("selectAllStudent")) {//查询所有用户
			score=new Student_Service_Impl();
			//JsonBuilder
			JsonBuilder jb=new JsonBuilder();
			String json="";
			try {
				json=jb.getJsontoAll(score.selectAllStudent());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(json);
			response.setContentType("application/json");
			PrintWriter writer=response.getWriter();
			writer.print(json);
			writer.close();
			score.closeSession();
			
		}else if(reqtype.equals("deleteStudentByID")) {//删除某用户
			score=new Student_Service_Impl();
			Integer userid=Integer.parseInt(request.getParameter("userid"));
			boolean deleteStats=false;
			try {
				deleteStats=score.deleteStudentByID(userid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置返回类型（mime）
			response.setContentType("text/plain");
			PrintWriter writer=response.getWriter();
			
			if(deleteStats) {
				writer.print("true");
			}else {
				writer.print("false");
			}
			writer.close();
			score.closeSession();
			
		}if(reqtype.equals("insertStudent")) {//增加用户
			score=new Student_Service_Impl();
			
			String userid=request.getParameter("userid");
			String username=request.getParameter("username");
			String userclass=request.getParameter("userclass");
			//String userscore=request.getParameter("userscore");
			String javascore=request.getParameter("javascore");
			String sqlscore=request.getParameter("sqlscore");
			String springscore=request.getParameter("springscore");
			
			if(userid==""||username==""||userclass=="") {
				//设置返回类型（mime）
				response.setContentType("text/plain");
				PrintWriter writer=response.getWriter();
				
				writer.print("false");
			
				writer.close();
				score.closeSession();
				return ;
			}
			if(javascore=="") {
				javascore="0";
			}
			if(sqlscore=="") {
				sqlscore="0";
			}
			if(springscore=="") {
				springscore="0";
			}
			Student user=new Student();
			user.setStudentid(Integer.parseInt(userid));
			user.setStudentname(username);
			user.setStudentclass(Integer.parseInt(userclass));
			user.setStudentscore(0);
			user.setJavascore(Integer.parseInt(javascore));
			user.setSpringscore(Integer.parseInt(springscore));
			user.setSqlscore(Integer.parseInt(sqlscore));
			System.out.println(user.toString());
			
			boolean insertStats=false;
			try {
				insertStats=score.insertStudent(user);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置返回类型（mime）
			response.setContentType("text/plain");
			PrintWriter writer=response.getWriter();
			
			if(insertStats) {
				writer.print("true");
			}else {
				writer.print("false");
			}
			writer.close();
			score.closeSession();
			
		}else if(reqtype.equals("updateStudent")) {//更新用户信息
			score=new Student_Service_Impl();//新建服务对象
			
			String userid=request.getParameter("userid");
			String username=request.getParameter("username");
			String userclass=request.getParameter("userclass");
			//String userscore=request.getParameter("userscore");
			String javascore=request.getParameter("javascore");
			String sqlscore=request.getParameter("sqlscore");
			String springscore=request.getParameter("springscore");
			
			if(userid==""||username==""||userclass=="") {
				//设置返回类型（mime）
				response.setContentType("text/plain");
				PrintWriter writer=response.getWriter();
				
				writer.print("false");
			
				writer.close();
				score.closeSession();
				return ;
			}
			if(javascore=="") {
				javascore="0";
			}
			if(sqlscore=="") {
				sqlscore="0";
			}
			if(springscore=="") {
				springscore="0";
			}
			Student user=new Student();
			user.setStudentid(Integer.parseInt(userid));
			user.setStudentname(username);
			user.setStudentclass(Integer.parseInt(userclass));
			user.setStudentscore(0);
			user.setJavascore(Integer.parseInt(javascore));
			user.setSpringscore(Integer.parseInt(springscore));
			user.setSqlscore(Integer.parseInt(sqlscore));
			System.out.println(user.toString());
			
			boolean updateStats=false;
			try {
				updateStats=score.updateStudent(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置返回类型（mime）
			response.setContentType("text/plain");
			PrintWriter writer=response.getWriter();
			
			if(updateStats) {
				writer.print("true");
			}else {
				writer.print("false");
			}
			writer.close();
			score.closeSession();
		}else if(reqtype.equals("selectAllbydesc")){
			String cloum=request.getParameter("cloum");
			
			score=new Student_Service_Impl();
			//JsonBuilder
			JsonBuilder jb=new JsonBuilder();
			String json="";
			try {
				json=jb.getJsontoAll(score.selectAllbydesc(cloum));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(json);
			response.setContentType("application/json");
			PrintWriter writer=response.getWriter();
			writer.print(json);
			writer.close();
			score.closeSession();
		}else if(reqtype.equals("selectAllbyasc")){
			String cloum=request.getParameter("cloum");
			
			score=new Student_Service_Impl();
			//JsonBuilder
			JsonBuilder jb=new JsonBuilder();
			String json="";
			try {
				json=jb.getJsontoAll(score.selectAllbyasc(cloum));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(json);
			response.setContentType("application/json");
			PrintWriter writer=response.getWriter();
			writer.print(json);
			writer.close();
			score.closeSession();
		}else if(reqtype.equals("selectStudentPage")){
			Integer startpage=Integer.parseInt(request.getParameter("startpage"));
			Integer studentnum=Integer.parseInt(request.getParameter("studentnum"));
			
			score=new Student_Service_Impl();
			//JsonBuilder
			JsonBuilder jb=new JsonBuilder();
			String json="";
			try {
				json=jb.getJsontoAll(score.selectStudentPage(startpage,studentnum));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(json);
			response.setContentType("application/json");
			PrintWriter writer=response.getWriter();
			writer.print(json);
			writer.close();
			score.closeSession();
		}else if(reqtype.equals("selectAllLikeName")){
			System.out.println("selectAllLikeName::"+request.getParameter("username"));
			String username=request.getParameter("username");
			score=new Student_Service_Impl();
			//JsonBuilder
			JsonBuilder jb=new JsonBuilder();
			String json="";
			try {
				json=jb.getJsontoAll(score.selectAllLikeName(username));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(json);
			response.setContentType("application/json");
			PrintWriter writer=response.getWriter();
			writer.print(json);
			writer.close();
			score.closeSession();
		}else {
			
		}
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

}
