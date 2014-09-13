package org.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;

@MappedSuperclass
@NamedEntityGraph(name = "basic", attributeNodes = { @NamedAttributeNode("uid") })
public abstract class AbstractEntityModel implements Auditable<String, Long> {

    /**
     * Default serial version uid.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "seq_id", strategy = "com.nemesis.platform.core.model.CorePKIdentifierGenerator")
    @GeneratedValue(generator = "seq_id")
    @Column(name = "pk", nullable = false, unique = true)
    private Long pk;

    @Column(name = "id", nullable = false)
    private String uid = java.util.UUID.randomUUID().toString();

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastModifiedDate;

    public abstract Integer getTypeCode();

    public abstract String getEntityName();

    /* overriden methods */

    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getPk());
        builder.append(getUid());
        return builder.toHashCode();
    }

    @Override
    public final boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || // looks into the target class of a proxy if necessary
            !other.getClass().equals(this.getClass())) {
            return false;
        }

        // if pks are both set, compare
        if (getPk() != null) {
            final Serializable otherPk = ((AbstractEntityModel) other).getPk();
            if (otherPk != null) {
                return getPk().equals(otherPk);
            }
        }

        return getUid().equals(((AbstractEntityModel) other).getUid());
    }

    @Override
    public String toString() {
        final StringBuilder build = new StringBuilder("[");
        if (uid != null) {
            build.append(uid);
        } else {
            build.append("new");
        }
        build.append(" - ").append(getClass().getSimpleName());

        build.append("]");

        return build.toString();
    }

    /* getters/setters */

    public Long getPk() {
        return pk;
    }

    public void setPk(final Long pk) {
        this.pk = pk;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(final String uid) {
        this.uid = uid;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(final DateTime creationDate) {
        this.createdDate = creationDate;
    }

    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(final DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public Long getId() {
        return getPk();
    }

    @Override
    public boolean isNew() {
        return getPk() == null;
    }
}
