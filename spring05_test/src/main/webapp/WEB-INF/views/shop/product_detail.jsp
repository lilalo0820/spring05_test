<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function product_update(){
		var product_code=document.form1.product_code.value;
		var product_name=document.form1.product_name.value;
		var price=document.form1.price.value;
		var description=document.form1.description.value;
		if(product_name ==  "" || price ==  "" || description ==  "" ){
			alert("입력값확인");
			return;
		}
		document.form1.action="/spring04/shop/product/edit.do";
		document.form1.submit();
	}
	function product_delete(){
		document.form1.action="/spring04/shop/product/delete.do";
		document.form1.submit();
	}
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>상품 정보 수정/삭제</h2>
		
			<table>
				<tr>
					<td>상품명</td>
					<td>
						<input name="product_name" value=${dto.product_name}>
					</td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input name="price" value=${dto.price}></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td>
						<textarea rows="5" cols="60" name="description" id="description">${dto.description}</textarea>
					</td>
				</tr>
				<tr>
					<td>상품이미지<img src="/spring04/images/${dto.filename}" style="width:100px; height:100px;"></td>
					<td><input type="file" name="file1"></td>
				</tr>
				<tr>
					<td colspan="2">
						<form name="form1" method="post" action="/spring04/shop/cart/insert.do">
							<input type="hidden" name="product_code" value=${dto.product_code}>
							<select name="amount">
								<c:forEach begin="1" end="10" var="i">
									<option value="${i}">${i}</option>
								</c:forEach>
							</select>
							<input type="submit" value="장바구니에 담기">
						</form>
						<a href="/spring04/shop/product/list.do">상품목록</a>
					</td>
				</tr>
			</table>
</body>
</html>