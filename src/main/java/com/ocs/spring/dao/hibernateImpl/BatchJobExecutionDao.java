package com.ocs.spring.dao.hibernateImpl;

import com.ocs.entity.BatchJobExecution;
import com.ocs.spring.dao.GenericDaoHibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Goodarzi on 06/15/2015.
 */
@Repository
public class BatchJobExecutionDao extends GenericDaoHibernate<BatchJobExecution> {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<BatchJobExecution> getBatchJobExecutionsByStartTime(Timestamp startTime) {
        Query query =  sessionFactory.getCurrentSession().createQuery("from BatchJobExecution where startTime = :startTime");
        query.setParameter("startTime", startTime);
        return query.list();
    }
    public List<BatchJobExecution> getBatchJobExecutionsByStatus(String status) {
        Query query =  sessionFactory.getCurrentSession().createQuery("from BatchJobExecution where status = :status");
        query.setParameter("status", status);
        return query.list();
    }
}
