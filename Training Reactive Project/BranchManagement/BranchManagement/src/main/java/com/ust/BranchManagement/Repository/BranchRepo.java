package com.ust.BranchManagement.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//import com.ust.BranchManagement.Dto.ResponseDto;
import com.ust.BranchManagement.Model.Branch;

@Repository
public interface BranchRepo extends ReactiveMongoRepository<Branch, Integer>{

	Optional<Branch> findByCoursecode(int coursecode);

	
}
