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
		$("#message_write").click(function(){
			window.location = "/messages/write.do";
		});
	})
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>Message</h2>
		<table>
			<c:if test="${list == null}">
				<tr> <td colspan="5">메시지 없음 ....</td></tr>
			</c:if>
			<c:forEach items="${list}" var="row">
				<tr>
					<td>${row.idx}</td>
					<td>${row.receive_id}</td>
					<td>${row.sender}</td>
					<td>${row.message}</td>
					<td>${row.send_date} <button onclick="">[삭제]</button></td>
				</tr>
			</c:forEach>
			<tr> <td colspan="5"><button id="message_write">
				<a href="/spring04/messages/write.do">메시지 작성</a>
			</button></td></tr>
		</table>
</body>
</html>