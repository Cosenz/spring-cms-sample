package it.cosenzproject.cmssample.core.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractLoggingAspect {

	public final Logger logger = Logger.getLogger(getClass());

	protected Object logInvoked(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		String signature = joinPoint.getSignature().toShortString();
		this.logger.info(String.format("START - %s", signature));

		result = joinPoint.proceed();

		this.logger.info(String.format("END - %s, result: %s", signature, convertString(result)));

		return result;
	}

	private Object convertString(Object result) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			this.logger.error("Error during converter ResponseEntity to JSON, {}", e);
		}
		return jsonString;
	}
}
