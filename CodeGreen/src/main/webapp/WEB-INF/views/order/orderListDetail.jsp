<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
    

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역 상세조회</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	 -->

</head>
<body>
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
<h2><center><p class="title">주문내역 상세조회</p></center></h2>
<hr/>
<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<label for="o_number" class="col-sm-2 control-label">주문번호: </label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="o_number" name="o_number" maxlength="30" value="${orderDetail.o_number}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="o_date" class="col-sm-2 control-label">주문일시: </label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="o_date" name="o_date" value="${orderDetail.o_date}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="o_price" class="col-sm-2 control-label">주문금액:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="o_price" name="o_price" value="${orderDetail.o_price}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="b_id" class="col-sm-2 control-label">아이디:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="b_id" name="b_id" value="${orderDetail.b_id}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="b_email" class="col-sm-2 control-label">구매자 이메일:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="b_email" name="b_email" value="${orderDetail.b_email}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="o_receiver_phone" class="col-sm-2 control-label">구매자 전화번호:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="o_receiver_phone" name="o_receiver_phone" value="${orderDetail.o_receiver_phone}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="o_receiver_name" class="col-sm-2 control-label">수령인:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="o_receiver_name" name="o_receiver_name" value="${orderDetail.o_receiver_name}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="order_p_number" class="col-sm-2 control-label">우편번호:</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="order_p_number" name="order_p_number" value="${orderDetail.o_address1}" readonly/>
			</div>
		</div>
				<div class="form-group">
			<label for="o_address" class="col-sm-2 control-label">수령지 주소:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="o_address" name="o_address" value="${orderDetail.o_address2}" readonly/>
				<input type="text" class="form-control" id="o_address" name="o_address" value="${orderDetail.o_address3}" readonly/>
			</div>
		</div>

</body>
</html>