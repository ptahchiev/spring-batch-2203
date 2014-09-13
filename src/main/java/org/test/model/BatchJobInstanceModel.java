package org.test.model;

import javax.batch.runtime.JobInstance;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Cacheable
@Entity(name = BatchJobInstanceModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = BatchJobInstanceModel.NAME, uniqueConstraints = { @UniqueConstraint(columnNames = { "pk", "id" }) }, indexes = { @Index(columnList = "id")})
public class BatchJobInstanceModel extends AbstractEntityModel implements JobInstance {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    public static final Integer TYPE_CODE = 2;

    public static final String NAME = "batch_job_instance";

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_key")
    private String jobKey;

    /* getters/setters */

    @Override
    public String getJobName() {
        return jobName;
    }

    public void setJobName(final String jobName) {
        this.jobName = jobName;
    }

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(final String jobKey) {
        this.jobKey = jobKey;
    }

    /* overriden delegates */

    @Override
    public long getInstanceId() {
        return super.getId();
    }

    @Override
    public Integer getTypeCode() {
        return TYPE_CODE;
    }

    @Override
    public String getEntityName() {
        return NAME;
    }
}
