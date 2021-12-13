package com.example.spring04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 인터셉터 interceptor  

/*
필터 - url 기반 , 선처리 ( 인코딩 )
AOP - method 기반 before/around/after ( 로그 / 트랜젝션 )
인터셉터 - url 기반, 전후 ( 로그인 )
*/
public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	// URL 호출전 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin_userid") == null) {
			response.sendRedirect(request.getContextPath()+ "/admin/login.do?message=nologin");
			System.out.println(request.getContextPath() + " << request.getContextPath() value");
//			request.getContextPath() ->> /spring04
			return false;
		} 
		return true;	// true -> url 호출 진행
	}
	
	
	// URL 호출후 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("posthandler");
	}
	
	

}
