package com.devong.act.service;

import com.devong.act.model.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BranchService {
    public List<Branch> getBranches();
    public List<String> getBranchIds();

    public Branch getBranch(String id);

    public int putBranch(String branchId);
}
