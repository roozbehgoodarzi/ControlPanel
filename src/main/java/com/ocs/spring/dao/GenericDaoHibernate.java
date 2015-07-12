package com.ocs.spring.dao;

import com.ocs.entity.DomainObject;
import com.ocs.entity.FetchResult;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Goodarzi on 10/22/14.
 */
@Repository
public class GenericDaoHibernate<T extends DomainObject> implements GenericDAO<T> {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public <T> T save(final T o) {
        return (T) sessionFactory.getCurrentSession().save(o);
    }


    public void delete(final Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    /***/
    public <T> T get(final Class<T> type, final Long id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    /***/
    public <T> T getByParameter(final Class<T> type, String paramName, String paramValue) {
        Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        crit.add(Restrictions.like(paramName, 1L));
        return (T) crit.uniqueResult();
    }

    public <T> T getByParameters(final Class<T> type, Map<String, String> params) {
        Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        for (String key : params.keySet()) {
            crit.add(Restrictions.like(key, params.get(key)));
        }
        return (T) crit.list().get(0);
    }

    /***/
    public <T> T merge(final T o) {
        return (T) sessionFactory.getCurrentSession().merge(o);
    }

    /***/
    public <T> void saveOrUpdate(final T o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    public <T> List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    public <T> List<T> getAllWithPagination(final Class<T> type, Integer firstResult, Integer maxResult, String orderByParam, Boolean asc) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
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
        return crit.list();
    }

    public FetchResult<T> getFetchResultWithPagination(final Class<T> type, Integer firstResult, Integer maxResult, String orderByParam, Boolean asc) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria critCount = session.createCriteria(type);
        FetchResult<T> fetchResult = new FetchResult<T>();
        fetchResult.setCount((Long) critCount.setProjection(Projections.rowCount()).uniqueResult());
        final Criteria crit = session.createCriteria(type);
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
        fetchResult.setResults(crit.list());
        return fetchResult;
    }


}
