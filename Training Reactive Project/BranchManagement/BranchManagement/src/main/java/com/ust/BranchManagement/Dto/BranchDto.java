package com.ust.BranchManagement.Dto;

import reactor.core.publisher.Flux;

public class BranchDto {

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
	public BranchDto(int branchId, int branchName, int courseCode, Flux<StudentDto> student) {
		super();
		BranchId = branchId;
		BranchName = branchName;
		this.courseCode = courseCode;
		this.student = student;
	}
	@Override
	public String toString() {
		return "BranchDto [BranchId=" + BranchId + ", BranchName=" + BranchName + ", courseCode=" + courseCode
				+ ", student=" + student + "]";
	}
	public BranchDto() {
		super();
	}
	
	
}
