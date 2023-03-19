<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 상세</title>
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
<div class="container" >
	<form class="form-horizontal listWrap" id="frm">
		<div class="form-group">
			<div>
				<h2 class="adminTitle">공지사항 상세</h2>
			</div>
		</div>	
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label"><strong>제  목</strong></label>
			<div style="width:100%;">
				<input type="text" class="form-control" id="n_title" name="n_title" maxlength="200" value="${NoticeDetail.n_title}" readonly/>
			</div>
		</div>

		<div class="form-group">
			<label for="type" class="col-sm-2 control-label"><strong>카테고리</strong></label>
			<div style="width:100%;">
			 <c:choose>
			 	<c:when test="${NoticeDetail.n_bc_code eq 4}">
				<input type="text" class="form-control" id="n_bc_code" name="n_bc_code" maxlength="200" value="회원/멤버십" readonly/>
				</c:when>
				<c:when test="${NoticeDetail.n_bc_code eq 5}">
				<input type="text" class="form-control" id="n_bc_code" name="n_bc_code" maxlength="200" value="주문/결제" readonly/>
				</c:when>
				<c:when test="${NoticeDetail.n_bc_code eq 6}">
				<input type="text" class="form-control" id="n_bc_code" name="n_bc_code" maxlength="200" value="배송" readonly/>
				</c:when>
				<c:when test="${NoticeDetail.n_bc_code eq 7}">
				<input type="text" class="form-control" id="n_bc_code" name="n_bc_code" maxlength="200" value="상품" readonly/>
				</c:when>
				<c:otherwise>
				<input type="text" class="form-control" id="n_bc_code" name="n_bc_code" maxlength="200" value="이벤트" readonly/>
				</c:otherwise>
				</c:choose>
			</div>
		</div>

		
		<div class="form-group">
			<label for="reg_date" class="col-sm-2 control-label"><strong>작성일자</strong></label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="n_regdate" name="n_regdate" value="<fmt:formatDate value='${NoticeDetail.n_regdate}' pattern='yyyy년 MM월 dd일 a hh시 mm분 ss초'/>" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="writer" class="col-sm-2 control-label"><strong>관리자ID</strong></label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="n_m_id" name="n_m_id" maxlength="20" value="${NoticeDetail.n_m_id}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label"><strong>내  용</strong></label>
			<div style="width:100%;">
				<textarea rows="10" cols="160" class="form-control" id="n_content" name="n_content" readonly>${NoticeDetail.n_content}</textarea>
			</div>
		</div>
		
		<div class="form-group"  style="margin:20px;">
			<p align="center">
				<button type="button" class="btn btn-primary detail_btn" onclick="location.href='${contextPath}/CS/board/NoticeList?n_bc_code=0'">
					<span class="glyphicon glyphicon-list-alt"> 게시글 목록</span>
				</button>
				<button type="button" class="btn btn-warning detail_btn" onclick="fn_NoticeUpdateForm(${NoticeDetail.n_no})">
					<span class="glyphicon glyphicon-pencil"> 게시글 수정</span>
				</button>
				<button type="button" class="btn btn-danger detail_btn" onclick="fn_NoticeDelete(${NoticeDetail.n_no})">
					<span class="glyphicon glyphicon-erase"> 게시글 삭제</span>
				</button>
			</p>
		</div>
		
		
	</form>
</div>	
	


</body>
</html>