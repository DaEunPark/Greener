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
	<script>
		$(function(){
			// id 입력
			$("label[id=id]").click(function(){
				$("label[id=id]").css("display", "none");
				$("input[id=b_id]").css("display", "block").focus();
			});
			$("#b_id").blur(function(){ // ID 중복 확인(by 민준 킴)
				fn_idCheck();
				if($("input[id=b_id]").val().length===0) {					
					$("label[id=id]").css("display", "block");
					$("input[id=b_id]").css("display", "none");
				}
			});
			
			// pw 입력
			$("label[id=pwd]").click(function(){
				$("label[id=pwd]").css("display", "none");
				$("input[id=b_pwd]").css("display", "block").focus();
			});
			$("#b_pwd").blur(function(){  // 비밀번호 일치 확인 : 비밀번호 확인 과정까지 마친 후, 최초에 설정한 비밀번호가 바뀌는 경우 대비
				fn_compare_pwd();
				if($("input[id=b_pwd]").val().length===0) {					
					$("label[id=pwd]").css("display", "block");
					$("input[id=b_pwd]").css("display", "none");
					$("#pw_empty").css({"display":"block", "color":"red"}).text("비밀번호를 입력해주세요");
				}
				else {
					$("#pw_empty").css({"display":"none"});
				}
			});
			
			
		/*	$("#b_pwd").change(function(){
				checkPassword($('#b_pwd').val(),$('b_id').val());
			});
			function checkPassword(b_pwd,b_id){
				var $b_pwd_result = $("#b_pwd_result");
				if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(b_pwd)){ 
				    	$b_pwd_result.text("숫자+영문자+특수문자 조합으로 8자리 이상 사용해야 합니다.");
				        $('#b_pwd').val('').focus();
				        return false;
				    }  else {
				    	$b_pwd_result.text("");
				    }
				    	
				var checkNumber = b_pwd.search(/[0-9]/g);
				var checkEnglish = b_pwd.search(/[a-z]/ig);
				if(checkNumber <0 || checkEnglish <0){
					$b_pwd_result.text("숫자와 영문자를 혼용하여야 합니다.");
				    $('#b_pwd').val('').focus();
				    return false;
				}
				if(/(\w)\1\1\1/.test(b_pwd)){
					$b_pwd_result.text('같은 문자를 4번 이상 사용하실 수 없습니다.');
				    $('#b_pwd').val('').focus();
				    return false;
				}
				if(b_pwd.search(id) > -1){
					$b_pwd_result.text("비밀번호에 아이디가 포함되었습니다.");
				    $('#b_pwd').val('').focus();
				    return false;
				}
				
				return true;
			} */
			
			
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
					$("#born").css("display", "none");
				}
			});
			
			// 전화번호 입력
			$("label[id=phone]").click(function(){
				$("label[id=phone]").css("display", "none");
				$("input[id=phone1], input[id=phone2], input[id=phone3]").css("display", "block");
				$("input[id=phone1]").focus();
			});
			$("#phone1").blur(function(){
				if($("input[id=phone1], input[id=phone2], input[id=phone3]").val().length===0){					
					$("label[id=phone]").css({"display":"block"});
					$("#phone0").css("display", "none");
					$("input[id=phone1], input[id=phone2], input[id=phone3]").css("display", "none");
					$("#pnum").css({"display":"block", "color":"red"}).text("연락처를 입력해주세요");
				}
				else if($("input[id=phone1]").val().length===3 && $("input[id=phone2], input[id=phone3]").val().length===4) {
					$("#pnum").css({"display":"none"});
				}
				else {
					$("#pnum").css({"display":"block", "color":"red"}).text("연락처를 다시 확인해주세요");
				}
			});
			
			// 이메일 입력
			$("label[id=email]").click(function(){
				$("label[id=email]").css("display", "none");
				$("select[id=b_email]").css("display", "block");
				$("input[id=b_email]").css("display", "block").focus();
			});
			
			// 배송지 입력 (카카오 주소 API 활용)
			$("label[id=address]").click(function(){
				$("label[id=address]").css("display", "none");
				$("#sample6_postcode").css("display", "block");
				$("#sample6_address").css("display", "block");
				$("#sample6_detailAddress").css("display", "block");
        	});
			
			// 전송
			$("button[class=agree]").click(function(){fn_submit();});
			
			// 함수 정리
			function fn_idCheck() { // ID 중복 확인
				$.ajax({
					url:		"/buyer/idCheck",
					type:		"post",
					dataType:	"json",
					data:		{"b_id" : $("#b_id").val()},
					success:
					function(data) {
						if(data == 1) {	// 입력한 아이디가 이미 존재하는 경우
							if($("#b_id").val()=='' && $("#b_id").val().length==0) {
								$("#validity").css({"display":"block", "color":"red"}).text("ID를 입력해주세요.");
							} else {
								$("#validity").css({"display":"block", "color":"red"}).text("이미 사용 중인 ID입니다.");
							}
						} else if(data == 0) { // 입력한 아이디가 존재하지 않는 경우
							$("#validity").css({"display":"block", "color":"blue"}).text("사용 가능한 아이디입니다.");
						}
					}
				});	
			}
			function fn_compare_pwd() { // 비밀번호 일치 여부 확인
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
			// 회원가입 정보 DB에 전송
			function fn_submit() {
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
	<script>
		function sample6_execDaumPostcode() {
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
	</script>
</head>
<body>
	<!-- 헤더 : 좌측에 회사 로고 이미지-->
	<header>
		<a href="http://localhost:8080/"><img src="${contextPath}/resources/images/green_icon.png" alt="logo"/></a>
	</header>
	<!-- 바디 -->
	<div class="container">
		<div class="progress">
  			<div class="progress-bar bg-success" role="progressbar" style="width: 75%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
		<h3>정보입력</h3>
		<h6>회원정보를 입력해주세요. 모두 입력하셔야 가입이 가능합니다.</h6>
		<form method="post" action="${contextPath}/buyer/done">
			<ul class="infos">
				<li class="input-infos">
					<label for="b_id" id="id"><b>ID를 만들어주세요</b></label><input type="text" id="b_id" name="b_id" maxlength="20"/>
					<p><span id="validity" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_pwd" id="pwd"><b>비밀번호 입력</b></label><input type="password" id="b_pwd" name="b_pwd" maxlength="20"/>
					<p><span id="pw_empty" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_repwd" id="repwd"><b>위의 비밀번호를 다시 입력해주세요</b></label><input type="password" id="b_repwd" name="b_repwd" maxlength="20"/>
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
					<p style="display:flex; margin:0px;" id="phone0">
						<input type="text" id="phone1" name="b_phone" maxlength="3" style="border:solid 1px black; width:50px; text-align:center;"/>&nbsp;
						<input type="text" id="phone2" name="b_phone" maxlength="4" style="border:solid 1px black; width:60px; text-align:center;"/>&nbsp;
						<input type="text" id="phone3" name="b_phone" maxlength="4" style="border:solid 1px black; width:60px; text-align:center;"/>
					</p>
					<p><span id="pnum" style="font-size:7px; display:none"></span></p>
				</li>
				<li class="input-infos">
					<label for="b_email" id="email"><b>이메일</b></label>
					<p id="b_email_p" style="display:flex;">
						<input type="email" id="b_email" name="b_email" maxlength="100"/>			
						<select id="b_email_selec" name="b_email" style="display:none;">
      						<option selected="selected">직접입력</option>
      						<option>@naver.com</option>
      						<option>@daum.net</option>
      						<option>@nate.com</option>
      						<option>@gmail.com</option>
    					</select>
    				</p>
				</li>
				<li class="input-infos">
					<label id="address"><b onclick="sample6_execDaumPostcode()">배송지 주소 입력</b></label>
					<p id="location" style="display:flex;">
						<input type="text" id="sample6_postcode" name="b_address1" placeholder="우편번호" style="width:50px; display:none">
						<input type="text" id="sample6_address" name="b_address2" placeholder="주소" style="text-align:center; width:250px; display:none">
						<input type="text" id="sample6_detailAddress" name="b_address3" placeholder="상세주소" style="width:100px; display:none">
						<input type="text" id="sample6_extraAddress" placeholder="참고항목" style="display:none">
					</p>
				</li>
			</ul>
			<div class="btn-zone">
				<div class="buttons">
					<a href="${contextPath}/buyer/signin"><button class="disagree">처음으로</button></a>
					<button type="submit" class="agree">확인</button>
				</div>
			</div>
		</form>
		<hr>
	</div>
	<!-- 푸터 : 상호명 -->
	<footer>
		<p>Copyright © <strong style="color:green;">GreenMarket.Co.,LTD.</strong> All Rights Reserved.</p>
	</footer>
</body>
</html>
