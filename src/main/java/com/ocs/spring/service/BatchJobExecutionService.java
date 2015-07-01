package com.ocs.spring.service;

import com.ocs.entity.BatchJobExecution;
import com.ocs.spring.dao.hibernateImpl.BatchJobExecutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Goodarzi on 06/15/2015.
 */
@Service("BatchJobExecutionService")
@Transactional
public class BatchJobExecutionService {
    @Autowired
    private BatchJobExecutionDao branchJobExecutionDao;

    public BatchJobExecutionDao getBranchJobExecutionDao() {
        return branchJobExecutionDao;
    }

    public void setBranchJobExecutionDao(BatchJobExecutionDao branchJobExecutionDao) {
        this.branchJobExecutionDao = branchJobExecutionDao;
    }
    @Transactional
    public BatchJobExecution getBatchJobExecutionById(Long id){
        return getBranchJobExecutionDao().get(BatchJobExecution.class, Long.valueOf(id));
    }

    @Transactional
    public List<BatchJobExecution> getAllBatchJobExecutions(){
        return getBranchJobExecutionDao().getAll(BatchJobExecution.class);
    }

    @Transactional
    public List<BatchJobExecution> getAllBatchExecutionsByStartTime(Timestamp startTime){
        return getBranchJobExecutionDao().getBatchJobExecutionsByStartTime(startTime);
    }

    @Transactional
    public List<BatchJobExecution> getAllBatchExecutionsByStatus(String status){
        return getBranchJobExecutionDao().getBatchJobExecutionsByStatus(status);
    }

    @Transactional
    public List<BatchJobExecution> getJobExecutionsByParameters(Map<String, String> params){
        return (List<BatchJobExecution>) getBranchJobExecutionDao().getByParameters(BatchJobExecution.class, params);
    }

}
