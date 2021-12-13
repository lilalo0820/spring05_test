package com.example.spring04.controller.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring04.model.message.MessageDAO;
import com.example.spring04.model.message.MessageDTO;
import com.example.spring04.model.message.PointUserDTO;
import com.example.spring04.service.message.MessageService;
//AOP 적용  트랜젝션 
@RestController // 페이지뿐만 아니라 데이터도 return 가능하도록 수정
@RequestMapping("/messages/*")
public class MessageController {
	@Inject
	MessageService service;
	
	@Inject 
	MessageDAO dao;
	
//	ResponseEntity : 데이터 + 상태코드
//	@RequestBody  : json 형태의 데이터 받음 [JSON 처리]
//	테스트는 CHROME의 Advanced REST Client 로 진행함
	@RequestMapping("/")
	public ResponseEntity<String> addMessage(@RequestBody MessageDTO dto){
		ResponseEntity<String> entity = null;
		try {
			service.insertMessage(dto);
			entity = new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav){
		String userid =(String)session.getAttribute("userid");
		
		List<MessageDTO> list = new ArrayList<MessageDTO>();
		if(userid != null ) {
			list = dao.list(userid);
		}
		mav.setViewName("/message/message_list");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("write.do")
	public ModelAndView write(ModelAndView mav) {
		List<PointUserDTO> pointUserList = new ArrayList<PointUserDTO>();
		pointUserList = dao.pointUserList();
		mav.setViewName("message/message_write");
		mav.addObject("pointUserList",pointUserList);
		return mav;
	}
	
//	@RequestBody  : json 형태의 데이터 받음 [JSON 처리]
	@RequestMapping("insert.do")
	public Map<String,Object> insert(ModelAndView mav, @RequestBody List<MessageDTO> messageList ,HttpSession session) {
		ResponseEntity<String> entity = null;
		String userid = (String)session.getAttribute("userid");
		int rows;
		
		if(messageList != null) {
	       for (int i = 0; i < messageList.size(); i++) {
	    	   messageList.get(i).setSender(userid);
            }
		}
		Map<String,Object> map =  new HashMap<String,Object>() ;
		try {
			dao.insertMessageList(messageList);
			map.put("status","T");
		} catch (Exception e) {
			map.put("status","F");
			e.printStackTrace();
		}
		return map;
	}
	
	
}
