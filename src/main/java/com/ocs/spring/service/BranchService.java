package com.ocs.spring.service;

import com.ocs.entity.Branch;
import com.ocs.entity.FetchResult;
import com.ocs.spring.dao.hibernateImpl.BranchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Goodarzi on 06/14/2015.
 */
@Service("BranchService")
@Transactional(readOnly = true)
public class BranchService {
    @Autowired
    private BranchDao branchDao;

    public BranchDao getBranchDao() {
        return branchDao;
    }

    public void setBranchDao(BranchDao branchDao) {
        this.branchDao = branchDao;
    }

    @Transactional
    public Branch getBranchByCode(Long code) {
        return getBranchDao().get(Branch.class, Long.valueOf(code));
    }

    @Transactional(readOnly = false)
    public void addBranch(Branch branch) {
        getBranchDao().save(branch);
    }

    @Transactional(readOnly = false)
    public void updateBranch(Branch branch) {
        getBranchDao().saveOrUpdate(branch);
    }

    @Transactional
    public void deleteBranch(Branch branch) {
        getBranchDao().delete(branch);
    }

    @Transactional
    public List<Branch> getBranches() {
        return getBranchDao().getAll(Branch.class);
    }

    @Transactional
    public List<Branch> getBranchesWithPagination(Integer firstResult, Integer maxResult, String orderByParam, Boolean asc) {
        return getBranchDao().getAllWithPagination(Branch.class, firstResult, maxResult, orderByParam, asc);
    }
    @Transactional
    public FetchResult<Branch> getBranchesFetchResulyWithPagination(Integer firstResult, Integer maxResult, String orderByParam, Boolean asc) {
        return getBranchDao().getFetchResultWithPagination(Branch.class, firstResult, maxResult, orderByParam, asc);
    }

    @Transactional
    public Branch getBranchByParameter(String paramName, String paramValue) {
        return getBranchDao().getByParameter(Branch.class, paramName, paramValue);
    }

    public Branch getBranchByParameters(Map<String,String> paramMap){
        return getBranchDao().getByParameters(Branch.class, paramMap);
    }

}
