package org.test.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Cacheable
@Entity(name = BatchStepExecutionContextModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = BatchStepExecutionContextModel.NAME, uniqueConstraints = { @UniqueConstraint(columnNames = { "pk", "id" }) }, indexes = { @Index(columnList = "id")})
public class BatchStepExecutionContextModel extends AbstractEntityModel {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    public static final Integer TYPE_CODE = 2;

    public static final String NAME = "BATCH_STEP_EXECUTION_CONTEXT";

    @Column(name = "SHORT_CONTEXT")
    private String shortContext;

    @Lob
    @Column(name = "SERIALIZED_CONTEXT")
    private String serializedContext;

    /* getters/setters */

    public String getShortContext() {
        return shortContext;
    }

    public void setShortContext(final String shortContext) {
        this.shortContext = shortContext;
    }

    public String getSerializedContext() {
        return serializedContext;
    }

    public void setSerializedContext(final String serializedContext) {
        this.serializedContext = serializedContext;
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

