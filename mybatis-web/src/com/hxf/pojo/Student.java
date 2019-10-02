package com.hxf.pojo;

public class Student {
	
	private Integer studentid;
	private String studentname;
	private Integer studentclass;
	private Integer studentscore;
	
	private Integer javascore;
	private Integer sqlscore;
	private Integer springscore;
	
	public Student() {
		
	}
	
	public Student(Integer studentid,String studentname,Integer studentclass,Integer studentscore,Integer javascore,Integer sqlscore,Integer springscore) {
			this.studentid=studentid;
			this.studentname=studentname;
			this.studentclass=studentclass;
			this.studentscore=studentscore;
			this.javascore=javascore;
			this.sqlscore=sqlscore;
			this.springscore=springscore;
	}
	
	
	@Override
	public String toString() {
		return "Score [studentid=" + studentid + ", studentname=" + studentname + ", studentclass=" + studentclass + ", studentscore="
				+ studentscore + ", javascore=" + javascore + ", sqlscore=" + sqlscore + ", springscore=" + springscore
				+ "]";
	}

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

	public Integer getJavascore() {
		return javascore;
	}

	public void setJavascore(Integer javascore) {
		this.javascore = javascore;
	}

	public Integer getSqlscore() {
		return sqlscore;
	}

	public void setSqlscore(Integer sqlscore) {
		this.sqlscore = sqlscore;
	}

	public Integer getSpringscore() {
		return springscore;
	}

	public void setSpringscore(Integer springscore) {
		this.springscore = springscore;
	}
	

}
