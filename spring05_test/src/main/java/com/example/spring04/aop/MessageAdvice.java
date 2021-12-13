package com.example.spring04.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MessageAdvice {
	@Before("execution(* com.example.spring04.service.message.MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("class:" + jp.getSignature());
		System.out.println("method:" + jp.getSignature().getName());
		System.out.println("args:" + Arrays.deepToString(jp.getArgs()));
	}
	
	@Around("execution(* com.example.spring04.service.message.MessageService*.*(..))")
	public Object startLog(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = pjp.proceed();
		long end = System.currentTimeMillis();
		long time = end - start;
		System.out.println(pjp.getSignature().getName() + ":" + (end-start));
		return result;
	}
}
