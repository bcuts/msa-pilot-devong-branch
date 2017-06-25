package com.devong.act.repository;


import com.devong.act.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, String>{
}
