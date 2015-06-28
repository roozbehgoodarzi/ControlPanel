package com.ocs.entity;

import java.util.List;

/**
 * Created by Goodarzi on 06/28/2015.
 */
public class FetchResult<T extends DomainObject> {
    private Long count;
    private List<T> results;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
