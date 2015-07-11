package com.ocs.spring.service;

import com.ocs.spring.dao.hibernateImpl.BatchStepExecutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ocs1 on 7/11/2015.
 */
@Service("BatchStepExecutionService")
@Transactional
public class BatchStepExecutionService {

    @Autowired
    private BatchStepExecutionDao batchStepExecutionDao;

    public BatchStepExecutionDao getBatchStepExecutionDao() {
        return batchStepExecutionDao;
    }

    public void setBatchStepExecutionDao(BatchStepExecutionDao batchStepExecutionDao) {
        this.batchStepExecutionDao = batchStepExecutionDao;
    }


}
