package org.test.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;


@Cacheable
@Entity(name = BatchStepExecutionModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = BatchStepExecutionModel.NAME, uniqueConstraints = { @UniqueConstraint(columnNames = { "pk", "id" }) }, indexes = { @Index(columnList = "id")})
public class BatchStepExecutionModel  extends AbstractEntityModel {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    public static final Integer TYPE_CODE = 2;

    public static final String NAME = "BATCH_STEP_EXECUTION";

    @Column(name = "STEP_NAME")
    private String stepName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = true, referencedColumnName = "pk")
    private BatchJobExecutionModel batchJobExecution;

    @Column(name = "START_TIME")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startTime;

    @Column(name = "END_TIME")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "LIMIT_COUNT")
    private Long commitCount;

    @Column(name = "READ_COUNT")
    private Long readCount;

    @Column(name = "FILTER_COUNT")
    private Long filterCount;

    @Column(name = "WRITE_COUNT")
    private Long writeCount;

    @Column(name = "READ_SKIP_COUNT")
    private Long readSkipCount;

    @Column(name = "WRITE_SKIP_COUNT")
    private Long writeSkipCount;

    @Column(name = "PROCESS_SKIP_COUNT")
    private Long processSkipCount;

    @Column(name = "ROLLBACK_COUNT")
    private Long rollbackCount;

    @Column(name = "EXIT_CODE")
    private String exitCode;

    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastUpdated;

    /* getters/setters */

    public String getStepName() {
        return stepName;
    }

    public void setStepName(final String stepName) {
        this.stepName = stepName;
    }

    public BatchJobExecutionModel getBatchJobExecution() {
        return batchJobExecution;
    }

    public void setBatchJobExecution(final BatchJobExecutionModel batchJobExecution) {
        this.batchJobExecution = batchJobExecution;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(final DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(final DateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Long getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(final Long commitCount) {
        this.commitCount = commitCount;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(final Long readCount) {
        this.readCount = readCount;
    }

    public Long getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(final Long filterCount) {
        this.filterCount = filterCount;
    }

    public Long getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(final Long writeCount) {
        this.writeCount = writeCount;
    }

    public Long getReadSkipCount() {
        return readSkipCount;
    }

    public void setReadSkipCount(final Long readSkipCount) {
        this.readSkipCount = readSkipCount;
    }

    public Long getWriteSkipCount() {
        return writeSkipCount;
    }

    public void setWriteSkipCount(final Long writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }

    public Long getProcessSkipCount() {
        return processSkipCount;
    }

    public void setProcessSkipCount(final Long processSkipCount) {
        this.processSkipCount = processSkipCount;
    }

    public Long getRollbackCount() {
        return rollbackCount;
    }

    public void setRollbackCount(final Long rollbackCount) {
        this.rollbackCount = rollbackCount;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(final String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(final String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /* overriden delegates */

    @Override
    public Integer getTypeCode() {
        return TYPE_CODE;
    }

    @Override
    public String getEntityName() {
        return NAME;
    }
}
