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
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<title>정보 입력</title>
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
    		height: 440px;
    		border: 1.5px solid green;
    		border-radius: 10px;
    		margin: 0 auto 10px;
    		padding: 0;
    	}
    	.input-infos {
    		height: 55px;
    		border-bottom: 1px solid green;
    		list-style: none;
    		padding-top: 12px;
			padding-left: 14px;
    	}
    	.input-infos:last-child{
    		border: none;
    		padding-top: 11px;
    	}
    	label {
    		font-size: 14px;
    	}
    	input {
    		font-size: 14px;
    		border: none;
    		outline: none;
    		display: none;
    	}
    	#phone1, #phone2, #phone3 {
    		border: 1px solid black;
    		text-align: center;
    	}
    	#popup_kakao {
    		width: 40px;
    		height: 30px;
    		font-size: 12px;
    		font-weight: bold;
    		color: white;
    		background: green;
    		border: 1px solid green;
    		border-radius: 5px;
    	}
    	b {
    		color: darkgrey;
    		cursor: pointer;
    	}
    	.btn-zone {
    		width: 500px;
    		margin: 20px auto 30px;
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
    		width: 500px;
    		margin: 0 auto;
    		color: #999999;
    		font-size: 10px;
    	}
	</style>
	<script> // 제이쿼리
		$(function(){
			// id 입력
			$("label[id=id]").click(function(){
				$("label[id=id]").css("display", "none");
				$("#validity").css({"display":"none"});
				$("input[id=b_id]").css("display", "block").focus();
			});
			$("#b_id").blur(function(){
				if($("input[id=b_id]").val().length===0) {					
					$("label[id=id]").css("display", "block");
					$("input[id=b_id]").css("display", "none");
					$("#validity").css({"display":"block", "color":"red"}).text("ID를 입력해주세요.");
				}
				else {
					fn_idCheck_format(); // ID 형식 체크(ID 중복 여부 포함)
				}
			});
			
			// pw 입력
			$("label[id=pwd]").click(function(){
				$("label[id=pwd]").css("display", "none");
				$("#pw_result").css({"display":"none"});
				$("input[id=b_pwd]").css("display", "block").focus();
			});
			$("#b_pwd").blur(function(){  // 비밀번호 일치 확인 : 비밀번호 확인 과정까지 마친 후, 최초 설정한 비밀번호가 바뀌는 경우 대비
				if($("input[id=b_pwd]").val().length===0) {					
					$("label[id=pwd]").css("display", "block");
					$("input[id=b_pwd]").css("display", "none");
					$("#pw_result").css({"display":"block", "color":"red"}).text("비밀번호를 입력해주세요");
				}
				else {
					checkPassword( $('#b_pwd').val(), $('#b_id').val() );
					fn_compare_pwd();
				}
			});
			
			// pw 확인
			$("label[id=repwd]").click(function(){
				$("label[id=repwd]").css("display", "none");
				$("input[id=b_repwd]").css("display", "block").focus();
			});
			$("#b_repwd").blur(function(){  // 비밀번호 일치 확인
				fn_compare_pwd();
				if($("input[id=b_repwd]").val().length===0) {					
					$("label[id=repwd]").css("display", "block");
					$("input[id=b_repwd]").css("display", "none");
				}
			});
			
			// 이름 입력
			$("label[id=name]").click(function(){
				$("label[id=name]").css("display", "none");
				$("input[id=b_name]").css("display", "block").focus();
			});
			$("#b_name").blur(function(){
				if($("input[id=b_name]").val().length===0) {					
					$("label[id=name]").css("display", "block");
					$("input[id=b_name]").css("display", "none");
					$("#no_name").css({"display":"block", "color":"red"}).text("이름을 입력해주세요");
				}
				else {
					$("#no_name").css("display", "none");
					$("#no_name").css({"display":"block", "color":"blue"}).text("입력되었습니다.");
				}
			});
			
			// 생년월일 입력
			$("label[id=birth]").click(function(){
				$("label[id=birth]").css("display", "none");
				$("input[id=b_birth]").datepicker({maxDate: "-14y", minDate:"-100y"}).css("display", "block");
			});
			$.datepicker.setDefaults({
				changeYear:  true,
				changeMonth: true,
				dateFormat: "yy-mm-dd",
				monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
				dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
				showMonthAfterYear: "true",
				yearSuffix: '년',
			});
			$("#b_birth").blur(function(){
				if($("input[id=b_birth]").val().length===0) {			
					$("label[id=birth]").css("display", "block");
					$("input[id=b_birth]").css("display", "none");
					$("#born").css({"display":"block", "color":"red"}).text("생년월일을 선택해주세요");
				}
				else {
					$("label[id=birth]").css("display", "none");
					$("input[id=b_birth]").css("display", "block");
					$("#born").css({"display":"block", "color":"blue"}).text("입력되었습니다.");
				}
			});
			
			// 전화번호 입력
			$("label[id=phone]").click(function(){
				$("label[id=phone]").css("display", "none");
				$("#pnum").css({"display":"none"});
				$("input[id=phone1], input[id=phone2], input[id=phone3]").css("display", "block");
				$("#phone0").css("display", "flex");
				$("input[id=phone1]").focus();
			});
			$("#phone1, #phone2, #phone3").blur(function(){
				let $Len1 = $("#phone1").val().length, $Len2 = $("#phone2").val().length, $Len3 = $("#phone3").val().length;
				
				if($Len1+$Len2+$Len3 === 0){					
					$("label[id=phone]").css({"display":"block"});
					$("#pnum").css({"display":"block", "color":"red"}).text("연락처를 입력해주세요");
					$("input[id=phone1], input[id=phone2], input[id=phone3]").css("display", "none");
					$("#phone0").css("display", "none");
				}
				else if($Len1+$Len2+$Len3 === 11) {
					$("#pnum").css({"display":"block", "color":"blue"}).text("입력되었습니다.");
				}
				else {
					$("#pnum").css({"display":"block", "color":"red"}).text("연락처를 확인해주세요");
				}
			});
			
			// 이메일 입력
			$("label[id=email]").click(function(){
				$("label[id=email]").css("display", "none");
				$("select[id=b_email_selec]").css("display", "block");
				$("input[id=b_email]").css("display", "block").focus();
			});
			$("input[id=b_email]").blur(function(){
				if($("input[id=b_email]").val().length===0) {
					$("#email-check").css({"display":"block", "color":"red"}).text("email을 입력해주세요");
				}
				else if(!/^(?=.*[@])(?=.*[.])/.test($("input[id=b_email]").val())) {
					$("#email-check").css({"display":"block", "color":"red"}).text("email을 확인해주세요");
				}
				else {
					$("#email-check").css({"display":"block", "color":"blue"}).text("입력되었습니다.");
				}
			});
			
			// 배송지 입력 (카카오 주소 API 활용)
			$("label[id=address]").click(function(){
				$("label[id=address]").css("display", "none");
				$("#sample6_postcode").css("display", "block");
				$("#sample6_address").css("display", "block");
				$("#sample6_detailAddress").css("display", "block");
				$("#popup_kakao").css("display", "block");
        	});
			$("#sample6_detailAddress").blur(function(){
				if($("input[id=sample6_detailAddress]").val().length===0) {
					$("#address-check").css({"display":"block", "color":"red"}).text("상세주소를 입력해주세요");
				}
				else {
					$("#address-check").css({"display":"block", "color":"blue"}).text("입력되었습니다.");
				}
        	});
			
			// 전송 버튼
			$("button[class=agree]").click(function(){ fn_submit(); });
			
			
			// ------------------------------------------------------
			//                        함수 정리
			// ------------------------------------------------------
			function fn_idCheck_format() { // ID 형식 체크(by 시훈 리)
				if(!/^(?=.*[a-zA-Z])(?=.*[0-9]).{6,10}$/.test($('#b_id').val())){ 
				    $("#validity").css({"display":"block", "color":"red"}).text("입력값 확인해주세요 - 영어/숫자 포함한 6-10자");
				}
				else {
					fn_idCheck_duplication(); // ID 중복 확인
				}
			}
			
			function fn_idCheck_duplication() { // ID 중복 확인(by 민준 킴)
				$.ajax({
					url:		"/buyer/idCheck",
					type:		"post",
					dataType:	"json",
					data:		{"b_id" : $("#b_id").val()},
					success:
					function(data) {
						if(data == 1) {	// 입력한 아이디가 이미 존재하는 경우
							$("#validity").css({"display":"block", "color":"red"}).text("이미 사용 중인 ID입니다.");
						} else if(data == 0) { // 입력한 아이디가 존재하지 않는 경우
							$("#validity").css({"display":"block", "color":"blue"}).text("사용 가능한 아이디입니다.");
						}
					}
				});	
			}
			
			function checkPassword(b_pwd, b_id){ // 비밀번호 형식 확인(by 민준 킴)
				let $pw_result = $("#pw_result");
				
				if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/.test(b_pwd)){ 
				    $pw_result.css({"display":"block", "color":"red"}).text("영문자, 숫자, 특수문자 조합으로 8자리 이상 사용해야 합니다.");
				    $('#b_pwd').val('').focus();
				    return false;
				}
				if(/(\w)\1\1/.test(b_pwd)){
					$pw_result.css({"display":"block", "color":"red"}).text('같은 문자를 3번 이상 연속으로 사용하실 수 없습니다.');
				    $('#b_pwd').val('').focus();
				    return false;
				}
				if(b_pwd.search(b_id) > -1){
					if(b_id.length===0) {
						$pw_result.css({"display":"block", "color":"red"}).text("아이디부터 입력해주세요.");
					    $('#b_pwd').val('').focus();
					}
					else {						
						$pw_result.css({"display":"block", "color":"red"}).text("비밀번호에 아이디가 포함되었습니다.");
				    	$('#b_pwd').val('').focus();
					}
				    return false;
				}
				else {
					$pw_result.css({"display":"block", "color":"blue"}).text("사용 가능합니다.");
					return true;
				}
			}
			
			function fn_compare_pwd() { // 비밀번호 일치 여부 확인(by 민준 킴)
				const $pwd1 = $("#b_pwd").val();
				const $pwd2 = $("#b_repwd").val();
	
			    if($pwd1.length != 0 && $pwd2.length != 0 && $pwd1 === $pwd2) {
			    	$("#pw_equal").css({"display":"block", "color":"blue"}).text("비밀번호가 일치합니다.");
			    }
			    else if($pwd1.length != 0 && $pwd2.length != 0 && $pwd1 !== $pwd2) {
			    	$("#pw_equal").css({"display":"block", "color":"red"}).text("비밀번호가 일치하지 않습니다.");
			    }
			    else {
			    	$("#pw_equal").css({"display":"none"});
			    }
			}
			
			function fn_submit() { // 회원가입 정보 DB에 전송(by 시훈 리)
				$.ajax({
					url:      "/buyer/addBuyer",
					type:     "post",
					dataType: "json",
					data: {   "b_id"      : $("#b_id").val(),
							  "b_pwd"     : $("#b_pwd").val(),
							  "b_name"    : $("#b_name").val(),
							  "b_birth"   : $("#b_birth").val(),
							  "b_email"   : $("#b_email").val(),
							  "b_address1": $("#sample6_postcode").val(),
							  "b_address2": $("#sample6_address").val(),
							  "b_address3": $("#sample6_detailAddress").val(),
							  "b_phone"   : $("#phone1").val()+'-'+$("#phone2").val()+'-'+$("#phone3").val()
						  },
					success:
					function(data){
						if(data===1) {
							alert("회원가입 성공");
							location.href="/buyer/done";
						}
						else {
							alert("회원가입 실패");
						}
					}
				});
			}
		});
	</script>
	<script> // 자바스크립트
		function sample6_execDaumPostcode() { // 카카오 API 구현 (by 민준 킴)
			new daum.Postcode({
	    		oncomplete: function(data) {
	        		var addr = ''; // 주소 변수
	        		var extraAddr = ''; // 참고항목 변수
	
	        		if (data.userSelectedType === 'R') { addr = data.roadAddress; } // 사용자가 도로명 주소를 선택했을 경우
	        		else { addr = data.jibunAddress; } // 사용자가 지번 주소를 선택했을 경우(J)
	
	        		// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	        		if(data.userSelectedType === 'R'){
	            		// 법정동명이 있을 경우 추가한다(법정리는 제외) - 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	            		if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)) { extraAddr += data.bname; }
	            		// 건물명이 있고, 공동주택일 경우 추가한다.
	            		if(data.buildingName !== '' && data.apartment === 'Y') { extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName); }
	            		// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            		if(extraAddr !== '') { extraAddr = ' (' + extraAddr + ')'; }
	            		document.getElementById("sample6_extraAddress").value = extraAddr; // 조합된 참고항목을 해당 필드에 넣는다.
	       			} else {
	            		document.getElementById("sample6_extraAddress").value = '';
	        		}
	        		
	        		document.getElementById('sample6_postcode').value = data.zonecode;
	        		document.getElementById("sample6_address").value = addr;
	        		document.getElementById("sample6_detailAddress").focus();
	    		}
			}).open();
		}
	
		function select(target) { // 이메일 선택/입력
			const text = target.options[target.selectedIndex].text;
			document.querySelector("#b_email").value = text;
			document.querySelector("#b_email").focus();
		}
	</script>
</head>
<body>
	<!-- 헤더/푸터 따로 만들어서 관리 jsp:include ~ -->
	<header>
		<a href="http://localhost:8080/"><img src="${contextPath}/resources/images/green_icon.png" alt="logo"/></a>
	</header>
	<div class="container">
		<div class="progress">
  			<div class="progress-bar bg-success" role="progressbar" style="width: 75%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<h3>정보입력</h3>
		<h6>회원정보를 입력해주세요. 모두 입력하셔야 가입이 가능합니다.</h6>
		<form method="post" action="${contextPath}/buyer/done">
			<ul class="infos">
				<li class="input-infos">
					<label for="b_id" id="id"><b>ID를 만들어주세요 (영어/숫자 6-10자)</b></label><input type="text" id="b_id" name="b_id" maxlength="10"/>
					<p><span id="validity" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_pwd" id="pwd"><b>비밀번호 입력 (8-15자의 영문 대소문자, 숫자 또는 특수문자 조합)</b></label>
					<input type="password" id="b_pwd" name="b_pwd" maxlength="15" autocomplete="on"/>
					<p><span id="pw_result" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_repwd" id="repwd"><b>위의 비밀번호를 다시 입력해주세요</b></label>
					<input type="password" id="b_repwd" name="b_repwd" maxlength="15" autocomplete="on"/>
					<p><span id="pw_equal" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_name" id="name"><b>이름</b></label><input type="text" id="b_name" name="b_name" maxlength="10"/>
					<p><span id="no_name" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_birth" id="birth"><b>생년월일</b></label><input type="text" id="b_birth" name="b_birth"/>
					<p><span id="born" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label id="phone"><b>휴대전화 번호 입력</b></label>
					<p style="margin:0px;" id="phone0">
						<input type="text" id="phone1" name="b_phone" maxlength="3" style="width:50px;" 
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>&nbsp;
						<input type="text" id="phone2" name="b_phone" maxlength="4" style="width:60px;" 
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>&nbsp;
						<input type="text" id="phone3" name="b_phone" maxlength="4" style="width:60px;" 
						oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>
					</p>
					<p><span id="pnum" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_email" id="email"><b>이메일</b></label>
					<p id="b_email_p" style="display:flex; margin:0;">
						<input type="email" id="b_email" name="b_email" maxlength="100"/>
						<select id="b_email_selec" name="b_email" style="display:none;" onchange="select(this)">
      						<option selected="selected">직접입력</option>
      						<option>@naver.com</option>
      						<option>@daum.net</option>
      						<option>@nate.com</option>
      						<option>@gmail.com</option>
    					</select>
    				</p>
    				<p><span id="email-check" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label id="address"><b>배송지 주소 입력</b></label>
					<p id="location" style="display:flex; margin:0;">
						<input type="text" id="sample6_postcode" name="b_address1" placeholder="우편번호" style="width:60px; height:24px; display:none">
						<input type="text" id="sample6_address" name="b_address2" placeholder=" 주소" style="width:200px; height:24px; display:none">
						<input type="text" id="sample6_detailAddress" name="b_address3" placeholder="상세주소" style="width:150px; height:26px; display:none">
						<input type="text" id="sample6_extraAddress" placeholder="참고항목" style="display:none">
						<button type="button" id="popup_kakao" onclick="sample6_execDaumPostcode()" style="display:none">찾기</button>
					</p>
					<p><span id="address-check" style="font-size:7px; display:none"></span></p>
				</li>
			</ul>
			<div class="btn-zone">
				<div class="buttons">
					<a href="${contextPath}/buyer/signup"><button class="disagree">처음으로</button></a>
					<button type="submit" class="agree">확인</button>
				</div>
			</div>
		</form>
		<hr>
	</div>
	<footer>
		<p>Copyright © <strong style="color:green;">GreenMarket.Co.,LTD.</strong> All Rights Reserved.</p>
	</footer>
</body>
</html>
