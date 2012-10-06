package me.samlewis.jpaspring.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (getId() == null) {
            return super.equals(obj);
        } else {
            if (!(obj instanceof BaseDomainObject)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            BaseDomainObject entity = (BaseDomainObject) obj;
            return new EqualsBuilder().append(getId(), entity.getId())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            return super.hashCode();
        } else {
            return new HashCodeBuilder().append(getId()).toHashCode();
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + " id=" + id;
    }
}