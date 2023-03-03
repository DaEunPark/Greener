<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
    

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역 상세조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<style>
    input[type="text"] { 
    	border: solid 0.5px black; 
    }
    #o_number, #o_date, #o_price, #b_id, #b_email, #o_receiver_phone, #o_receiver_name, #order_p_number, #o_address {
    	background-color:transparent;
    	height:27px;
    }
    
    #formname2 {
    	padding: 10px 0px;
    }
    #labelname1 {
		padding: 10px 0px;
		font-weight:	bold;
	}
</style>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
<div class="container">
<h2><center><p class="title">주문내역 상세조회</p></center></h2>
<hr/>
	<form class="form-horizontal" id="frm" name=formname2 id=formname2>
		<div class="form-inline form-group">
			<label for="o_number" class="control-label" id="labelname1">주문번호 </label>
			<input type="text" id="o_number" name="o_number" maxlength="30" value="${orderDetail.o_number}" readonly/>
		</div>
		<div class="orm-inline form-group">
			<label for="o_date" class="control-label" id="labelname1">주문일시 </label>
			<input type="text" id="o_date" name="o_date" value="${orderDetail.o_date}" readonly/>
		</div>
		<div class="orm-inline form-group">
			<label for="o_price" class="control-label" id="labelname1">주문금액</label>
			<input type="text" id="o_price" name="o_price" value="${orderDetail.o_price}" readonly/>
		</div>
		<div class="orm-inline form-group">
			<label for="b_id" class="control-label" id="labelname1">아이디</label>
			<input type="text" id="b_id" name="b_id" value="${orderDetail.b_id}" readonly/>
		</div>
		<div class="orm-inline form-group">
			<label for="b_email" class="control-label" id="labelname1">구매자 이메일</label>
			<input type="text" id="b_email" name="b_email" value="${orderDetail.b_email}" readonly/>
		</div>
		<div class="orm-inline form-group">
			<label for="o_receiver_phone" class="control-label" id="labelname1">구매자 전화번호</label>
			<input type="text" id="o_receiver_phone" name="o_receiver_phone" value="${orderDetail.o_receiver_phone}" readonly/>
		</div>
		<div class="orm-inline form-group">
			<label for="o_receiver_name" class="control-label" id="labelname1">수령인</label>
			<input type="text" id="o_receiver_name" name="o_receiver_name" value="${orderDetail.o_receiver_name}" readonly/>
		</div>
		<div class="orm-inline form-group">
			<label for="order_p_number" class="control-label" id="labelname1">우편번호</label>
			<input type="text" id="order_p_number" name="order_p_number" value="${orderDetail.o_address1}" readonly/>
		</div>
				<div class="orm-inline form-group">
			<label for="o_address" class="control-label" id="labelname1">수령지 주소</label>
			<div class="col-sm-5">
				<input type="text" id="o_address" name="o_address" value="${orderDetail.o_address2}" readonly/>
				<input type="text" id="o_address" name="o_address" value="${orderDetail.o_address3}" readonly/>
			</div>
		</div>
	</form>
<hr/>
<center><input type="button" id="list" value="목록" onclick="history.back(-1)">&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-secondary btn-sm" id="orderCancle" name="orderCancle" onclick="fn_orderCancle()">주문취소</button></center>


<script>
function fn_orderCancle() {
	if(!confirm("주문내역을 취소하시겠습니까?\n\n")) {
	} else {
		alert("주문을 취소합니다.");
		location.href = "/order/orderCancle?o_number=" + ${orderDetail.o_number};
	}
}
</script>
</body>
</html>