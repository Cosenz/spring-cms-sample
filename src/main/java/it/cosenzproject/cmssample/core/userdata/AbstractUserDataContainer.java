package it.cosenzproject.cmssample.core.userdata;

import org.springframework.security.core.userdetails.UserDetails;

public abstract class AbstractUserDataContainer<T extends UserDetails> {

	/**
	 * The user data.
	 */
	private T userDetails;

	/**
	 * Gets the user data type.
	 *
	 * @return the user data type
	 */
	public abstract Class<T> getUserDetailsType();

	/**
	 * Gets the user data.
	 *
	 * @return the user data
	 */
	public T getUserDetails() {
		return this.userDetails;
	}

	/**
	 * Cleans the container.
	 */
	public void clean() {
		this.userDetails = null;
	}

	/**
	 * Sets the user data.
	 *
	 * @param userData the new user data
	 */
	@SuppressWarnings("unchecked")
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = (T) userDetails;
	}

}
