package com.example.spring04.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect // 주석처리로 on and off 가능함
public class LogAdvice {

//	AOP 적용
	
	@Around("execution(* com.example.spring04.controller..*Controller.*(..))"
			+ " || execution(* com.example.spring04.service..*Impl.*(..))"
			+ " || execution(* com.example.spring04.model..*Impl.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		long start=System.currentTimeMillis();
		Object result = joinPoint.proceed();
		String type = joinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		if(type.indexOf("Controller") != -1) {
			name = "Controler\t";
		} else if(type.indexOf("Service") != -1) {
			name = "Service\t";
		} else if(type.indexOf("DAO") != -1) {
			name = "DAO\t";
		}
		System.out.println(name+type+"."+joinPoint.getSignature().getName() + "()");
		System.out.println(Arrays.toString(joinPoint.getArgs()));
		long end = System.currentTimeMillis();
		long time = end -start;
		System.out.println("실행시간:" + time);
		return result;
	}
	
}
