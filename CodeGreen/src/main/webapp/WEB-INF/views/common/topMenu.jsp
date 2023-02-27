<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	

<%
/*
	sticky-top 은 상단 공간을 차지하면서 위에 고정하고,
	fixed-top  은 상단 공간을 차지하지 않고 위에 고정한다.
		일부 내용은 상단 메뉴바에 가려져서 보이지 않을 수가 있다.
*/
%>

<nav class="navbar navbar-inverse navbar-sticky-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextPath}/main.do">홈페이지</a>
		</div>
	
		<!-- 실질적인 메뉴를 나열한다. -->
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-left">
				<li>
					<form class="navbar-form navbar-left" method="post" action="${contextPath}/buyer/login.do">
						<c:choose>
							<c:when test="${isLogOn == true && buyer != null}">
								<p class="navbar-text"><b>${buyer.b_name}님, 즐거운 시간되십시요.</b></p>
								<a href="${contextPath}/buyer/logout.do" class="btn btn-danger">
									<span class="glyphicon glyphicon-log-out"></span> 로그아웃</a>
							</c:when>
							<c:otherwise>
								<div class="form-group">
									<input type="text"		class="form-control" name="b_id"  size="12" maxlength="20" placeholder="아이디"/>
									<input type="password"	class="form-control" name="b_pwd" size="12" maxlength="20" placeholder="비밀번호"/>
								</div>
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-log-in"></span> 로그인
								</button>
							</c:otherwise>
						</c:choose>
					</form>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${contextPath}/buyer/loginForm.do">로그인</a></li>
						<li><a href="${contextPath}/buyer/buyerForm.do">회원가입</a></li>
					</ul>
				</li>
				
			</ul>
		</div>
	
	</div>
</nav>