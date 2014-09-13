package org.test.model;

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

@Entity(name = BatchJobExecutionModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = BatchJobExecutionModel.NAME, uniqueConstraints = { @UniqueConstraint(columnNames = { "pk", "id" }) }, indexes = { @Index(columnList = "id")})
public class BatchJobExecutionModel extends AbstractEntityModel {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    public static final Integer TYPE_CODE = 2;

    public static final String NAME = "batch_job_execution";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_instance_id", nullable = true, referencedColumnName = "pk")
    private BatchJobInstanceModel jobInstance;

    @Column(name = "create_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createTime;

    @Column(name = "start_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime startTime;

    @Column(name = "end_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime endTime;

    @Column(name = "status")
    private String status;

    @Column(name = "exit_code")
    private String exitCode;

    @Column(name = "exit_message")
    private String exitMessage;

    @Column(name = "last_updated")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastUpdated;

    /* getters/setters */

    public BatchJobInstanceModel getJobInstance() {
        return jobInstance;
    }

    public void setJobInstance(final BatchJobInstanceModel jobInstance) {
        this.jobInstance = jobInstance;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(final DateTime createTime) {
        this.createTime = createTime;
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
