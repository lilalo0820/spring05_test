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
	
	<table>
		<c:forEach items="${list}" var="row">
			<tr>
				<td>${row.product_code}</td>
<!-- 			상품이미지 url -->
				<td><img src="/spring04/images/${row.filename}" style="width:100px;height:100px;"></td>
				<td>
					<c:if test="${sessionScope.admin_userid != null}">
						<a href="/spring04/shop/product/edit/${row.product_code}">[편집]</a>
					</c:if>
						<a href="/spring04/shop/product/detail/${row.product_code}">[상세]</a>
				</td>
				<td>${row.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>