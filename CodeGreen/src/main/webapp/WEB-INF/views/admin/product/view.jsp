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
</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="../include/nav.jsp"></jsp:include>
	<div class="container">
		<h2>상품 상세</h2>
		<form role = "form" method="post" autocomplete="off">
		<input type = "hidden" name="n" value="${product.p_number}"/>
			<label>1차 분류</label>
			<span class="category1"></span>    
			<label>2차 분류</label>
			<span class="category2">${product.c_name}</span>    
			
			<div class="inputArea">
			 <label for="productNumber">상품번호</label>
			 <span>${product.p_number}</span>
			</div>
			
			<div class="inputArea">
			 <label for="productName">상품명</label>
			 <span>${product.p_name}</span>
			</div>
			
			<div class="inputArea">
			 <label for="productPrice">상품가격</label>
			 <span><fmt:formatNumber value="${product.p_price}" pattern="###,###,###"/></span>
			</div>
			
			<div class="inputArea">
			 <label for="productContent">상품소개</label>
			 <span>${product.p_content}</span>
			</div>
			
			<div class="inputArea">
			 <label for="purdocutImg">상품 이미지</label>
			 <p>원본 이미지</p>
			 <img src = "${product.p_img}" class="oriImg"/>

			 <p>썸네일</p>
			 <img src = "${product.p_thumbImg}" class="thumbImg"/>
			</div>
			
			<div class="inputArea">
			 <label for="productStock">상품수량</label>
			 <span>${product.p_stock}</span>
			</div>
			
			<div class="inputArea">
			 <label for="productMade">원산지</label>
			 <span>${product.p_made}</span>
			</div>
			
			<div class="inputArea">
			 <label for="productUsedate">유통/소비기한</label>
			 <span>${product.p_usedate}</span>
			</div>
			
			
			<div class="inputArea">
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