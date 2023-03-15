<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 작성</title>
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
<!-- 사이드바 -->
<jsp:include page="../../admin/include/nav.jsp"></jsp:include>

<div class="container"  style="margin-right:120px; width: 70%" >
<!-- 상단 바  -->
<jsp:include page="../../common/CStopMenu.jsp"></jsp:include>		
	<form class="form-horizontal" name="NoticeForm">
	<input type="hidden" value="${NoticeForm.n_no}" name="n_no" id="n_no">
	<input type="hidden" value="${NoticeForm.n_regdate}" name="n_regdate" id="n_regdate">
	<input type="hidden" value="${NoticeForm.n_readcount}" name="n_readcount" id="n_readcount">
		<div class="form-group">
			<div class="col-sm-12">
				<h2 align="center">공지사항 작성</h2>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>제  목</strong></label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="n_title" name="n_title" maxlength="200" placeholder="제목 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>관리자ID</strong></label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="n_m_id" name="n_m_id" maxlength="20" placeholder="관리자ID"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>카테고리</strong></label>
		<select class="form-select form-select-sm" aria-label="Default select example" title="카테고리선택" id="n_bc_code" name="n_bc_code" >
			  <option value="4">회원/멤버십</option>
			  <option value="5">주문/결제</option>
			  <option value="6">배송</option>
			  <option value="7">상품</option>
			  <option value="8">이벤트</option>	
		</select>
	 </div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>내  용</strong></label>
			<div class="col-sm-8">
				<textarea class="form-control" id="n_content" name="n_content" rows="10" cols="160"  placeholder="내용 입력"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 left">
				<button type="reset"  class="btn btn-warning">다시 입력</button>
				<button type="button" class="btn btn-primary" onclick="fn_NoticeUpForm()">등록</button>	
			</div>
		</div>	
	</form>
</div>


</body>
</html>




 

  
