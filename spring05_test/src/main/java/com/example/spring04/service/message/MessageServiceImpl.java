package com.example.spring04.service.message;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring04.model.message.MessageDAO;
import com.example.spring04.model.message.MessageDTO;
import com.example.spring04.model.message.PointDAO;

//AOP 적용  트랜젝션 
@Repository
public class MessageServiceImpl implements MessageService
{
	
	@Inject
	MessageDAO messageDao;
	
	@Inject
	PointDAO pointDao;	

	@Transactional
	@Override 
	public void insertMessage(MessageDTO dto) {
 		messageDao.create(dto);
 		
// 		exception 터뜨려서 테스트 함 > exception 터지고 위의 메시지 등록 안되었음
// 		String[] exceptionInvokerArrary = {};
// 		System.out.println(exceptionInvokerArrary[0]);
 		
 		pointDao.updatePoint(dto.getSender(), 10);
	}
	
}
