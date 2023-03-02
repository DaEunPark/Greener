<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>  <!-- 시간 기호 관련 처리 -->
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 상세 정보</title>
<!--  <link rel="stylesheet" href="./css/CsFront.css"> -->
<!--  부트스트랩 5.2.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<script src="${contextPath}/resources/js/CSboard.js"></script>
	
	
</head>
<!-- <jsp :include page="../common/topMenu.jsp" flush="false"/>-->
<body>

<!-- 상단 사이드 바  -->
<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">게시글 상세 정보</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="m_title" class="col-sm-2 control-label">제  목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="m_title" name="m_title" maxlength="200" value="${CSboardDetail.m_title}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="m_type" class="col-sm-2 control-label">타  입</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="m_type" name="m_type" maxlength="200" value="${CSboardDetail.m_type}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="m_reg_date" class="col-sm-2 control-label">작성일자</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="m_reg_date" name="m_reg_date" value="<fmt:formatDate value='${CSboardDetail.m_reg_date}' pattern='yyyy년 MM월 dd일 a hh시 mm분 ss초'/>" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="m_readCount" class="col-sm-2 control-label">조회수</label>
			<div class="col-sm-1">
				<input type="text" class="form-control" id="m_readCount" name="m_readCount" maxlength="4" value="${CSboardDetail.m_readCount}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="m_writer" class="col-sm-2 control-label">작성자</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="m_writer" name="m_writer" maxlength="20" value="${CSboardDetail.m_writer}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="m_content" class="col-sm-2 control-label">내  용</label>
			<div class="col-sm-10">
				<textarea rows="10" cols="160" class="form-control" id="m_content" name="m_content" readonly>${CSboardDetail.m_content}</textarea>
			</div>
		</div>
		
		<div class="form-group">
			<p align="center">
				<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/CS/board/CSboardList'">
					<span class="glyphicon glyphicon-list-alt"> 게시글 목록</span>
				</button>
				<button type="button" class="btn btn-warning" onclick="fn_csboardUpdateForm(${CSboardDetail.m_bno})">
					<span class="glyphicon glyphicon-pencil"> 게시글 수정</span>
				</button>
				<button type="button" class="btn btn-danger" onclick="fn_csboardDelete(${CSboardDetail.m_bno})">
					<span class="glyphicon glyphicon-erase"> 게시글 삭제</span>
				</button>
			</p>
		</div>
		
		
	</form>
</div>	
	


</body>
</html>