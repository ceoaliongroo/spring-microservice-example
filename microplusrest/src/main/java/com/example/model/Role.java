package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


/**
 * User roles in the system
 * @author Angel Hermon
 */
@Entity
@Table(name = "role")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role extends AbstractRecord {

	private static final long serialVersionUID = 1193362381908599362L;
	
	@Column(name = "name", nullable=false, length=50, unique = true)
	private String name;
	
	@Column(name = "description", nullable=true, length=1000)
	private String description;

	@OneToMany(mappedBy = "role")
	List<AdminUser> admins;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
