package it.cosenzproject.cmssample.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import it.cosenzproject.cmssample.app.api.AuthenticateApi;
import it.cosenzproject.cmssample.common.model.viewmodel.AuthenticationRequest;
import it.cosenzproject.cmssample.common.model.viewmodel.AuthenticationResponse;
import it.cosenzproject.cmssample.core.security.service.JwtService;

@RestController
public class AuthenticateController implements AuthenticateApi {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Override
	public ResponseEntity<AuthenticationResponse> authenticate(@Valid AuthenticationRequest authenticationRequest) {
		Authentication authentication = null;
		try {
			authentication = authenticationManager.authenticate(
			        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (AuthenticationException e) {
			System.out.println("Incorrect username e password: " + e);
			return new ResponseEntity<AuthenticationResponse>(HttpStatus.UNAUTHORIZED);
		}

		final String jwt = jwtService.generateToken((UserDetails) authentication.getPrincipal());
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
