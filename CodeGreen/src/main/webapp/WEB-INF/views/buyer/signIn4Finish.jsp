<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<title>가입 완료</title>
	<style>
		header {
			width: 100%;
			height: 100px;
			border-bottom: 1px grey solid;
			display: flex;
			align-items: center;
		}
		img {
			width: 120px;
			height: 90px;
			margin-left: 10px;
		}
    	.container {
    		width: 100%;
    		min-width: 1200px;
    		max-width: 1200px;
    		height: 740px;
    		align-items: center;
    	}
    	.progress {
    		width: 500px;
    		margin: 18px auto;
    	}
    	h3 {
    		text-align: center;
    		margin-top: 24px;
    		margin-bottom: 12px;
    	}
    	h6 {
    		text-align: center;
    		margin-top: 14px;
    		margin-bottom: 52px;
    	}
    	.infos {
    		width: 500px;
    		height: 350px;
    		border: 1.5px solid green;
    		border-radius: 10px;
    		margin: 0 auto 10px;
    		padding-top: 10px;
    		padding-left: 20px;
    	}
    	p {
    		display: flex;
    		align-items: center;
    		justify-content: center;
    		margin: 0;
    	}
    	.button {
    		width: 300px;
    		height: 50px;
    		border-radius: 10px;
    	}
    	.toLogin {
    		background: green;
    		color: white;
    		font-size: 16px;
    		font-weight: bold;
    		border: 1px solid green;
    		margin: 10px auto;
    	}
    	.toMain {
    		background: none;
    		font-size: 16px;
    		font-weight: bold;
    		border: 1px solid darkgrey;
    		margin: 10px auto;
    	}
    	hr {
    		width: 500px;
    		border: 1px darkgrey solid;
    		margin: 20px auto;
    	}
    	footer {
			width: 100%;
			height: 100px;
			display: flex;
    		align-items: center;
    		justify-content: center;
			border-top: 1px grey solid;
			background: #f2f2f2;
			margin:0;
    	}
    	footer p {
    		display: flex;
    		align-items: center;
    		justify-content: center;
    		margin: 0;
    	}
	</style>
</head>
<body>
	<!-- 헤더 : 좌측에 회사 로고 이미지-->
	<header>
		<a href="http://localhost:8080/"><img src="${contextPath}/resources/images/green_icon.png" alt="logo"/></a>
	</header>
	<!-- 바디 -->
	<div class="container">
		<div class="progress">
  			<div class="progress-bar bg-success" role="progressbar" style="width: 100%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<h3>가입완료</h3>
		<h6>초록마켓의 회원이 되신 것을 환영합니다.</h6>
		<p><a href="http://localhost:8080/login"><button class="button toLogin">로그인 페이지로 이동</button></a></p>
		<p><a href="http://localhost:8080/"><button class="button toMain">메인 페이지로 이동</button></a></p>
		<hr>
	</div>
	<!-- 푸터 : 상호명 -->
	<footer>
		<p>Copyright © <strong style="color:green;">GreenMarket.Co.,LTD.</strong> All Rights Reserved.</p>
	</footer>
</body>
</html>
