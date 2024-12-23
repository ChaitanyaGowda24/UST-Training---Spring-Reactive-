package com.ust.BranchManagement.Dto;

import java.util.List;

import reactor.core.publisher.Flux;

public class ResponseDto {

	private BranchDto branchdto;
	private Flux<StudentDto> studentdto;
	public BranchDto getBranchdto() {
		return branchdto;
	}
	public void setBranchdto(BranchDto branchdto) {
		this.branchdto = branchdto;
	}
	public Flux<StudentDto> getStudentdto() {
		return studentdto;
	}
	public void setStudentdto(Flux<StudentDto> studentdto) {
		this.studentdto = studentdto;
	}
	public ResponseDto(BranchDto branchdto, Flux<StudentDto> studentdto) {
		super();
		this.branchdto = branchdto;
		this.studentdto = studentdto;
	}
	public ResponseDto() {
		super();
	}
	@Override
	public String toString() {
		return "ResponseDto [branchdto=" + branchdto + ", studentdto=" + studentdto + "]";
	}
	
	
	
}
