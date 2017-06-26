package com.devong.act.service;

import com.devong.act.model.Branch;
import com.devong.act.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
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
    public Branch getBranch(String id) throws Exception {
        if(!branchDao.exists(id)){
            throw new EntityNotFoundException();
        }
        return branchDao.getOne(id);
    }

    @Override
    public Branch putBranch(String branchId) throws Exception {
        if(branchDao.exists(branchId)){
            throw new EntityExistsException();
        }
        Branch branch = new Branch();
        branch.setId(branchId);
        return branchDao.save(branch);
    }
}
