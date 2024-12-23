package com.ust.BranchManagement.Dto;

public class StudentDto {
	
	private int studentId;
	private String studentName;
	private int AttendencePercentage;
	private String email;
	private int courseCode;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAttendencePercentage() {
		return AttendencePercentage;
	}
	public void setAttendencePercentage(int attendencePercentage) {
		AttendencePercentage = attendencePercentage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public StudentDto(int studentId, String studentName, int attendencePercentage, String email, int courseCode) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		AttendencePercentage = attendencePercentage;
		this.email = email;
		this.courseCode = courseCode;
	}
	public StudentDto() {
		super();
	}
	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", AttendencePercentage="
				+ AttendencePercentage + ", email=" + email + ", courseCode=" + courseCode + "]";
	}
	
	
	
	
}
