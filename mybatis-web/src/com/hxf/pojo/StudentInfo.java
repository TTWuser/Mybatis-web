package com.hxf.pojo;

public class StudentInfo {
	private Integer studentid;
	private String studentaddress;
	private String studentinfo;
	public StudentInfo(Integer studentid, String studentaddress, String studentinfo) {
		super();
		this.studentid = studentid;
		this.studentaddress = studentaddress;
		this.studentinfo = studentinfo;
	}
	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getStudentaddress() {
		return studentaddress;
	}
	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}
	public String getStudentinfo() {
		return studentinfo;
	}
	public void setStudentinfo(String studentinfo) {
		this.studentinfo = studentinfo;
	}
	@Override
	public String toString() {
		return "Pojo [studentid=" + studentid + ", studentaddress=" + studentaddress + ", studentinfo=" + studentinfo
				+ "]";
	}
	
}
