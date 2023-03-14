<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>소비자 상세 정보</title>
<style>
	  .cont{
       margin-left: 280px;
   }
</style>


</head>
<body>
<!-- 상단 메뉴 -->
<jsp:include page="../admin/include/nav.jsp" flush="false"/>

<div class="cont">
	<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">판매자 상세 정보</h2>
				<hr/>
			</div>
		</div>
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">아이디</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="s_id" name="s_id" maxlength="10" value="${sellerDetail.s_id}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">이름</label>
			<div class="col-sm-1">
				<input type="text" class="form-control" id="s_name" name="s_name" maxlength="8" value="${sellerDetail.s_name}" readonly/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">이메일</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="s_email" name="s_email" maxlength="30" value="${sellerDetail.s_email}" readonly/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">주소</label>
			<div class="col-sm-5" align="right">
				<input type="text" class="form-control" id="s_address" name="s_address" maxlength="100"  value="${sellerDetail.s_address2} ${sellerDetail.s_address3} " readonly/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">가입일자</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="s_joindate" name="s_joindate" value="<fmt:formatDate value='${sellerDetail.s_joindate}' pattern='yyyy년 MM월 dd일 a hh시 mm분 ss초'/>" readonly/>
			</div>
		</div>

		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">핸드폰 번호</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="s_phone" name="s_phone" maxlength="15" value='${sellerDetail.s_phone}' readonly/>
			</div>
		</div>
		<div class="form-group">
			<p align="center">
				<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/seller/sellerList'">
					<span class="glyphicon glyphicon-list-alt"> 목록</span>
				</button>
			</p>
		</div>
	</form>
	</div>
</div>
<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"/>
	<script src="${contextPath}/resources/js/seller.js"></script>
</body>
</html>