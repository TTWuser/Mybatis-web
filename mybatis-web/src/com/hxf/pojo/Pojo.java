package com.hxf.pojo;

public class Pojo {
	private Integer studentid;
	private String studentname;
	private Integer studentclass;
	private Integer studentscore;
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public Integer getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(Integer studentclass) {
		this.studentclass = studentclass;
	}
	public Integer getStudentscore() {
		return studentscore;
	}
	public void setStudentscore(Integer studentscore) {
		this.studentscore = studentscore;
	}
	public Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pojo(Integer studentid, String studentname, Integer studentclass, Integer studentscore) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentclass = studentclass;
		this.studentscore = studentscore;
	}
	@Override
	public String toString() {
		return "Pojo [studentid=" + studentid + ", studentname=" + studentname + ", studentclass=" + studentclass
				+ ", studentscore=" + studentscore + "]";
	}
	
	

}
