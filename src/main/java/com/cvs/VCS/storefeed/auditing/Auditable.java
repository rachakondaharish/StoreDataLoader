package com.cvs.vcs.storefeed.auditing;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Moving necessary fields to super class and providing AuditingEntityListener entity listener class

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedBy
    @Column(name="created_by",columnDefinition = "VARCHAR(255) ")
    protected U CreatedBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="created_date",columnDefinition = "datetime NOT NULL DEFAULT CURRENT_TIMESTAMP", updatable = false)
    protected Date CreatedDate;

    @LastModifiedBy
    @Column(name="last_modified_by",columnDefinition = "VARCHAR(255) NOT NULL")
    protected U LastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name="last_modified_date",columnDefinition = "datetime NOT NULL")
    protected Date LastModifiedDate;

	public U getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(U createdBy) {
		CreatedBy = createdBy;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public U getLastModifiedBy() {
		return LastModifiedBy;
	}

	public void setLastModifiedBy(U lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

    
}

