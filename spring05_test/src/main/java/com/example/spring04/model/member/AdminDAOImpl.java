package com.example.spring04.model.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//관리자 로그인

@Repository 
public class AdminDAOImpl implements AdminDAO {
//	관리자 로그인
	@Inject
	SqlSession sqlSession;
	
	@Override
	public String login(MemberDTO dto) {
//		네임스페이스.테그아이디
		return sqlSession.selectOne("admin.login",dto);
	}
	
}
