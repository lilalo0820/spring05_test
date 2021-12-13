<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function message_write(){
		        var messageList = [];
		        
				$("table", "#form1").each(function() {
 					if($(this).find(".message").val() && $(this).find(".pointUserList").val()){
 						messageList.push(
							{
								"message" : $(this).find(".message").val(),
								"receive_id" : $(this).find(".pointUserList").val()
							}
 						);						
 					}
 				});
				
				if(messageList.length > 0){
					
// 					JSON 처리
	 		        $.ajax({
	 					url : "insert.do",
	 					data : JSON.stringify(messageList),
	 					type : "post",
	 					contentType : 'application/json',
	 					dataType : "json",
			            success: function(result){
			            	if(result.status == "T"){
		            			window.location = "list.do";
			            	}
			            },
			            error: function(error){
			            }
			        });
// 	 		       JSON 처리
				}
	}
	
	function add_template(){
		 $( '.template' ).clone().removeClass('template').appendTo( '#form1' );
	}
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>메시지 등록</h2>
		<form name="form1" method="post" id="form1" enctype="multipart/form-data">
			<table>
				<tr>
					<td>수신자</td>
					<td>
						<select class="pointUserList">
							<c:forEach items="${pointUserList}" var="row">
									<option value="${row.userid}">${row.userid}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>메시지</td>
					<td>
						<textarea rows="5" cols="60" name="message" class="message"></textarea>
					</td>
				</tr>
			</table>
		</form>
		
		<table>
			<tr>
				<td>
					<input type="button" value="등록" onclick="message_write();">
					<input type="button" value="추가" onclick="add_template();">
				</td>
			</tr>
		</table>
		
<!-- template -->
		<div style="display:none;">
			<table  class="template">
				<tr>
					<td>수신자</td>
					<td>
						<select class="pointUserList">
							<c:forEach items="${pointUserList}" var="row">
									<option value="${row.userid}">${row.userid}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>메시지</td>
					<td>
						<textarea rows="5" cols="60" name="message" class="message"></textarea>
					</td>
				</tr>
			</table>
		</div>
<!-- template -->
</body>
</html>