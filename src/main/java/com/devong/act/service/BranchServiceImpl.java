package com.devong.act.service;

import com.devong.act.model.Branch;
import com.devong.act.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("branchService")
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepository branchDao;

    @Override
    public List<Branch> getBranches() {
        return branchDao.findAll();
    }

    @Override
    public List<String> getBranchIds() {
        List<String> branchIds = new ArrayList<>();
        for(Branch branch : branchDao.findAll()){
            branchIds.add(branch.getId());
        }
        return branchIds;
    }

    @Override
    public Branch getBranch(String id) {
        return branchDao.getOne(id);
    }

    @Override
    public Branch putBranch(String branchId) {
        Branch branch = new Branch(branchId);
        return branchDao.save(branch);
    }
}
