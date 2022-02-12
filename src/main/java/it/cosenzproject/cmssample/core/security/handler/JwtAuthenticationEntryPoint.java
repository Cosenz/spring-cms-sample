package it.cosenzproject.cmssample.core.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component(JwtAuthenticationEntryPoint.BEAN_NAME)
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.core.security.handler.JwtAuthenticationEntryPoint";

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	        throws IOException, ServletException {
		LOGGER.error("Responding with unauthorized error. Message - {0}", authException);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

	}

}
