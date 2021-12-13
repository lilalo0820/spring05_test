package com.example.spring04.model.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
//AOP 적용  트랜젝션
@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	SqlSession sqlSession;
	
	
	@Override
	public void create(MessageDTO dto) {
		sqlSession.insert("message.create",dto);
	}

	@Override
	public List<MessageDTO> list(String userid) {
		return sqlSession.selectList("message.list",userid);
	}

	@Override
	public List<PointUserDTO> pointUserList() {
		return sqlSession.selectList("message.pointUserList");
	}
	
	@Override
	public void insertMessageList(List<MessageDTO> messageList) {
		Map<String,Object> map =  new HashMap<String,Object>() ;
		map.put("messageList",messageList);
		sqlSession.insert("message.insertMessageList",map);
	}

}
