package com.devong.act.controller;

import com.devong.act.model.Branch;
import com.devong.act.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class BranchController {
    @Autowired
    @Qualifier("branchService")
    BranchService branchService;

    @GetMapping("/branches")
    public List<String> getBranches(){
        return branchService.getBranchIds();
    }

    @GetMapping(value="/branch/{branchId}")
    public @ResponseBody Branch getBranch(@PathVariable String branchId){
        return branchService.getBranch(branchId);
    }

    @PutMapping(value="/branch/{branchId}")
    public Branch putBranch(@PathVariable String branchId){
        return branchService.putBranch(branchId);
    }
}
