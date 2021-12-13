package com.example.spring04.service.message;

import java.util.List;

import com.example.spring04.model.message.MessageDTO;
//AOP 적용  트랜젝션
public interface MessageService {
	void insertMessage(MessageDTO dto);
}
