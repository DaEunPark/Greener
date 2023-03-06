<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FAQ 수정</title>
	<!--  부트스트랩 5.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<!-- 제이쿼리 넣어주기 -->  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <!-- 부트스트랩 사이드바 css  -->
   <link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet">
	<script src="${contextPath}/resources/js/Eboard.js"></script>
</head>	
<body>
<!-- 상단 메뉴 -->


<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">FAQ 수정</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">제  목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" 	id="f_title" name="f_title" maxlength="200" value="${FaqDetail.f_title}" />
				<input type="hidden" class="form-control" id="f_no"  	 name="f_no"     value="${FaqDetail.f_no}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">카테고리</label>
		<select class="form-select form-select-sm" aria-label="Default select example" title="문의유형 선택" id="f_bc_code" name="f_bc_code" >
			  <option value="9">회원/멤버십</option>
			  <option value="10">주문/결제</option>
			  <option value="11">배송</option>
			  <option value="12">상품</option>
			  <option value="13">이벤트</option>	
		</select>
	 </div>
		<div class="form-group">
			<label for="regdate" class="col-sm-2 control-label">작성일자</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="f_regdate" name="f_regdate" value="<fmt:formatDate value='${FaqDetail.f_regdate}' pattern='yyyy년 MM월 dd일 a hh시 mm분 ss초'/>" readonly/>
			</div>
		</div>
		<!-- <div class="form-group">
			<label for="count" class="col-sm-2 control-label">조회수</label>
			<div class="col-sm-1">
				<input type="text" class="form-control" id="f_readcount" name="f_readcount" maxlength="4" value="${FaqDetail.f_readcount}" readonly/>
			</div>
		</div> -->
		<div class="form-group">
			<label for="writer" class="col-sm-2 control-label">관리자</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="f_m_id" name="f_m_id" maxlength="20" value="${FaqDetail.f_m_id}" />
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">내  용</label>
			<div class="col-sm-10">
				<textarea rows="10" cols="160" class="form-control" id="f_content" name="f_content" >${FaqDetail.f_content}</textarea>
			</div>
		</div>
		
		<div class="form-group">
			<p align="center">
				<button type="reset" class="btn btn-warning">
					<span class="glyphicon glyphicon-erase">다시 입력</span>
				</button>
				<button type="button" class="btn btn-danger" onclick="fn_FaqUpdate();">
					<span class="glyphicon glyphicon-pencil"> 게시글 수정</span>
				</button>
				<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/CS/board/FaqList?f_bc_code=0'">
					<span class="glyphicon glyphicon-list-alt"> 게시글 목록</span>
				</button>
		
			</p>
		</div>
		
		
	</form>
</div>	


</body>
</html>



