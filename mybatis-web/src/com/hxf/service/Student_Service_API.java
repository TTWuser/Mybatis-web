package com.hxf.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hxf.pojo.Pojo;
import com.hxf.pojo.Student;

public interface Student_Service_API {
	//插入用户
	public boolean insertStudent(Student student) throws Exception;
	public void insertStudentCatchID(Student student) throws Exception;//返回用户的主键
	
	//删除用户
	public boolean deleteStudentByID(Integer Studentid) throws Exception;
	
	//统计人数
	public Integer countStudent() throws Exception;
	//统计分数
	public Integer countStudentScore() throws Exception;
	//平均分数
	public Integer avgStudentScore() throws Exception;
	
	//更新信息
	public boolean updateStudent(Student student) throws Exception;
	
	
	//查询所有用户
	public List<Student> selectAllStudent() throws Exception;
	//查询所有用户--模糊查询
	public List<Student> selectAllLikeName(String studentname) throws Exception;
	//按ID查询用户
	public List<Student> selectAllByID(Integer studentid) throws Exception;
	
	//查询用户时筛选用户<多条件查询，用map存放规则>
	public Map<Integer,Student> selectAllStudentMap(HttpServletRequest request) throws Exception;
	//聚合查询 ，avg，count，desc,asc等
	public Map<String,Object> selectAllbyRule(Map<String,Object> map) throws Exception;
	
		//按条件查询所有用户
	public List<Student> selectAllbydesc(String cloum) throws Exception;
		//按条件查询所有用户
	public List<Student> selectAllbyasc(String cloum) throws Exception;
	
	
	//分页查询
	public List<Student> selectStudentPage(Integer startpage,Integer studentnum);
	
	//关闭session
	public void closeSession();
	
	//多表查询
	public void getSidandInfo(); 

	
	public List<Pojo> getsee(); 
	
	//
}
