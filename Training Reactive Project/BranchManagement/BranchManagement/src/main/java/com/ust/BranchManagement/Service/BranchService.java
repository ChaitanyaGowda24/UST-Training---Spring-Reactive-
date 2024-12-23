package com.ust.BranchManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ust.BranchManagement.Dto.BranchDto;
import com.ust.BranchManagement.Dto.ResponseDto;
import com.ust.BranchManagement.Dto.StudentDto;
import com.ust.BranchManagement.Model.Branch;
import com.ust.BranchManagement.Repository.BranchRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BranchService {

	@Autowired
	private BranchRepo repo;

	@Autowired
	private WebClient webclient;
	public Mono<Branch> addBranch(Branch branch) {
		return repo.save(branch);
	}

	public Flux<Branch> getAllBranch() {
		return repo.findAll();
	}

	@CircuitBreaker(name="branchservice" , fallbackMethod="fallbackGetBranch")
	public ResponseDto getCoursecode(int coursecode) {
		ResponseDto responseDto = new ResponseDto();
		Branch branch = repo.findByCoursecode(coursecode).orElseThrow(() -> new RuntimeException("course not found"));
        BranchDto branchDto = mapToBranchDto(branch);

        Flux<StudentDto> studenttolist = webclient.get()
                .uri("http://localhost:8084/student/" + branch.getCourseCode())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Flux<StudentDto>>() {
                })
                .block();

        responseDto.setBranchdto(branchDto);
        responseDto.setStudentdto(studenttolist);

        return responseDto;
	}
	
    private BranchDto mapToBranchDto(Branch branch) {
   	    BranchDto branchDto = new BranchDto();
   	    branchDto.setBranchId(branch.getBranchId());
        branchDto.setBranchName(branch.getBranchName());
        branchDto.setCourseCode(branch.getCourseCode());

    	    // Fetch students for the given branch/course code using WebClient
        Flux<StudentDto> students = webclient.get()
                .uri("http://localhost:8084/student/" + branch.getCourseCode())
                .retrieve()
                .bodyToFlux(StudentDto.class); // Reactive stream of StudentDto

   	    branchDto.setStudent(students);
        return branchDto;
    	}

	public ResponseDto fallbackGetBooking(String VehcileNumber, Throwable throwable) {
        // Handle the fallback logic, e.g., return a default response or log the error
        return new ResponseDto(); // Return an empty response or a default response
    }

	
}
