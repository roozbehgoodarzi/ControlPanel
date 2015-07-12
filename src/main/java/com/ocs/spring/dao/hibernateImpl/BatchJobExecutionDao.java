package com.ocs.spring.dao.hibernateImpl;

import com.ocs.entity.BatchJobExecution;
import com.ocs.entity.FetchResult;
import com.ocs.spring.dao.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
                .add(Restrictions.like("stringVal", stringValue))
                .list();
        return batchJobExecutions;
    }

    public FetchResult<BatchJobExecution> getBatchJobExecutionsByTimeRange(Integer firstResult, Integer maxResult, String orderByParam, Boolean asc, Timestamp startTimeFrom, Timestamp startTimeTo) {
        Session session = sessionFactory.getCurrentSession();
        final Criteria critCount = session.createCriteria(BatchJobExecution.class);
        FetchResult<BatchJobExecution> fetchResult = new FetchResult<BatchJobExecution>();
        fetchResult.setCount((Long) critCount.setProjection(Projections.rowCount()).uniqueResult());
        final Criteria crit = session.createCriteria(BatchJobExecution.class);
        if (firstResult == null)
            firstResult = 0;
        crit.setFirstResult(firstResult);
        if (maxResult != null)
            crit.setMaxResults(maxResult);
        if (asc != null && orderByParam != "" && orderByParam != null) {
            if (asc)
                crit.addOrder(Order.asc(orderByParam));
            else
                crit.addOrder(Order.desc(orderByParam));
        }
        crit.add(Restrictions.ge("startTime", startTimeFrom));
        crit.add(Restrictions.lt("startTime", startTimeTo));
        fetchResult.setResults(crit.list());
        return fetchResult;
    }
}
