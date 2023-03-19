<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>구매자 상세 정보</title>
	
	<style>
	  .cont{
       margin-left: 80px;
   }
</style>


</head>
<style>
.listWrap {
	width : 90%;
	margin : 0 auto;
}
.p_name{
	width : 250px;
}
</style>
<body>
<!-- 상단 메뉴 -->
<jsp:include page="../admin/include/nav.jsp" flush="false"/>

<div class="cont">
	<div class="container">
	<form class="form-horizontal listWrap" id="frm">
		<div class="form-group">
			<div>

				<h2 align="center">구매자 상세 정보</h2>

				<hr/>
			</div>
		</div>
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">아이디</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="b_id" name="b_id" maxlength="10" value="${buyerDetail.b_id}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">이름</label>
			<div class="col-sm-1">
				<input type="text" class="form-control" id="b_name" name="b_name" maxlength="8" value="${buyerDetail.b_name}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">생년월일</label>
			<div class="col-sm-1">
				<input type="text" class="form-control" id="b_birth" name="b_birth" maxlength="30" value="${buyerDetail.b_birth}" readonly/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">이메일</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="b_email" name="b_email" maxlength="30" value="${buyerDetail.b_email}" readonly/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">주소</label>
			<div class="col-sm-5" align="right">
				<input type="text" class="form-control" id="b_address" name="b_address" maxlength="100"  value="${buyerDetail.b_address2} ${buyerDetail.b_address3} " readonly/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">등급</label>
			<div class="col-sm-1">
				<input type="text" class="form-control" id="b_grade" name="b_grade" maxlength="14" value="${buyerDetail.b_grade}" readonly/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">가입일자</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="b_joindate" name="b_joindate" value="<fmt:formatDate value='${buyerDetail.b_joindate}' pattern='yyyy년 MM월 dd일 a hh시 mm분 ss초'/>" readonly/>
			</div>
		</div>

		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">핸드폰 번호</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="b_phone" name="p_phone" maxlength="15" value='${buyerDetail.b_phone}' readonly/>
			</div>
		</div>
				<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">누적 금액</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="b_amount" name="p_amount" maxlength="15" value='${buyerDetail.b_amount}' readonly/>
			</div>
		</div>
		<div class="form-group">
			<p align="center">
				<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/buyer/buyerList'">
					<span class="glyphicon glyphicon-list-alt"> 소비자 목록</span>
				</button>
			</p>
		</div>
	</form>
	</div>
</div>

<script src="${contextPath}/resources/js/buyer.js"></script>
<script>
$(function(){
	$.ajax({
		url:"/buyerDetail?",
		type:"GET",
		
		success:{
			function(data){
				
			}
		},
		error:{
			
		}
	});
});
</script>

</body>
</html>
