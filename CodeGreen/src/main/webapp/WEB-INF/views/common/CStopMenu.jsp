<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 코어식 준비 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<% request.setCharacterEncoding("UTF-8"); %>
	<!--  부트스트랩 5.3 적용 -->
<!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script> -->
<!--    <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/> -->
	<!-- 제이쿼리 넣어주기 -->  
<!--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
   <!-- 부트스트랩 사이드바 css  -->
<!--    <link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet"> -->
	<script src="${contextPath}/resources/js/Eboard.js"></script>
	
	
	
		<div class="form-group-bar">
			<p align="right">
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='${contextPath}/CS/board/NoticeList?n_bc_code=0'">
					<span>공지사항 관리</span>
				</button>
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='${contextPath }/CS/board/FaqList?f_bc_code=0'">
					<span> FAQ 관리</span>
				</button>
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='${contextPath }/CS/board/InquiryList?i_bc_code=0'">
					<span> 1:1 문의 관리</span>
				</button>
			</p>
		</div>
			
			
			
			
			
			