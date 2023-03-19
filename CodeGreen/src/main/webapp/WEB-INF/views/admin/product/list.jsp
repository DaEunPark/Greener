<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style>
.listWrap {
	width : 90%;
	margin : 0 auto;
}
.p_name{
	width : 250px;
}
</style>
</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="../include/nav.jsp"></jsp:include>
<div class="container">
<div class="listWrap">
	<h1 class="adminTitle">상품 관리 페이지</h1>
	<table class="table table-striped table-hover align-middle table-bordered">
	   	<thead class="table-dark">
	    	<tr class="text-center">
			    <th scope="col">번호</th>
			    <th scope="col">상품명</th>
			    <th scope="col">이미지</th>
			    <th scope="col">카테고리</th>
			    <th scope="col">가격</th>
			    <th scope="col">수량</th>
			    <th scope="col">유통기한</th>
				<th scope="col">판매자</th>
				<th scope="col">관리자</th>
	    	</tr>
	   	</thead>
   		<tbody class="table-group-divider"> 
    		<c:forEach items="${list}" var="list" > 
    		<tr >
		     	<td>${list.p_number}</td>
		     	<td class="p_name">
		     		<a href="/admin/product/view?n=${list.p_number}">${list.p_name}</a>
		     	</td>
		     	<td>
		     		<img src="${list.p_img}" style="width:100px; height:100px;">
		     	</td>
		     	<td>${list.c_name}</td>
		     	<td>${list.p_price}</td>
		     	<td>${list.p_stock}</td>
		     	<td>${list.p_usedate}</td>
		     	<td>${list.product_s_id}</td>
		     	<td>${list.product_m_id}</td>
    		</tr>     
    		</c:forEach>
   		</tbody>
	</table>
	
	<div class="inputArea">
	<button type="button" id="register_Btn" class="btn btn-primary"  style="float: right;" onclick="location.href='/admin/product/register'">상품 등록</button>
	</div>	
	</div>
</div>
</body>
</html>