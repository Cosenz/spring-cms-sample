package it.cosenzproject.cmssample.app.entity;

import javax.persistence.Entity;

import it.cosenzproject.cmssample.core.entity.AppEntity;
import it.cosenzproject.cmssample.core.entity.BaseEntity;

@Entity
public class User extends BaseEntity implements AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4825587392461933410L;

	private String username;
	private String password;
	private boolean active;
	private String roles;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

}
