<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="../include/nav.jsp"></jsp:include>
<div class="container">
	<h1 class="text-center">상품 관리 페이지</h1>
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
    <c:forEach items="${list}" var="list">
    <tr>
     <td>${list.p_number}</td>
     <td>
     	<a href="/admin/product/view?n=${list.p_number}">${list.p_name}</a>
     </td>
     <td>
     	<img src="${list.p_thumbImg}">
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
</div>
</body>
</html>