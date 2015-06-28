package com.ocs.entity;

import org.hibernate.annotations.Parent;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by Goodarzi on 06/15/2015.
 */
@Embeddable
@Table(name="JOB_EXECUTION_PARAMS")
public class BatchJobExecutionParam {
    @Parent
    private BatchJobExecution batchJobExecution;
    @Column(name = "TYPE_CD")
    private String typeCD;
    @Column(name = "KEY_NAME")
    private String keyName;
    @Column(name = "STRING_VAL")
    private String stringVal;
    @Column(name = "DATE_VAL")
    private Timestamp dateVal;
    @Column(name = "LONG_VAL")
    private Long longVal;
    @Column(name = "DOUBLE_VAL")
    private Double doubleVal;
    @Column(name = "IDENTIFYING")
    private String identifying;

    public BatchJobExecution getBatchJobExecution() {
        return batchJobExecution;
    }

    public void setBatchJobExecution(BatchJobExecution batchJobExecution) {
        this.batchJobExecution = batchJobExecution;
    }

    public String getTypeCD() {
        return typeCD;
    }

    public void setTypeCD(String typeCD) {
        this.typeCD = typeCD;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public Timestamp getDateVal() {
        return dateVal;
    }

    public void setDateVal(Timestamp dateVal) {
        this.dateVal = dateVal;
    }

    public Long getLongVal() {
        return longVal;
    }

    public void setLongVal(Long longVal) {
        this.longVal = longVal;
    }

    public Double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(Double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public String getIdentifying() {
        return identifying;
    }

    public void setIdentifying(String identifying) {
        this.identifying = identifying;
    }
}
