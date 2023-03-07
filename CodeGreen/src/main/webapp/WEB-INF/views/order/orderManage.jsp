<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<!-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 주문관리</title>

</head>
<body>
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
<div class="container">
<h2><center><p class="title">주문내역 조회</p></center></h2>
<hr/>
	<form class="form-horizontal" method="post" name="formname1" id="formname1">
		<div class="form-group">
			<div class="col-sm-2">
				<label for="orderNum" class="control-label">주문번호</label>
			</div>
			<div class="col-sm-offset-1">
				<input type="text" id="orderNum" name="orderNum"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="buyerName" class="control-label">이름</label>
			</div>
			<div class="col-sm-offset-1">
				<input type="text" id="buyerName" name="buyerName"/>
			</div>
		</div>
 		<div class="form-group">
			<div class="col-sm-2">
				<label for="productNum" class="control-label">상품번호</label>
			</div>
			<div class="col-sm-offset-1">
				<input type="text" id="productNum" name="productNum"/>
			</div>
		</div>
 		<div class="form-group">
			<div class="col-sm-2">
				<label for="productState" class="control-label">결제상태</label>
			</div>
			<div class="col-sm-offset-2">
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="completePay" name="completePay" value="0"> 결제완료&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="deliveryReady" name="deliveryReady" value="1"> 배송대기&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="onDelivery" name="onDelivery" value="2"> 배송중&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="delivered" name="delivered" value="3"> 배송완료&nbsp;&nbsp;
				</label>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="productState" class="control-label">조회기간</label>
			</div>
			<div class="col-sm-offset-2">
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="day" name="day" value="0"> 당일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="week" name="week" value="1"> 일주일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="month" name="month" value="2"> 한달&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="whole" name="whole" value="3"> 전체
				</label>
			</div>
		</div>
	</form>
</div>

<hr/>

	<div class="container">
				<center><button type="button" id="orderCheck" class="btn btn-info" onclick="sendAjaxRequest()">조회</button></center>
	</div>
	<hr style="border: 1px; #FFFFFF;">
	<div class="container">
		<div class="form-group">	
			<div class="col-sm-offset-11">
				<div class="dropdown">
				  <button class="dropdown-toggle" type="button" id="orderMenuButton" data-toggle="dropdown"> 정렬기준
				  <span class="caret"></span></button>
						<div class="dropdown-menu" aria-labelledby="dropdownOrderMenu">
							<button class="dropdown-item" type="button">주문일시</button>
							<button class="dropdown-item" type="button">결제일시</button>
							<button class="dropdown-item" type="button">결제금액순</button>
						</div>
				</div>
			</div>
		</div>
	</div>
 
<div class="container">
	<table class="table table-striped table-bordered table-hover">
		<thead>
				<tr class="orderList">
	  				<th class="col-sm-2 text-center">주문일자</th> 
					<th class="col-sm-2 text-center">주문번호</th>
					<th class="col-sm-1 text-center">회원번호</th>
					<th class="col-sm-2 text-center">아이디	</th>
					<th class="col-sm-1 text-center">주문자명</th>
					<th class="col-sm-2 text-center">결제금액</th>
<!--  					<th class="col-sm-2 text-center">주문상태</th>-->
				</tr>
		</thead>
	</table>
        <div id="resultDiv"></div>
</div>

<script>

function sendAjaxRequest(data) {
        var orderNum = $('#orderNum').val();
        var buyerName = $('#buyerName').val();
        var productNum = $('#productNum').val();
        var completePay = $('#completePay').is(':checked') ? 1 : 0;
        var deliveryReady = $('#deliveryReady').is(':checked') ? 1 : 0;
        var onDelivery = $('#onDelivery').is(':checked') ? 1 : 0;
        var delivered = $('#delivered').is(':checked') ? 1 : 0;
        var day = $('#day').is(':checked') ? 1 : 0;
        var week = $('#week').is(':checked') ? 1 : 0;
        var month = $('#month').is(':checked') ? 1 : 0;
        var whole = $('#whole').is(':checked') ? 1 : 0;
      
 		  $.ajax({
 	           type: "POST",
 	           url: "/order/map-data",
 	           data:JSON.stringify({
 	        	orderNum:orderNum,
 	        	buyerName:buyerName,
	        	productNum:productNum,
 	        	completePay:completePay,
 	        	deliveryReady:deliveryReady,
 	        	onDelivery:onDelivery,
 	        	delivered:delivered,
 	        	day:day,
 	        	week:week,
 	        	month:month,
 	        	whole:whole
  	            }),
 	           contentType:"application/json;charset=UTF-8",
  	           success: function(response) {
/*   	             alert ("주문 조회 성공");*/
 	             $("#resultDiv").html(response);
	 	       },

 				error: function(xhr, status, error) {
 	             alert ("주문 조회 오류");
 	           }
 	      });
}
</script>
</body>
</html>








