package it.cosenzproject.cmssample.app.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.cosenzproject.cmssample.common.model.viewmodel.AuthenticationRequest;
import it.cosenzproject.cmssample.common.model.viewmodel.AuthenticationResponse;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping(value = "/authenticate")
public interface AuthenticateApi {

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest authenticationRequest);
}
