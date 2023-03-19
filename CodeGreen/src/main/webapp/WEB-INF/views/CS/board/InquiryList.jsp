<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>1:1 문의 관리</title>
	<!--  부트스트랩 5.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<!-- 제이쿼리 넣어주기 -->  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <!-- 부트스트랩 사이드바 css  -->
   <link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet">
   <!-- 게시판관리 js 적용 -->
	<script src="${contextPath}/resources/js/Eboard.js"></script>
		<style>
	.listWrap {
	width : 90%;
	margin : 0 auto;
}
	th, td{
	text-align:center; vertical-align: middle;
	}
</style>
</head>

<body>
<!-- 사이드바 -->
<jsp:include page="../../admin/include/nav.jsp"></jsp:include>

<!-- 상단 바  -->
<jsp:include page="../../common/CStopMenu.jsp"></jsp:include>		
<div class="container" >
	<form class="form-horizontal listWrap" id="frm">
		<div class="form-group">
			<div>
				<h2 class="adminTitle">1:1 문의 관리</h2>
			</div>
		</div>
		
		<!-- 카테고리별 검색하기 --> 
		<div align="left" style="display:flex; width:100%; margin-bottom:20px; justify-content:space-between;">
		<div style="display:flex; justify-content:row;">
		<select class="form-select right"  style="width:200px; margin-right:10px;" aria-label="Default select example" title="문의유형 선택" id="i_bc_code" name="i_bc_code" >
		  <option value="0" <c:if test="${i_bc_code == '0'}">selected</c:if>>전체</option>
			  <option value="14" <c:if test="${i_bc_code == '14'}">selected</c:if>>회원/멤버십</option>
			  <option value="15" <c:if test="${i_bc_code == '15'}">selected</c:if>>주문/결제</option>
			  <option value="16" <c:if test="${i_bc_code == '16'}">selected</c:if>>배송</option>
			  <option value="17" <c:if test="${i_bc_code == '17'}">selected</c:if>>상품</option>
			  <option value="18" <c:if test="${i_bc_code == '18'}">selected</c:if>>이벤트</option>
		</select>	
		<button type="submit" class="btn btn-success">조회</button>
		</div>
		</div>
		
		<!-- 표  -->
		<table class="table table-striped table-hover align-middle table-bordered" style="border-spacing:0;">
	   	<thead class="table-dark" style="text-align:center; vertical-align: middle;">
				<tr class="info"> 
					<th class="col-sm-1 text-center">번호</th>
					<th class="col-sm-1 text-center">카테고리</th> 
					<th class="col-sm-2 text-center">제목</th>
					<th class="col-sm-2 text-center">작성자ID</th>
					<th class="col-sm-3 text-center">문의내용</th>
					<th class="col-sm-2 text-center">문의일자</th>
						<th class="col-sm-2 text-center">답변여부</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${InquiryList}" var="inlist">
				<tr>
		
					<td align="center">${inlist.i_no}</td>
				 <c:choose>
					<c:when test="${inlist.i_bc_code eq 14}">
						<td align="center">회원/멤버십</td>
					</c:when>
						<c:when test="${inlist.i_bc_code eq 15}">
						<td align="center">주문/결제</td>
					</c:when>
						<c:when test="${inlist.i_bc_code eq 16}">
						<td align="center">배송</td>
					</c:when>
						<c:when test="${inlist.i_bc_code eq 17}">
						<td align="center">상품</td>
					</c:when>
					<c:otherwise>	
						<td align="center">이벤트</td>
					</c:otherwise>
				</c:choose>
					<td align="center">${inlist.i_title}</td>
					<!--  소비자ID 클릭시 답변창 -->
					<td align="center"><a href="${contextPath}/CS/board/InquiryDetail?i_no=${inlist.i_no}">${inlist.i_b_id}</a></td>
					<td align="center">${inlist.i_content }</td>
					<td><fmt:formatDate value="${inlist.i_regdate}" pattern="yyyy년 MM월 dd일"/></td>
					<c:choose>
					<c:when test="${inlist.i_answer eq 0}">
						<td align="center">N</td>
						</c:when>
						<c:otherwise>	
						<td align="center" >Y</td>
						</c:otherwise>
					</c:choose>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</form>
</div>
	
	
</body>
</html>