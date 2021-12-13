package com.example.spring04.model.message;

import java.util.List;

//AOP 적용  트랜젝션
public interface MessageDAO {
	void create(MessageDTO dto);
	List<MessageDTO> list(String userid);
	List<PointUserDTO> pointUserList();
	void insertMessageList(List<MessageDTO> dto);
}
