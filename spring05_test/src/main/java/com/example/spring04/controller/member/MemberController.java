package com.example.spring04.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring04.model.member.MemberDAO;
import com.example.spring04.model.member.MemberDTO;

//맴버 로그인

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberDAO memberDAO;
	
	@RequestMapping("address.do")
	public String address() {
		return "member/join";
	}
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
//	public ModelAndView login_check(@ModelAttribute MemberDTO dto, HttpSession session) {
//	@ModelAttribute는 생략 가능
	public ModelAndView login_check(MemberDTO dto, HttpSession session) {
		
		String name = memberDAO.login(dto);
		
		if(name != null) {
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
		}
		ModelAndView mav = new ModelAndView();
		
		if(name != null) {
			mav.setViewName("main");
		} else {
			mav.setViewName("member/login");
			mav.addObject("message","error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView login_check(HttpSession session, ModelAndView mav) {
		session.invalidate();
		mav.setViewName("member/login");
		mav.addObject("message","logout");
		return mav;
		
	}
	
}
