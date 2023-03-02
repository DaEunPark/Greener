<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>관리자 관리용 게시판 선택폼(메인)</title>
<!--  부트스트랩 5.2.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<script src="${contextPath}/resources/js/CSboard.js"></script>
 
</head>
<!-- 상단 메뉴 -->
<body>


<!-- 게시글 관리  -->
<div id="container">
	<div id = "pagetitle">
		
	</div>
</div>

</body>
</html>