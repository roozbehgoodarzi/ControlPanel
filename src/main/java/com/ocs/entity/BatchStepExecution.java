package com.ocs.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Goodarzi on 06/15/2015.
 */
@Entity
@Table(name="BATCH_STEP_EXECUTION")
public class BatchStepExecution implements DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STEP_EXECUTION_ID", nullable = false)
    private Long id;
    @Column(name = "VERSION")
    private Long version;
    @Column(name="STEP_NAME")
    private String stepName;
    @Column(name="START_TIME")
    private Timestamp startTime;
    @Column(name="END_TIME")
    private Timestamp endTime;
    @Column(name="STATUS")
    private String status;
    @Column(name="COMMIT_COUNT")
    private Long commitCount;
    @Column(name="READ_COUNT")
    private Long readCount;
    @Column(name="FILTER_COUNT")
    private Long filterCount;
    @Column(name="WRITE_COUNT")
    private Long writeCount;
    @Column(name="READ_SKIP_COUNT")
    private Long readSkipCount;
    @Column(name="WRITE_SKIP_COUNT")
    private Long writeSkipCount;
    @Column(name="PROCESS_SKIP_COUNT")
    private Long processSkipCount;
    @Column(name="ROLLBACK_COUNT")
    private Long rollBackCount;
    @Column(name="EXIT_CODE")
    private String exitCode;
    @Column(name="EXIT_MESSAGE")
    private String exitMessage;
    @Column(name="LAST_UPDATED")
    private Timestamp lastUpdated;

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

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
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

    public Long getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(Long commitCount) {
        this.commitCount = commitCount;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Long getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(Long filterCount) {
        this.filterCount = filterCount;
    }

    public Long getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(Long writeCount) {
        this.writeCount = writeCount;
    }

    public Long getReadSkipCount() {
        return readSkipCount;
    }

    public void setReadSkipCount(Long readSkipCount) {
        this.readSkipCount = readSkipCount;
    }

    public Long getWriteSkipCount() {
        return writeSkipCount;
    }

    public void setWriteSkipCount(Long writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }

    public Long getProcessSkipCount() {
        return processSkipCount;
    }

    public void setProcessSkipCount(Long processSkipCount) {
        this.processSkipCount = processSkipCount;
    }

    public Long getRollBackCount() {
        return rollBackCount;
    }

    public void setRollBackCount(Long rollBackCount) {
        this.rollBackCount = rollBackCount;
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
}
