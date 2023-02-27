<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="result"		 value="${param.result}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>

<!-- 로그인 여부 체크 -->
<c:choose>
	<c:when test="${result == 'loginIdEmpty'}">
		<script>
		window.onload = function() {
			alert("\n아이디를 입력하셔야 합니다.");
		}
		</script>
	</c:when>
	<c:when test="${result == 'loginFailed'}">
		<script>
		window.onload = function() {
			alert("\n아이디를 잘못입력하셨습니다.\n\n다시 로그인을 해주십시오.");
		}
		</script>
	</c:when>
	<c:when test="${result == 'PasswordFailed'}">
		<script>
		window.onload = function() {
			alert("\n비밀번호를 잘못입력하셨습니다.\n\n다시 로그인을 해주십시오.");
		}
		</script>
	</c:when>
</c:choose>

<style>
  .main {
    width:60%;
    margin: 100px auto;
    align-items: center;
  }
  img {
    display: block;
    width: 200px;
    height: 100px;
    padding:0;
    margin:0 auto;
    margin-bottom: 20px;
  }
  .contents {
    height: 550px;
    border: 2px solid lightgray;
    border-radius: 20px;
    padding-left:6px;
    padding-top:15px;
  }
  .login {
    display: inline-block;
    border: 1px solid white;
    height: 450px;
    width: 48%;
    padding-top:40px;
    margin:10px 3px;
  }
  .partition {
    display: inline-block;
    height: 500px;
    border: 1px solid lightgray;
    margin: 0;
    padding: 0;
  }
  table {
    width:300px;
    padding:0;
    margin:0 auto;
  }
  tr {
    height: 60px;
    width: 100%;
    padding:0px;
    text-align: center;
    padding: 10px auto 0;
  }
  td {
    padding:0;
    text-align: center;
  }
  #id, #pw {
    font-size:16px;
    width: 85%;
    height: 35px;
  }
  .options {
    text-align: left;
    padding: 0 15px 10px;
  }
  #submit {
    width: 90%;
    height: 40px;
    color:white;
    font-weight: bold;
    font-size: 20px;
    border-radius:5px;
    border: white 1px solid;
  }
  #join_button {
    width: 90%;
    height: 40px;
    color:grey;
    font-weight: bold;
    font-size: 20px;
    border-radius:5px;
    border: grey 1px solid;
    background-color: white;
  }
</style>

</head>
<body>

<!-- 상단 메뉴바 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

  <div class="main">
      <div class="contents">
          <div class="login">
              <form method="post"  action="${contextPath}/buyer/login.do">
                  <table class="buyer_login" >
                      <tbody>
                          <tr>
                              <td><h1>로그인</h1></td>
                          </tr>
                          <tr>
                              <td><input type="text" id="b_id" name="b_id" maxlength="12" placeholder="ID를 입력하세요"/></td>
                          </tr>
                          <tr>
                              <td>
                                  <input type="password" id="b_pwd" name="b_pwd" maxlength="12" placeholder="PW를 입력하세요"/>
                              </td>
                          </tr>
                          <tr>
                              <td class="options">
                                  <input type="checkbox">로그인 유지<br>
                                  <a href="#">아이디/비밀번호 찾기</a>
                              </td>
                          </tr>
                          <tr>
                              <td><button type="submit" id="submit" style="background-color: green;">로그인</button></td>
                          </tr>
                          <tr>
                              <td>
                                  <a href="#"><button id="join_button">가입하기</button></a>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </form>
          </div>
          <div class="partition"></div>
          <div class="login">
              <form>
                  <table class="social_login">
                      <tr>
                          <td><h1>소셜미디어 로그인</h1></td>
                      </tr>
                      <tr>
                          <td>
                              <p style="font-size:15px">
                                제3기관을 이용해 로그인함으로써 저는 18세 이상이며 이용 약관에 동의하며, 개인정보 보호정책을 읽었음을 확인합니다.<br><br>
                              </p>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <button id="login_button" style="background-color: orange;">Google 계정으로 로그인</button>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <button id="login_button" style="background-color: green;">NAVER 계정으로 로그인</button>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <button id="login_button" style="background-color: yellow; color:black;">KAKAO 계정으로 로그인</button>
                          </td>
                      </tr>
                  </table>
              </form>
          </div>
      </div>
  </div>

<%	// form의 action이 실행되기 이전에 아이디, 비밀번호에 값이 입력되었는지,
	// 자리수가 맞는지 검사한다.
%>
<script>
$(document).ready(function() {
	// 로그인 버튼이 눌렸을 경우
	$("#submit").on("click", function() {
		// alert("로그인 버튼을 눌렀습니다.");
		
		if($("#b_id").val() == "") {
			alert("아이디를 입력하셔야 합니다.");
			$("#b_id").focus();
			return false;
		}
		if($("#b_id").val().length < 2) {
			alert("아이디는 최소 4자리 이상을 입력하셔야 합니다.");
			$("#id").focus();
			return false;
		}
		
		if($("#b_pwd").val() == "") {
			alert("비밀번호를 입력하셔야 합니다.");
			$("#pwd").focus();
			return false;
		}
		if($("#b_pwd").val().length < 2) {
			alert("비밀번호는 최소 4자리 이상을 입력하셔야 합니다.");
			$("#b_pwd").focus();
			return false;
		}
		
	});
	
	
});
</script>

</body>
</html>










