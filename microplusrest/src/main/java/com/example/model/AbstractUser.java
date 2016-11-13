package com.example.model;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Abstract user, contains the shared properties of
 * {@link Client} and {@link AdminUser} entities
 * @author Angel Hermon
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractUser extends AbstractRecord {

	private static final long serialVersionUID = 2925106969881401843L;

    @Transient
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Column(name="first_name", nullable = true)
	protected String firstName;
	
	@Column(name="last_name", nullable = true)
	protected String lastName;
		
	@Column(name = "email", nullable=false, unique=true)
	@JsonProperty(value="email")
	protected String email;

	@Column(name="password")
	protected String password;
	
	@Column(name="email_verified")
	protected byte emailVerified;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public void setEmail(String email) {
		if (email == null) return;

		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	@JsonGetter("password")
	public String getBlankPassword() {
		return null;
	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	public void setPassword(String password) {
		if (password == null) return;

		this.password = encoder.encode(password);
	}

	public void copyPassword(String password) {
		this.password = password;
	}

	public byte getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(byte emailVerified) {
		this.emailVerified = emailVerified;
	}


}
