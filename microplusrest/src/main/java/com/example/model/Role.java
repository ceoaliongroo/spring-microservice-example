package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


/**
 * User roles in the system
 * @author Angel Hermon
 */
@Entity
@Table(name = "role")
public class Role extends AbstractRecord {

	private static final long serialVersionUID = 1193362381908599362L;
	
	@Column(name = "name", nullable=false, unique = true)
	private String name;
	
	@Column(name = "description")
	private String description;
//
//	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
//	List<AdminUser> admins;

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
//
//	public List<AdminUser> getAdmins() {
//		return admins;
//	}
//
//	public void setAdmins(List<AdminUser> admins) {
//		this.admins = admins;
//	}
}
