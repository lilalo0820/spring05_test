<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<br>
<!-- 맴버 로그인 -->
<%@ include file="include/menu.jsp" %>

	<c:if test="${sessionScope.userid != null}">
		${sessionScope.userid} (${sessionScope.name }) 님 환영합니다	
	</c:if>

</body>
</html>
