<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 전체 목록</title>

<!--  부트스트랩 5.2.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<script src="${contextPath}/resources/js/CSboard.js"></script>
 
</head>
<!-- <jsp :include page="../common/topMenu.jsp" flush="false"/>-->
<body>


<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">공지사항 게시글 목록 보여주기</h2>
			</div>
		</div>
		<!-- 게시글 쓰기 버튼 -->
		<p align="center">
			<button type="button" class="btn btn-primary" onclick="location.href='/CS/board/CSboardForm'">공지사항쓰기</button>
		</p>
		<!-- 표  -->
		<table class="table table-borderd table-striped table-hover">  <!-- 선, 굵기, 호버 -->
			<thead>
				<tr class="info"> <!-- 테이블모양확인용으로 사용됨 -->
					<th class="col-sm-1 text-center">번호</th>
					<th class="col-sm-1 text-center">관리자</th>
					<th class="col-sm-1 text-center">타입설정</th>
					<th class="col-sm-3 text-center">제목</th>
					<th class="col-sm-3 text-center">내용</th>
					<th class="col-sm-2 text-center">작성일자</th>
					<th class="col-sm-1 text-center">조회수</th>
				</tr>
			</thead>
			
			<!-- 데이터 한건에 대해 tr로 작업 ; 반복 대비 //< % 형태로 for문을 사용해도됨-->
			<tbody>
				<c:forEach items="${CSboardList}" var="infolist">
				<tr>
					<td align="center">${infolist.m_bno}</td>
					<td align="center">${infolist.m_writer}</td>
					<td align="center">${infolist.m_type}</td>
					<!--  아직 상세조회 목록 만들지 않음 -->
					<td><a href="${contextPath }/CS/board/CSboardDetail?m_bno=${infolist.m_bno}&flag=0">${infolist.m_title}</a></td>
					<td>${infolist.m_content }</td>
					<td><fmt:formatDate value="${infolist.m_reg_date}" pattern="yyyy년 MM월 dd일 a hh시 mm분 ss초"/></td>
					<td align="right">${infolist.m_readCount}</td>
				</tr>
				</c:forEach>
			</tbody>
			
			
		</table>
		
	</form>
</div>
	
	
	
	
	
	
</body>
</html>