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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<title>사업자 판매회원 가입</title>
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
    	p {
    		display: flex;
    		align-items: center;
    		justify-content: center;
    		margin: 0;
    	}
    	.button {
    		width: 300px;
    		height: 50px;
    		font-size: 16px;
    		font-weight: bold;
    		border-radius: 10px;
    	}
    	.buyer {
    		background: green;
    		color: white;
    		border: 1px solid green;
    		margin: 10px auto;
    	}
    	.seller {
    		background: none;
    		border: 1px solid darkgrey;
    		margin: 10px auto;
    	}
    	.add_btns {
    		align-items: center;
    		justify-content: space-between;
    		width: 300px;
    		margin: 0 auto;
    	}
    	.private {
    		background: none;
    		border: 1px solid darkgrey;
    	}
    	.private:hover {
			color: green;
    	}
    	.corporation {
    		background: none;
    		border: 1px solid darkgrey;
    	}
    	.corporation:hover {
			color: green;
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
	</style>
	<script>
		window.onload = function(){
			document.getElementById("sellers").addEventListener("click", function(){
				const btns = document.getElementById("btns");
				if(btns.style.display == 'none') { btns.style.display = "flex"; }
				else { btns.style.display = "none"; }
			});
		};
	</script>
</head>
<body>
	<!-- 헤더/푸터 따로 만들어서 관리 jsp:include ~ -->
	<header>
		<a href="http://localhost:8080/"><img src="${contextPath}/resources/images/green_icon.png" alt="logo"/></a>
	</header>
	<div class="container">
		<div class="progress">
  			<div class="progress-bar bg-success" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<h3>사업자 판매회원 가입</h3>
		<h6>사업자 번호 입력</h6>
		<p><input type='text' placeholder="사업자등록번호" style="text-align:center;"></p>
		<hr>
	</div>
	<footer>
		<p>Copyright © <strong style="color:green;">GreenMarket.Co.,LTD.</strong> All Rights Reserved.</p>
	</footer>
</body>
</html>
