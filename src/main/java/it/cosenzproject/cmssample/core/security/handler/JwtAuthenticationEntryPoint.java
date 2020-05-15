package it.cosenzproject.cmssample.core.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component(JwtAuthenticationEntryPoint.BEAN_NAME)
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.core.security.handler.JwtAuthenticationEntryPoint";

	private static final Logger LOGGER = Logger.getLogger(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	        throws IOException, ServletException {
		LOGGER.error("Responding with unauthorized error. Message - {}", authException);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

	}

}
