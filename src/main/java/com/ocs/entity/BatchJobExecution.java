package com.ocs.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goodarzi on 06/15/2015.
 */
@Entity
@Table(name = "BATCH_JOB_EXECUTION")
public class BatchJobExecution implements DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_EXECUTION_ID", nullable = false)
    private Long id;
    @Column(name = "VERSION")
    private Long version;
    @Column(name = "JOB_INSTANCE_ID")
    private Long jobInstanceId;
    @Column(name = "CREATE_TIME")
    private Timestamp createTime;
    @Column(name = "START_TIME")
    private Timestamp startTime;
    @Column(name = "END_TIME")
    private Timestamp endTime;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "EXIT_CODE")
    private String exitCode;
    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;
    @Column(name = "LAST_UPDATED")
    private Timestamp lastUpdated;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="BATCH_JOB_EXECUTION_PARAMS", joinColumns = @JoinColumn(name = "JOB_EXECUTION_ID"))
    @Column(name="Job_Execution_Param")
    private List<BatchJobExecutionParam> jobExecutionParams;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="JOB_EXECUTION_ID")
    private List<BatchStepExecution> batchStepExecutions = new ArrayList<BatchStepExecution>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(Long jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<BatchJobExecutionParam> getJobExecutionParams() {
        return jobExecutionParams;
    }

    public void setJobExecutionParams(List<BatchJobExecutionParam> jobExecutionParams) {
        this.jobExecutionParams = jobExecutionParams;
    }

    public List<BatchStepExecution> getBatchStepExecutions() {
        return batchStepExecutions;
    }

    public void setBatchStepExecutions(List<BatchStepExecution> batchStepExecutions) {
        this.batchStepExecutions = batchStepExecutions;
    }
}
