package com.ocs.spring.dao.hibernateImpl;

import com.ocs.entity.BatchJobExecution;
import com.ocs.spring.dao.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Query query = sessionFactory.getCurrentSession().createQuery("from BatchJobExecution where startTime = :startTime");
        query.setParameter("startTime", startTime);
        return query.list();
    }

    public List<BatchJobExecution> getBatchJobExecutionsByStatus(String status) {
        Query query = sessionFactory.getCurrentSession().createQuery("from BatchJobExecution where status = :status");
        query.setParameter("status", status);
        return query.list();
    }

    public List<BatchJobExecution> getBatchJobExecutionsByStartDateAndBranch(Timestamp startTime, String status, String keyName, String stringValue) {
        Session session = sessionFactory.getCurrentSession();
        List<BatchJobExecution> batchJobExecutions = session.createCriteria(BatchJobExecution.class)
                .add(Restrictions.like("startTime", startTime))
                .add(Restrictions.like("status", status))
                .createCriteria("jobExecutionParams")
                .add(Restrictions.like("keyName", keyName))
                .add(Restrictions.like("stringValue", stringValue))
                .list();
        return batchJobExecutions;
    }
}
