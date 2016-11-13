package com.example.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

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
	@JoinColumn(name = "role_id")
    private Role role;

    @Getter(name = "role")
    public Role getRole() {
        return role;
    }

    @Setter
    public void setRole(Role role) {
        this.role = role;
    }

    //
//	@Transient
//	public Role getRole() {
//		return role;
//	}

}
