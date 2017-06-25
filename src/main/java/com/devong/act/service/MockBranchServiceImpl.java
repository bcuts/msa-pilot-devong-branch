package com.devong.act.service;

import com.devong.act.model.Branch;
import com.devong.act.repository.MockData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mockBranchService")
public class MockBranchServiceImpl implements BranchService{
    @Override
    public List<Branch> getBranches() {
        return MockData.getBranches();
    }

    @Override
    public List<String> getBranchIds() {
        return MockData.getBranchIds();
    }

    @Override
    public Branch getBranch(String branchId) {
        return MockData.getBranch(branchId);
    }

    @Override
    public Branch putBranch(String branchId) {
        return MockData.putBranch(branchId);
    }
}
