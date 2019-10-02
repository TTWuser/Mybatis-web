package com.hxf.test;

import java.util.HashMap;
import java.util.Map;

import com.hxf.pojo.Student;
import com.hxf.service.Student_Service_API;
import com.hxf.service.Student_Service_Impl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		like4();

	}
	@org.junit.Test
	public void like() {
		Student_Service_API sc=new Student_Service_Impl();
		
		try {
			for(Student student:sc.selectAllLikeName("d")) {
				System.out.println(student.toString());
			}
			sc.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@org.junit.Test
	public static void like3() {
		Student_Service_API sc=new Student_Service_Impl();
		
		try {
			System.out.println(sc.countStudent());
			sc.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	1.rulenum::聚合查询中规则的数量
//	 * 2.order::聚合查询中采用升序或者降序
//	 * 3.rule+i:: 聚合查询中的规则名(列名或者其他)
//	 * 4.rule::规则名
	@org.junit.Test
	public static void like4() {
		Student_Service_API sc=new Student_Service_Impl();
		Map<String,Object> map=new HashMap<>();
		map.put("rule", "max");
		map.put("rule1", "sqlscore");
		map.put("rule2", "javascore");
		map.put("rule3", "springscore");
		map.put("rulenum", 3);
		try {
			System.out.println(sc.selectAllbyRule(map));
			sc.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@org.junit.Test
	public static void like1() {
		Student_Service_API sc=new Student_Service_Impl();
		
		try {
			for(Student student:sc.selectAllByID(20174081)) {
				System.out.println(student.toString());
			}
			sc.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@org.junit.Test
	public void getScore() {
		Student_Service_API sc=new Student_Service_Impl();
		
		try {
			System.out.println("java");
			for(Student student:sc.selectAllbydesc("javascore")) {
				System.out.println(student.toString());
			}
			for(Student student:sc.selectAllbyasc("javascore")) {
				System.out.println(student.toString());
			}
			System.out.println("sql");
			for(Student student:sc.selectAllbydesc("sqlscore")) {
			
				System.out.println(student.toString());
			}
			
			for(Student student:sc.selectAllbyasc("sqlscore")) {
				System.out.println(student.toString());
			}
			System.out.println("spring");
			for(Student student:sc.selectAllbydesc("springscore")) {
			
				System.out.println(student.toString());
			}
			for(Student student:sc.selectAllbyasc("springscore")) {
				System.out.println(student.toString());
			}
			
			System.out.println("总分");
			for(Student student:sc.selectAllbydesc("studentscore")) {
				System.out.println(student.toString());
			}
			for(Student student:sc.selectAllbyasc("studentscore")) {
				System.out.println(student.toString());
			}
			sc.closeSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
