package it.cosenzproject.cmssample.core.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import it.cosenzproject.cmssample.core.security.filter.JwtRequestFilter;
import it.cosenzproject.cmssample.core.security.handler.JwtAuthenticationEntryPoint;

@EnableWebSecurity
//Viene utilizzato per abilitare la sicurezza a livello di metodo in base alle annotazioni. 
//Puoi utilizzare i seguenti tre tipi di annotazioni per proteggere i tuoi metodi:
@EnableGlobalMethodSecurity(
//      securedEnabled = true, // da mettere sopra il metodo del controller/service: @Secured("ROLE_ADMIN"), @Secured({"ROLE_USER", "ROLE_ADMIN"})
//      jsr250Enabled = true, // @RolesAllowed("ROLE_ADMIN")
        prePostEnabled = true // @PreAuthorize e @PostAuthorize es: @PreAuthorize("hasRole('USER')")
)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtRequestFilter jwtFilter;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors()
		// configurazione security per rotte
		// .authorizeRequests().antMatchers("/product", "/category/**", "/authenticate", "/comment").permitAll().and()  
		// La classe dell'oggetto unauthorizedHandler deve implementare l'interfacciaAuthenticationEntryPoint serve per restituire un errore 401
		.and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#authenticationManagerBean()
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
