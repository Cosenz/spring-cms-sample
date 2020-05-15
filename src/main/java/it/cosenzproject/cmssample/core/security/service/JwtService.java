package it.cosenzproject.cmssample.core.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	public String extractUsername(String token);

	public String generateToken(UserDetails userDetails);

	public Boolean validateToken(String token, UserDetails userDetails);
}
