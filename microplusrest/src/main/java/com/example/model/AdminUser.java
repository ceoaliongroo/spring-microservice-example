package com.example.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Admin user entity.
 * Represents an admin-panel app user.
 *
 * @author Angel Hermon
 */
@Entity
@Table(name="admin_users")
public class AdminUser  extends AbstractUser {
	private static final long serialVersionUID = 5598157695509290938L;

	@ManyToOne
	private Role role;

	@Transient
	public Role getRole() {
		return role;
	}

}
