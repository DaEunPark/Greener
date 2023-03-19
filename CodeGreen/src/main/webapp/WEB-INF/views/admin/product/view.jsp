<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link href="../../resources/css/admin/product.css" rel="stylesheet">
	<style type="text/css">
		#table1 {
		font-size:	15px;
		width: 100%;
		margin : 0;
		border-collapse: collapse;
	}
	table tr th {
		padding:	10px 10px;
		border-bottom:	dotted black 0.5px;
		border-right:	dotted black 0.5px;
	}
	table tr td {
		padding:	0px 30px;
		border-bottom:	dotted black 0.5px;
	}
		.listWrap {
	width : 90%;
	margin : 0 auto;
}
.inputArea_btn{
display:flex;
justify-content:right;
}
.btn{
margin:10px 5px 10px 0;
}
	</style>

</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="../include/nav.jsp"></jsp:include>
	<div class="container">
		<h2 class="adminTitle">상품 상세</h2>
		<form role = "form" method="post" autocomplete="off" class="listWrap">
		<input type = "hidden" name="n" value="${product.p_number}"/>
		<table id = "table1">  
		<tr>
			<th>상품 분류</th>
			<td class="category2">${product.c_name}</td>   
			</tr> 
			
			<tr class="inputArea">
			 <th>상품번호</th>
			 <td>${product.p_number}</td>
			</tr>
			
			<tr class="inputArea">
			 <th>상품명</th>
			 <td>${product.p_name}</td>
			</tr>
			
			<tr class="inputArea">
			 <th>상품가격</th>
			 <td><fmt:formatNumber value="${product.p_price}" pattern="###,###,###"/></td>
			</tr>
			
			<tr class="inputArea">
			 <th>상품소개</th>
			 <td>${product.p_content}</td>
			</tr>
			
			<tr class="inputArea">
			 <th>상품 이미지</th>
			 <td><img src = "${product.p_img}" class="oriImg"/></td>
			</tr>
			
			<tr class="inputArea">
			 <th>상품수량</th>
			 <td>${product.p_stock}</td>
			</tr>
			
			<tr class="inputArea">
			 <th>원산지</th>
			 <td>${product.p_made}</td>
			</tr>
			
			<tr class="inputArea">
			 <th>유통/소비기한</th>
			 <td>${product.p_usedate}</td>
			</tr>
			
			
			</table>
			<div class="inputArea_btn listWrap">
				<button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
				<button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>

				<script>
					var formObj = $("form[role='form']");
					  
					$("#modify_Btn").click(function(){
						formObj.attr("action", "/admin/product/modify");
						formObj.attr("method", "get")
						formObj.submit();
					});
					  
					$("#delete_Btn").click(function(){
						
						var con = confirm("해당 상품을 삭제하시겠습니까?");
						
						if(con){
							formObj.attr("action", "/admin/product/delete");
							formObj.submit();
						}
						
					});
				</script>
			</div>
		</form>
	</div>
	

</body>
</html>