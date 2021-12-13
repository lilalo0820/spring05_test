<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 관리자 로그인 -->
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>관리자 로그인</h2>
	<c:if test="${message == 'success'}">
		${sessionScope.admin_name} (${sessionScope.admin_userid }) 님		
	</c:if>
</body>
</html>