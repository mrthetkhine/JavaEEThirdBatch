package com.javaeethirdbatch.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
	
	//@Before("execution(* com.javaeethirdbatch.service.MovieServiceImpl.getAllMovie(..))")
	@Before("execution(* com.javaeethirdbatch.service.*.*(..))")
	public void logBeforeMethodCall(JoinPoint joinPoint)
	{
		String className = joinPoint.getTarget().getClass().getSimpleName();
	    String methodName = joinPoint.getSignature().getName();

	    //String argumentName = joinPoint.getArgs()[0].toString();

	    log.info("Logging Aspect Before Executing {} with argument: {}", 
	            className+"." + methodName +"()");
	    
		
	}
	@After("execution(* com.javaeethirdbatch.service.*.*(..))")
	public void logAfterMethodCall()
	{
		log.info("Logging Aspect After");
	}
	@After("execution(* com.javaeethirdbatch.controller.rest.*.*(..))")
	public void logAfterController()
	{
		log.info("Logging Aspect After Contoller");
	}
}
