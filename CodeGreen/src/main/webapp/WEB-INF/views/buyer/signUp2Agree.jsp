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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<title>약관 동의</title>
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
    	.check {
    		width: 500px;
    		height: 350px;
    		border: 1.5px solid green;
    		border-radius: 10px;
    		margin: 0 auto 10px;
    		padding-top: 10px;
    		padding-left: 20px;
    	}
    	#agree-all {
    		font-size: 22px;
    	}
    	.check div {
    		margin: 10px auto;
    	}
    	.check input {
    		margin-right: 16px;
    	}
    	.check label {
    		font-size: 18px;
    	}
    	.check span {
    		margin-right: 20px;
    		font-size: 16px;
    		color: darkgrey;
    	}
    	.check a {
    		font-size: 14px;
    		color: darkgrey;
    	}
    	#hr-top {
    		width: 460px;
    		border: 1px darkgrey solid;
    		margin: 10px 0;
    	}
    	p {
    		width: 500px;
    		margin: 0 auto;
    		color: #999999;
    		font-size: 10px;
    	}
    	.btn-zone {
    		width: 500px;
    		margin: 30px auto 40px;
    	}
    	.buttons {
    		width: 360px;
    		margin: 0 auto;
    	}
    	.disagree {
    		width: 100px;
    		height: 60px;
    		border-radius: 5px;
    		background: none;
    		font-weight: bold;
			border: 1px solid darkgrey;
    	}
    	.agree {
    		width: 250px;
    		height: 60px;
    		border-radius: 5px;
    		background: green;
    		color: white;
    		font-weight: bold;
    		border: 1px solid green;
    	}
    	#hr-bottom {
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
	<script>
		$(function(){
			$("button[class=agree]").prop("disabled", true).css({"background":"darkgrey", "border":"1px solid darkgrey"});
			
			// 1. (필수)항목들을 체크하지 않으면 '동의하고 회원가입' 버튼 비활성화			
			const $checkboxes = $(".check");
			$checkboxes.change(function(){
				let $checkedboxes = $(".necessary:checked").length;
				if ($checkedboxes == $(".necessary").length) {
					$("button[class=agree]").prop("disabled", false).css({"background":"green", "border":"1px solid green"});
				}
				else {
					$("button[class=agree]").prop("disabled", true).css({"background":"darkgrey", "border":"1px solid darkgrey"});
				}
			});
			
			// 2. '전체동의'에 체크하면 아래 항목들 모두 체크됨 / '전체동의' 체크해제 하면 아래 항목들 모두 체크 해제
			$("input:checkbox[id=agree-all]").change(function(){
				if ($(this).is(":checked")) { $("input:checkbox").prop("checked", true); }
			    else                        { $("input:checkbox").prop("checked", false); }
			});
			
			// 3. 2.의 '전체동의' 후 하나라도 체크가 해제되면, '전체동의 해제'
			$checkboxes.change(function(){
				if ($("input:checkbox:checked").length != $("input:checkbox").length) {
					$("input:checkbox[id=agree-all]").prop("checked", false);
				}
			});
		});
	</script>
</head>
<body>
	<!-- 헤더/푸터 따로 만들어서 관리 jsp:include ~ -->
	<header>
		<a href="http://localhost:8080/"><img src="${contextPath}/resources/images/green_icon.png" alt="logo"/></a>
	</header>
	<div class="container">
		<div class="progress">
  			<div class="progress-bar bg-success" role="progressbar" style="width: 50%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<h3>약관동의</h3>
		<h6>초록마켓 구매회원/전자금융서비스 이용약관과 개인정보<br>수집 및 이용에 동의를 하셔야 회원가입이 가능합니다.</h6>
		<div class="check">
			<div><input type="checkbox" id="agree-all" name="agree-all">
				<label id="agree-all">전체동의</label>
			</div>
			<hr id="hr-top">
			<div><input type="checkbox" class="necessary">
				<label>초록마켓 구매회원 이용약관<span>&nbsp;(필수)</span><a href="#">약관 전체보기</a></label>
			</div>
			<div><input type="checkbox" class="necessary">
				<label>전자금융서비스 이용약관<span>&nbsp;(필수)</span><a href="#">약관 전체보기</a></label>
			</div>
			<div><input type="checkbox" class="necessary">
				<label>개인정보 수집 및 이용<span>&nbsp;(필수)</span><a href="#">내용보기</a></label>
			</div>
			<div><input type="checkbox" class="necessary">
				<label>만 14세 이상입니다<span>&nbsp;(필수)</span></label>
			</div>
			<div><input type="checkbox">
				<label>개인정보 제3자 제공동의<span>&nbsp;(선택)</span><a href="#">내용보기</a></label>
			</div>
			<div><input type="checkbox">
				<label>개인정보 수집 및 이용<span>&nbsp;(선택)</span><a href="#">내용보기</a></label>
			</div>
			<div><input type="checkbox">
				<label>혜택 알림 이메일, 문자, 앱 푸시<span>&nbsp;(선택)</span></label>
			</div>
		</div>
		<p>＊고객은 동의를 거부할 권리가 있으며 동의를 거부할 경우, 사이트 가입 또는 일부 서비스 이용이 제한됩니다.</p>
		<div class="btn-zone">
			<div class="buttons">
				<a href="${contextPath}/buyer/signup"><button class="disagree">처음으로</button></a>
				<a href="${contextPath}/buyer/Info"><button class="agree">동의하고 회원가입</button></a>
			</div>
		</div>
		<hr id="hr-bottom">
	</div>
	<footer>
		<p>Copyright © <strong style="color:green;">GreenMarket.Co.,LTD.</strong> All Rights Reserved.</p>
	</footer>
</body>
</html>
