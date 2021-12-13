<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js">
</script>
<script>
	$(function(){
		$("#btnLogin").click(function(){
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
			if(userid=""){
				alert("아이디를 입력하세요.");
				return;
			}
			if(passwd=""){
				alert("비번을 입력하세요.");
				return;
			}
			document.form1.action = "/spring04/admin/login_check.do";
			document.form1.submit();
		});
	})
</script>
</head>
<!-- 관리자 로그인 -->
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>관리자 로그인</h2>
	<form name="form1" method="post">
		<table border="1" width="400px;">
			<tr>
				<td>아이디</td>
				<td><input id="userid" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="passwd" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">로그인</button>
					<c:if test="${message == 'error'}">
						<div style="color:red;">비밀번호 불일치</div>
					</c:if>
					<c:if test="${message == 'logout'}">
						<div style="color:red;">로그아웃</div>
					</c:if>
					<c:if test="${message == 'nologin'}">
						<div style="color:red;">로그인 필요</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>