package it.cosenzproject.cmssample.core.logging;

import org.aspectj.lang.ProceedingJoinPoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLoggingAspect.class);

	protected Object logInvoked(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		String signature = joinPoint.getSignature().toShortString();
		LOGGER.info(String.format("START - %s", signature));

		result = joinPoint.proceed();

		LOGGER.info(String.format("END - %s, result: %s", signature, convertString(result)));

		return result;
	}

	private Object convertString(Object result) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error during converter ResponseEntity to JSON, {0}", e);
		}
		return jsonString;
	}
}
