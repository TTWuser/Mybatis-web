package com.hxf.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hxf.pojo.Pojo;
import com.hxf.pojo.Student;

public class Student_Service_Impl implements Student_Service_API {
	private SqlSessionFactory factory=null;
	private SqlSession session=null;
	private String sourcefile="mybatis-config.xml";//主配置文件
	
	public Student_Service_Impl() {
		try {
			//1.获取Mybatis的数据库配置文件
			InputStream is = Resources.getResourceAsStream(sourcefile);
			//2.通过文件流,创建一个sqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(is);
			//3.通过工厂创建一个数据库的连接session
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//关闭session
	public void closeSession() {
		if(session!=null) {
			session.close();
		}
	}
	
	@Override//插入用户信息
	public boolean insertStudent(Student student) throws Exception {
		if(session.insert("com.hxf.Mapper.Student.insertStudent", student)==0) {
			return false;
		}
		session.commit();
		return true;
	}
	@Override//插入用户并返回用户ID，在我这里没用
	public void insertStudentCatchID(Student student) {
		// TODO Auto-generated method stub
		
	}
	
	@Override//查询全部用户信息
	public List<Student> selectAllStudent() throws Exception {
		List<Student> list = session.selectList("com.hxf.Mapper.Student.selectAllStudent");
		return list;
	}
	@Override
	public boolean deleteStudentByID(Integer studentid) throws Exception {
		if(session.delete("com.hxf.Mapper.Student.deleteStudentByID",studentid)==0) {
			return false;
		}
		session.commit();
		return true;//删除成功
	}
	@Override//统计人数
	public Integer countStudent() throws Exception {
		//int aa= session.selectOne("com.hxf.Mapper.Student.countStudent");
		if(session!=null) {
		return session.selectOne("com.hxf.Mapper.Student.countStudent");
		}
		return 0;
	}
	@Override
	public boolean updateStudent(Student student) throws Exception {
		if(session.insert("com.hxf.Mapper.Student.updateStudent", student)==0) {
			return false;
		}
		session.commit();
		return true;
	}
	@Override//平均分
	public Integer avgStudentScore() throws Exception {
		
		return session.selectOne("com.hxf.Mapper.Student.avgStudentScore");
	}
	@Override//降序查询
	public List<Student> selectAllbydesc(String cloum) throws Exception {
		System.out.println(cloum);
		List<Student> list = session.selectList("com.hxf.Mapper.Student.selectAllbydesc",cloum);
		
		return list;
	}
	@Override//升序查询
	public List<Student> selectAllbyasc(String cloum) throws Exception {
		List<Student> list = session.selectList("com.hxf.Mapper.Student.selectAllbyasc",cloum);
		
		return list;
	}
	@Override//统计总分数？？？沙雕功能
	public Integer countStudentScore() throws Exception {
		
		return 0;
	}
	
	@Override//按ID查询用户的所有信息
	public List<Student> selectAllByID(Integer studentid) throws Exception {
		List<Student> list=null;
		if(session!=null) {
			list = session.selectList("com.hxf.Mapper.Student.selectAllByID",studentid);
		}
		return list;
	}
	@Override//条件查询用户  自定义条件
	public Map<Integer, Student> selectAllStudentMap(HttpServletRequest request) throws Exception {
		
		
		
		return null;
	}
	@Override//分页查询信息
	public List<Student> selectStudentPage(Integer startpage,Integer studentnum) {
		List<Student> list=null;
		Map<String,Integer> map=new HashMap<>();
		map.put("startpage", startpage);
		map.put("studentnum", studentnum);
		if(session!=null) {
			list = session.selectList("com.hxf.Mapper.Student.selectStudentPage",map);
		}
		
		return list;
	}
	@Override//模糊查询  以用户名为基础
	public List<Student> selectAllLikeName(String studentname) throws Exception {
		List<Student> list=null;
		if(session!=null) {
			list = session.selectList("com.hxf.Mapper.Student.selectAllLikeName",studentname);
		}
		return list;
	}
	@Override//聚合查询 ，avg，count，desc,asc,max,min等
	public Map<String,Object> selectAllbyRule(Map<String,Object> rulemap) throws Exception {
		String rule=(String) rulemap.get("rule");
		String sql="";
		Map<String,Object> map=new HashMap<>();
		/**
		 * map的定义：
		 * 1.rulenum::聚合查询中规则的数量
		 * 2.order::聚合查询中采用升序或者降序
		 * 3.rule+i:: 聚合查询中的规则名(列名或者其他)
		 * 4.rule::规则名
		 */
		
		if(rule.equals("avg")) {
			int rulenum=(Integer)rulemap.get("rulenum");//规则数量
			String order=(String) rulemap.get("order");//升序或者降序
			for(int i=1;i<=rulenum;i++) {//构建规则
				String ru="rule"+i;
				sql="select * from studentscore4081 order by "+rulemap.get(ru)+" "+order;
				map.put(ru,session.selectOne("com.hxf.Mapper.Student.selectAllbyRule",sql));
			}
			return map;
			
		}else if(rule.equals("count")) {
			int rulenum=(Integer)rulemap.get("rulenum");
			String order=(String) rulemap.get("order");
			for(int i=1;i<=rulenum;i++) {//构建规则
				String ru="rule"+i;
				sql="select * from studentscore4081 order by "+rulemap.get(ru)+" "+order;
				map.put(ru,session.selectOne("com.hxf.Mapper.Student.selectAllbyRule",sql));
			}
			return map;
		}else if(rule.equals("max")) {
			int rulenum=(Integer)rulemap.get("rulenum");
			//String order=rulemap.get("order");
			for(int i=1;i<=rulenum;i++) {//构建规则
				String ru="rule"+i;
				sql="select max("+rulemap.get(ru)+") from studentscore4081";
				map.put(ru,(Integer)session.selectOne("com.hxf.Mapper.Student.selectAllbyRule",sql));
			}
			return map;
		}else if(rule.equals("min")) {
			int rulenum=(Integer)rulemap.get("rulenum");
			//String order=rulemap.get("order");
			for(int i=1;i<=rulenum;i++) {//构建规则
				String ru="rule"+i;
				sql="select min("+rulemap.get(ru)+") from studentscore4081";
				map.put(ru,session.selectOne("com.hxf.Mapper.Student.selectAllbyRule",sql));
				System.out.println((Integer)session.selectOne("com.hxf.Mapper.Student.selectAllbyRule",sql));
			}
			return map;
		}
		
		
		
		return null;
	}
	@Override
	public void getSidandInfo() {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public List<Pojo> getsee() {
		// TODO Auto-generated method stub
		List<Pojo> list=session.selectList("com.hxf.Mapper.Student.see");
		
		return list;
	}
	
	
}
