package com.devong.act.controller;

import com.devong.act.model.Branch;
import com.devong.act.service.BranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@Api(value="branch", description="about branch API")
class BranchController {
    @Autowired
    @Qualifier("branchService")
    BranchService branchService;

    @ApiOperation(value="Get branch list")
    @GetMapping("/branches")
    public List<String> getBranches(){
        return branchService.getBranchIds();
    }

    @ApiOperation(value="Get branch by branch Id")
    @GetMapping(value="/branch/{branchId}")
    public @ResponseBody Branch getBranch(@PathVariable String branchId) throws Exception {
        return branchService.getBranch(branchId);
    }

    @ApiOperation(value="Save branch by branch Id")
    @PutMapping(value="/branch/{branchId}")
    public Branch putBranch(@PathVariable String branchId) throws Exception {
        return branchService.putBranch(branchId);
    }
}
