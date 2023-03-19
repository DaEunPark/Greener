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
			<style>
	.listWrap {
	width : 90%;
	margin : 0 auto;
}
	th, td{
	text-align:center; vertical-align: middle;
	}
		.detail_btn{
	margin : 10px;
	}
		.form-group{
	margin: 20px 0;
	}
</style>
</head>	
<body>
<!-- 사이드바 -->
<jsp:include page="../../admin/include/nav.jsp"></jsp:include>

<!-- 상단 바  -->
<jsp:include page="../../common/CStopMenu.jsp"></jsp:include>		
<div class="container">
	<form class="form-horizontal listWrap" id="frm">
			<div>
				<h2 class="adminTitle">FAQ 수정</h2>
			</div>
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label"><strong>제  목</strong></label>
			<div style="width:100%;">
				<input type="text" class="form-control" 	id="f_title" name="f_title" maxlength="200" value="${FaqDetail.f_title}" />
				<input type="hidden" class="form-control" id="f_no"  	 name="f_no"     value="${FaqDetail.f_no}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"><strong>카테고리</strong></label>
		<select class="form-select form-select-sm" style="width:100%;"aria-label="Default select example" title="카테고리 선택" id="f_bc_code" name="f_bc_code" >
			  <option value="9">회원/멤버십</option>
			  <option value="10">주문/결제</option>
			  <option value="11">배송</option>
			  <option value="12">상품</option>
			  <option value="13">이벤트</option>	
		</select>
	 </div>
		<div class="form-group">
			<label for="regdate" class="col-sm-2 control-label"><strong>작성일자</strong></label>
			<div style="width:100%;">
				<input type="text" class="form-control" id="f_regdate" name="f_regdate" value="<fmt:formatDate value='${FaqDetail.f_regdate}' pattern='yyyy년 MM월 dd일 a hh시 mm분 ss초'/>" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="writer" class="col-sm-2 control-label"><strong>관리자ID</strong></label>
			<div style="width:100%;">
				<input type="text" class="form-control" id="f_m_id" name="f_m_id" maxlength="20" value="${FaqDetail.f_m_id}" />
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label"><strong>내  용</strong></label>
			<div style="width:100%;">
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
