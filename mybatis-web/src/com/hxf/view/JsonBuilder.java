package com.hxf.view;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hxf.pojo.Student;
import com.hxf.service.Student_Service_Impl;

public class JsonBuilder {
	
	public String getJsontoAll(List<Student> list) throws Exception {
		
		String json="{\"scores\":[";	
		
			/*{
					"employees": [
					{ "firstName":"Bill" , "lastName":"Gates" },
					{ "firstName":"George" , "lastName":"Bush" },
					{ "firstName":"Thomas" , "lastName":"Carter" }
					]
					}
		*///W3C标准格式
		
		int num=0;
		for(Student score:list) {
			String scoreone="{\"userid\":\""+score.getStudentid()+"\",\"username\":\""+score.getStudentname()+
					"\",\"userclass\":"+score.getStudentclass()+",\"userscore\":"+score.getStudentscore()+",\"javascore\":"+
					score.getJavascore()+",\"sqlscore\":"+score.getSqlscore()+",\"springscore\":"+score.getSpringscore()+
					",\"studentinfo\":"+score.getstuinfo().getStudentinfo()+",\"studentaddress\":"+score.getstuinfo().getStudentaddress()+
					"}";
			//System.out.println("size::"+list.size()+" num::"+num);
			if(num==(list.size()-1)) {
				json=json+scoreone;
				num++;
				break;
			}
			num++;
			json=json+scoreone+",";
		}
		json=json+"],";
		Student_Service_Impl studentimpl=new Student_Service_Impl();
		String json2="\"avgscore\":"+studentimpl.avgStudentScore();
		Map<String,Object> map=new HashMap<>();
		map.put("rule", "max");//规则
		map.put("rule1", "studentscore");//项
		map.put("rulenum", 1);//数量
		String json3_5=",\"maxscore\":"+studentimpl.selectAllbyRule(map).get("rule1");
		
		map.clear();
		map.put("rule", "min");//规则
		map.put("rule1", "studentscore");//项
		map.put("rulenum", 1);//数量
		String json3_6=",\"minscore\":"+studentimpl.selectAllbyRule(map).get("rule1");
		
		//String json4="\"maxscore\":"+studentimpl();
		String json3=",\"studentnum\":"+studentimpl.countStudent()+"}";
		studentimpl.closeSession();
		json=json+json2+json3_5+json3_6+json3;
		return json;
	}

}
