package it.cosenzproject.cmssample.common.model.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {

	@JsonProperty("token")
	private String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
