package it.cosenzproject.cmssample.core.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingControllerAspect extends AbstractLoggingAspect {

	@Around("execution(* it.cosenzproject.cmssample.*.controller..*.*(..))")
	public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
		return logInvoked(joinPoint);
	}

	@Around("execution(* it.cosenzproject.cmssample.*.service.provider..*.*(..))")
	public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
		return logInvoked(joinPoint);
	}

}
