<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/spring04/upload/input.do">업로드 테스트</a>
	
	<a href="/spring04/shop/product/list.do">상품목록</a>
	
	<a href="/spring04/messages/list.do">메시지</a>
		
	<br>
	
	<div style="text-align:right;">
		<c:choose>
			<c:when test="${sessionScope.userid == null }">
				<a href="/spring04/member/login.do">로그인</a>
				<a href="/spring04/admin/login.do">관리자 로그인</a>
			</c:when>
			<c:otherwise>
				${sessionScope.userid}님이 로그인중입니다.
				<a href="/spring04/member/logout.do">로그아웃</a>
				<a href="/spring04/admin/logout.do">관리자 로그아웃</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>