<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	iframe {
		width:400px; height: 200px; border: 1px; border-style: solid;
	}

</style>

</head>
<body>
	<%@ include file="../include/menu.jsp" %>
<!-- 	파일업로드 관련 -->
<!-- 	enctype="multipart/form-data" -->
	<form action="/spring04/upload/upload.do" method="post" enctype="multipart/form-data" target="iframe1">
		<input type="file" name="fileContent">
		<input type="submit" value="업로드">
	</form>
	<iframe name="iframe1"></iframe>
</body>
</html>