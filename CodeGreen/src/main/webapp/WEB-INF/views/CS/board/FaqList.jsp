<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FAQ 전체 목록 FaqList </title>
	<!--  부트스트랩 5.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<!-- 제이쿼리 넣어주기 -->  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <!-- 부트스트랩 사이드바 css  -->
   <link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet">
	<script src="${contextPath}/resources/js/Eboard.js"></script>
</head>
<!-- 상단바 자리 -->
<body>


<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">FAQ 전체 목록</h2>
			</div>
		</div>
		<!-- 게시글 쓰기/등록 버튼 -->
		<p align="center">
			<button type="button" class="btn btn-primary" onclick="location.href='/CS/board/FaqForm'">FAQ쓰기</button>
		</p>
		<!-- 표  -->
		<table class="table table-borderd table-striped table-hover">  <!-- 선, 굵기, 호버 -->
			<thead>
				<tr class="info"> <!-- 테이블모양확인용으로 사용됨 -->
					<th class="col-sm-1 text-center">번호</th>
					<th class="col-sm-1 text-center">카테고리</th> 
					<th class="col-sm-1 text-center">관리자</th>
					<th class="col-sm-3 text-center">제목</th>
					<th class="col-sm-3 text-center">내용</th>
					<th class="col-sm-2 text-center">작성일자</th>
					<th class="col-sm-1 text-center">조회수</th>
				</tr>
			</thead>
			
			<!-- 데이터 한건에 대해 tr로 작업 ; 반복 대비 //< % 형태로 for문을 사용해도됨-->
			<tbody>
				<c:forEach items="${FaqList}" var="falist">
				<tr>
					<td align="center">${falist.f_no}</td>
					<!-- 하위설정값은 등록에서 정해줬으면 코드번호로 나오니까 가능할지도 -->
				    <td align="center">${falist.f_bc_code}</td>
					<td align="center">${falist.f_m_id}</td>
					<!--  아직 상세조회 목록 만들지 않음 -->
					<td align="center"><a href="${contextPath}/CS/board/FaqDetail?f_no=${falist.f_no}">${falist.f_title}</a></td>
					<td align="center">${falist.f_content }</td>
					<td><fmt:formatDate value="${falist.f_regdate}" pattern="yyyy년 MM월 dd일 a hh시 mm분 ss초"/></td>
					<td align="right">${falist.f_readcount}</td>
				</tr>
				</c:forEach>
			</tbody>
			
			
		</table>
		
	</form>
</div>
	
	
</body>
</html>