package com.ocs.spring.service;

import com.ocs.entity.BatchJobExecution;
import com.ocs.entity.FetchResult;
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
    private BatchJobExecutionDao batchJobExecutionDao;

    public BatchJobExecutionDao getBatchJobExecutionDao() {
        return batchJobExecutionDao;
    }

    public void setBatchJobExecutionDao(BatchJobExecutionDao batchJobExecutionDao) {
        this.batchJobExecutionDao = batchJobExecutionDao;
    }
    @Transactional
    public BatchJobExecution getBatchJobExecutionById(Long id){
        return getBatchJobExecutionDao().get(BatchJobExecution.class, Long.valueOf(id));
    }

    @Transactional
    public List<BatchJobExecution> getAllBatchJobExecutions(){
        return getBatchJobExecutionDao().getAll(BatchJobExecution.class);
    }

    @Transactional
    public List<BatchJobExecution> getAllBatchExecutionsByStartTime(Timestamp startTime){
        return getBatchJobExecutionDao().getBatchJobExecutionsByStartTime(startTime);
    }

    @Transactional
    public List<BatchJobExecution> getAllBatchExecutionsByStatus(String status){
        return getBatchJobExecutionDao().getBatchJobExecutionsByStatus(status);
    }

    @Transactional
    public List<BatchJobExecution> getJobExecutionsByParameters(Map<String, String> params){
        return (List<BatchJobExecution>) getBatchJobExecutionDao().getByParameters(BatchJobExecution.class, params);
    }

    @Transactional
    public List<BatchJobExecution> getBatchJobExecutionsByStartDateAndBranch(Timestamp startTime, String status, String keyName, String stringValue){
        return getBatchJobExecutionDao().getBatchJobExecutionsByStartDateAndBranch(startTime, status, keyName, stringValue);
    }

    @Transactional
    public BatchJobExecution getBatchJobExecutionByParameter(String paramName, String paramValue){
        return getBatchJobExecutionDao().getByParameter(BatchJobExecution.class, paramName, paramValue);
    }

    @Transactional
    public FetchResult<BatchJobExecution> getBatchJobExecutionsByTimeRange(Integer firstResult, Integer maxResult, String orderByParam, Boolean asc, Timestamp startTimeFrom, Timestamp startTimeTo){
        return getBatchJobExecutionDao().getBatchJobExecutionsByTimeRange(firstResult, maxResult, orderByParam, asc, startTimeFrom, startTimeTo);
    }

}
