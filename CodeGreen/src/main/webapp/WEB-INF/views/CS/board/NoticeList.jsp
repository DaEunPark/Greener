<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 관리</title>
	<!--  부트스트랩 5.3 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<!-- 제이쿼리 넣어주기 -->  
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <!-- 부트스트랩 사이드바 css  -->
	<link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet">
   <!-- 게시판관리 js 적용 -->
	<script src="${contextPath}/resources/js/Eboard.js"></script>
</head>
<body>
<!-- 사이드바 -->
<jsp:include page="../../admin/include/nav.jsp"></jsp:include>

<div class="container"  style="margin-right:120px; width: 70%" >
<!-- 상단 바  -->
<jsp:include page="../../common/CStopMenu.jsp"></jsp:include>		
		
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">공지사항 관리</h2>
			</div>
		</div>
		<!-- 게시글 쓰기/등록 버튼 -->
		<p align="center">
			<button type="button" class="btn btn-success" onclick="location.href='${contextPath}/CS/board/NoticeForm'">공지사항 작성</button>
		</p>
		
		<!-- 카테고리별 검색하기 --> 
		<div align="right">
		<select class="form-select right"  aria-label="Default select example" title="카테고리 선택" id="n_bc_code" name="n_bc_code" >
			  <option value="0" <c:if test="${n_bc_code == '0'}">selected</c:if>>전체</option>
			  <option value="4" <c:if test="${n_bc_code == '4'}">selected</c:if>>회원/멤버십</option>
			  <option value="5" <c:if test="${n_bc_code == '5'}">selected</c:if>>주문/결제</option>
			  <option value="6" <c:if test="${n_bc_code == '6'}">selected</c:if>>배송</option>
			  <option value="7" <c:if test="${n_bc_code == '7'}">selected</c:if>>상품</option>
			  <option value="8" <c:if test="${n_bc_code == '8'}">selected</c:if>>이벤트</option>
		</select>	
		<button type="submit" class="btn btn-success">조회</button>
		</div>
	
		<!-- 표  -->
		<table class="table table-borderd table-hover">  
			<thead>
				<tr class="info">
					<th class="col-sm-1 text-center">번호</th>
					<th class="col-sm-1 text-center">카테고리</th> 
					<th class="col-sm-1 text-center">관리자ID</th>
					<th class="col-sm-3 text-center">제목</th>
					<th class="col-sm-3 text-center">내용</th>
					<th class="col-sm-2 text-center">작성일자</th>
				</tr>
			</thead>
			
			
			<tbody>
				<c:forEach items="${NoticeList}" var="nolist">
				<tr>
					<td align="center">${nolist.n_no}</td>
				 <c:choose>
					<c:when test="${nolist.n_bc_code eq 4}">
						<td align="center">회원/멤버십</td>
					</c:when>
						<c:when test="${nolist.n_bc_code eq 5}">
						<td align="center">주문/결제</td>
					</c:when>
						<c:when test="${nolist.n_bc_code eq 6}">
						<td align="center">배송</td>
					</c:when>
						<c:when test="${nolist.n_bc_code eq 7}">
						<td align="center">상품</td>
					</c:when>
					<c:otherwise>	
						<td align="center">이벤트</td>
					</c:otherwise>
				</c:choose>
					<td align="center">${nolist.n_m_id}</td>
					<td align="center"><a href="${contextPath}/CS/board/NoticeDetail?n_no=${nolist.n_no}">${nolist.n_title}</a></td>
					<td align="center">${nolist.n_content }</td>
					<td><fmt:formatDate value="${nolist.n_regdate}" pattern="yyyy년 MM월 dd일"/></td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</form>
</div>
	
	
</body>
</html>