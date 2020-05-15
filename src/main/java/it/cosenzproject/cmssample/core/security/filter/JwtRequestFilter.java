package it.cosenzproject.cmssample.core.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import it.cosenzproject.cmssample.core.security.service.JwtService;

@Component(JwtRequestFilter.BEAN_NAME)
public class JwtRequestFilter extends OncePerRequestFilter {

	public static final String BEAN_NAME = "it.cosenzproject.productsample.filter.JwtRequestFilter";

	@Value("${jwt.header}")
	private String jwtHeader;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {
		String username = null;
		String jwt = null;

		final String authorizationHeader = request.getHeader(jwtHeader);
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtService.extractUsername(jwt);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if (jwtService.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,
				        null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
