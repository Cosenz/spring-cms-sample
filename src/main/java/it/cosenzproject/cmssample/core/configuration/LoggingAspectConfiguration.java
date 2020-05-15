package it.cosenzproject.cmssample.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.cosenzproject.cmssample.core.logging.LoggingControllerAspect;

@Configuration
public class LoggingAspectConfiguration {

	@Bean
	public LoggingControllerAspect loggingControllerAspect() {
		return new LoggingControllerAspect();
	}
}
