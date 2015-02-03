package com.github.ethan0w.sjblog.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * method run time
 * @author hy
 *
 */
@Aspect
@Component
public class ExecutionTimeService {
	
	Logger logger = LoggerFactory.getLogger(ExecutionTimeService.class);
	
	@Around("execution(* com.github.ethan0w.sjblog.persist.*.*(..))")
	public Object printRunTime(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = jp.proceed();
		logger.info(jp.toShortString() + " run time:" + (System.currentTimeMillis() - start ) + " ms");
		return result;
	}
}
