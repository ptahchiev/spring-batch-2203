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
@Entity(name = BatchJobExecutionParamsModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = BatchJobExecutionParamsModel.NAME, uniqueConstraints = { @UniqueConstraint(columnNames = { "pk", "id" }) }, indexes = { @Index(columnList = "id")})
public class BatchJobExecutionParamsModel extends AbstractEntityModel {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    public static final Integer TYPE_CODE = 2;

    public static final String NAME = "BATCH_JOB_EXECUTION_PARAMS";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = true, referencedColumnName = "pk")
    private BatchJobExecutionModel jobExecution;

    @Column(name = "TYPE_CD")
    private String typeCD;

    @Column(name = "KEY_NAME")
    private String keyName;

    @Column(name = "STRING_VAL")
    private String stringVal;

    @Column(name = "DATE_VAL")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateVal;

    @Column(name = "LONG_VAL")
    private Long longVal;

    @Column(name = "DOUBLE_VAL")
    private Double doubleVal;

    @Column(name = "IDENTIFYING")
    private Character identifying;

    /* getters/setters */

    public BatchJobExecutionModel getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(final BatchJobExecutionModel jobExecution) {
        this.jobExecution = jobExecution;
    }

    public String getTypeCD() {
        return typeCD;
    }

    public void setTypeCD(final String typeCD) {
        this.typeCD = typeCD;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(final String keyName) {
        this.keyName = keyName;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(final String stringVal) {
        this.stringVal = stringVal;
    }

    public DateTime getDateVal() {
        return dateVal;
    }

    public void setDateVal(final DateTime dateVal) {
        this.dateVal = dateVal;
    }

    public Long getLongVal() {
        return longVal;
    }

    public void setLongVal(final Long longVal) {
        this.longVal = longVal;
    }

    public Double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(final Double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public Character getIdentifying() {
        return identifying;
    }

    public void setIdentifying(final Character identifying) {
        this.identifying = identifying;
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

