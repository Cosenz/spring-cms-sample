package it.cosenzproject.cmssample.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import it.cosenzproject.cmssample.common.userdata.AppUserDataContainer;
import it.cosenzproject.cmssample.core.userdata.AbstractUserDataContainer;

@Configuration
public class UserDataConfiguration {

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public AbstractUserDataContainer<?> userDataContainer() {
		return new AppUserDataContainer();
	}
}
