<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 카트 update 수정 case2 [] 객체 배열로 처리 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-3.6.0.min.js">
</script>
<script>
	$(function(){
		$("#btnList").click(function(){
			location.href="/spring04/shop/cart/list.do";
		});
		$("#btnDelete").click(function(){
			location.href="/spring04/shop/cart/deleteAll.do";
// 			참고
// 			/spring04/shop/cart/deleteAll.do -> /spring04/shop/cart/deleteAll.do (O)
// 			deleteAll.do -> 					/spring04/shop/cart/deleteAll.do (O)
		});		
		
// 		카트 update 수정 case2 객체로[] 배열로 처리 
//		$("#btnUpdate").click(function(){
// 			private int cart_id;
// 			private String userid;	// 다른 테이블과 join select 할 필드도 추가 테이블 생성시 FK로 지정되었음
// 			private String name;	// 다른 테이블과 join select 할 필드도 추가	테이블 생성시 FK로 지정되었음
// 			private int product_code;	// 다른 테이블과 join select 할 필드도 추가 테이블 생성시 FK로 지정되었음
// 			private String product_name;	// 다른 테이블과 join select 할 필드도 추가 테이블 생성시 FK로 지정되었음
// 			private int price;
// 			private int money;
// 			private int amount;
// 			var testObject = 
// 							[
// 								{
// 									cart_id:1,
// 									userid:"userid",
// 									name:"name",
// 									product_code:2,
// 									product_name:"product_name",
// 									price:3
									
// 								}
// 							];
// 			$("#testObject").val(JSON.stringify(testObject));
//			location.href="/spring04/shop/cart/update.do";
// 			참고
// 			/spring04/shop/cart/deleteAll.do -> /spring04/shop/cart/deleteAll.do (O)
// 			deleteAll.do -> 					/spring04/shop/cart/deleteAll.do (O)
		});	
	})
</script>

</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>장바구니</h2>
	
<!-- 	카트 update 수정 case1 int[] 배열로 처리  -->
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${map.counter == 0}"> --%>
<!-- 			장바구니가 비었습니다. -->
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<!-- 			<form id="form1" name="form1" method="post" action="/spring04/shop/cart/update.do"> -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 						<th>상품명</th> -->
<!-- 						<th>단가</th> -->
<!-- 						<th>수량</th> -->
<!-- 						<th>금액</th> -->
<!-- 						<th></th>					 -->
<!-- 					</tr> -->
<%-- 					<c:forEach items="${map.list}" var="row"> --%>
<!-- 						<tr> -->
<%-- 							<td>${row.product_name}</td> --%>
<%-- 							<td>${row.price}</td> --%>
<!-- 							<td> -->
<%-- 								<input type="number" style="width:30px;" min="0" max="100" name="amount" value="${row.amount}"> --%>
<%-- 								<input type="hidden" name="cart_id" value="${row.cart_id}"> --%>
<!-- 							</td> -->
<%-- 							<td>${row.money}</td> --%>
<!-- 							<td> -->
<%-- 								<a href="/spring04/shop/cart/delete.do?cart_id=${row.cart_id}">삭제</a> --%>
<!-- 							</td> -->
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
<!-- 					<tr> -->
<!-- 						<td colspan="5" align="center"> -->
<!-- 							장바구니 금액 합계 -->
<%-- 							${map.sumMoney} --%>
<%-- 							배송료: ${map.fee} --%>
<%-- 							총합계: ${map.sum} --%>
							
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</table>				 -->
<!-- 				<button type="submit" id="btnUpdate">수정</button>  -->
<!-- 				<button id="btnDelete">장바구니 비우기</button> -->
<!-- 				<button id="btnList">목록</button> -->
<!-- 			</form> -->
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
<!-- 카트 update 수정 case1 int[] 배열로 처리 -->
	<c:choose>
		<c:when test="${map.counter == 0}">
			장바구니가 비었습니다.
		</c:when>
		<c:otherwise>
			<form:form id="form1" name="form1" method="post" action="/spring04/shop/cart/update.do" modelAttribute="cartList">
				<table>
					<tr>
						<th>상품명</th>
						<th>단가</th>
						<th>수량</th>
						<th>금액</th>
						<th></th>					
					</tr>
					<c:forEach items="${map.list}" var="row" varStatus="status">>
						<tr>
							<td>${row.product_name}</td>
							<td>${row.price}</td>
							<td>
								
<%-- 								<td><input name="contacts[${status.index}].firstname" value="${contact.firstname}"/></td> --%>
								
								<input type="number" style="width:30px;" min="0" max="100" name="carts[${status.index}].amount" value="${row.amount}">
								<input type="hidden" name="carts[${status.index}].cart_id" value="${row.cart_id}">
							</td>
							<td>${row.money}</td>
							<td>
								<a href="/spring04/shop/cart/delete.do?cart_id=${row.cart_id}">삭제</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="center">
							장바구니 금액 합계
							${map.sumMoney}
							배송료: ${map.fee}
							총합계: ${map.sum}
							
						</td>
					</tr>
				</table>				
				<button type="submit" id="btnUpdate">수정</button> 
				<button id="btnDelete">장바구니 비우기</button>
				<button id="btnList">목록</button>
			</form:form>
		</c:otherwise>
	</c:choose>
</body>
</html>