package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Abstract *non-Entity* class containing properties shared among all entities:<br>
 * id - record PK <br>
 * created_at - timestamp of record creation<br>
 * updated_at - timestamp of last record change<br>
 * deleted_at - timestamp of record deletion<br>
 * @author Angel Hermon
 */
@MappedSuperclass
public class AbstractRecord implements Serializable{
	private static final long serialVersionUID = -3342884974779016653L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name = "created_at", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date createAt;
	
	@Column(name = "updated_at", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date updatedAt;

	@Column(name = "deleted_at", insertable = true, updatable = true, columnDefinition="TIMESTAMP NULL DEFAULT NULL")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date deletedAt;

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

    @JsonIgnore
	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Long getId() {
		return id;
	}

	@PrePersist
	void createdAt() {
		this.createAt = this.updatedAt = new Date();
	}
	
	@PreUpdate
	void updateAt() {
		this.updatedAt = new Date();
	}

}
