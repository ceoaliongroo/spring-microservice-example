package com.example.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
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

    @Transient
    public Role getAccess() {
        return this.role;
    }

    @JsonSetter
    public void setRole(Role role) {
        this.role = role;
    }

}
