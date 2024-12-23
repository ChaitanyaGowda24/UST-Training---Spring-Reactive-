package com.ust.BranchManagement.Model;

//import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ust.BranchManagement.Dto.StudentDto;

import reactor.core.publisher.Flux;

@Document
public class Branch {
	
	
	private int BranchId;
	private int BranchName;
	private int courseCode;
	private Flux<StudentDto> student;
	public int getBranchId() {
		return BranchId;
	}
	public void setBranchId(int branchId) {
		BranchId = branchId;
	}
	public int getBranchName() {
		return BranchName;
	}
	public void setBranchName(int branchName) {
		BranchName = branchName;
	}
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public Flux<StudentDto> getStudent() {
		return student;
	}
	public void setStudent(Flux<StudentDto> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Branch [BranchId=" + BranchId + ", BranchName=" + BranchName + ", courseCode=" + courseCode
				+ ", student=" + student + "]";
	}
	public Branch(int branchId, int branchName, int courseCode, Flux<StudentDto> student) {
		super();
		BranchId = branchId;
		BranchName = branchName;
		this.courseCode = courseCode;
		this.student = student;
	}
	public Branch() {
		super();
	}
	
	
}
