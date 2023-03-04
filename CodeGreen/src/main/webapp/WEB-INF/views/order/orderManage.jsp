<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>


 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 주문관리</title>
</head>
<style>
	#formname1 {
		padding: 10px 0px;
		font-size:	13px;
	}
	#labelname1 {
		padding: 10px 0px;
		font-weight:	bold;
		font-size:	13px;
	}
	#orderNum, #buyerName, #productNum {
		height:27px;
	}
	#orderMenuButton {
		border: 1px solid black;
	}
	.container {
		width: 70%;
	}
	.title {
		padding: 25px 0px 0px 420px;
	}
	#orderCheck {
		position:	absolute;
		left:	780px;
	}
</style>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
<div class="container">
<h2><p class="title">주문내역 조회</p></h2>
<hr/>
	<form class="form-horizontal" method="post" name="formname1" id="formname1">
		<div class="form-inline form-group">
			<label for="orderNum" class="control-label" id="labelname1">주문번호</label>&nbsp;&nbsp;&nbsp;
			<input type="text" id="orderNum" name="orderNum"/>
		</div>
		<div class="form-inline form-group">
			<label for="buyerName" class="control-label" id="labelname1">주문자명</label>&nbsp;&nbsp;&nbsp;
			<input type="text" id="buyerName" name="buyerName"/>
		</div>
 		<div class="form-inline form-group">
			<label for="productNum" class="control-label" id="labelname1">상품번호</label>&nbsp;&nbsp;&nbsp;
			<input type="text" id="productNum" name="productNum"/>
		</div>
 		<div class="form-inline form-group">
				<label for="productState" class="control-label" id="labelname1">결제상태</label>&nbsp;&nbsp;&nbsp;
				<label class="checkbox-inline">
					<input type="checkbox" class="state0" id="state0" name="state0" value="0"> 결제완료&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state1" id="state1" name="state1" value="1"> 배송대기&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state2" id="state2" name="state2" value="2"> 배송중&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state3" id="state3" name="state3" value="3"> 배송완료&nbsp;&nbsp;&nbsp;
				</label>
		</div>
		<div class="form-inline form-group">
				<label for="productState" class="control-label" id="labelname1">조회기간</label>&nbsp;&nbsp;&nbsp;
				<label class="radio-inline">
					<input type="radio" class="period0" id="period0" name="period" value="0"> 하루&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="radio" class="period1" id="period1" name="period" value="1"> 일주일&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="radio" class="period2" id="period2" name="period" value="2"> 한달&nbsp;&nbsp;&nbsp;
				</label>
		</div>
	</form>
</div>

<hr/>

	<div class="container">
				<center><button type="button" id="orderCheck" class="btn btn-success btn-sm" onclick="sendAjaxRequest()">조회</button></center>
	</div>
	<hr style="border: 1px; color:#FFFFFF;">
	<div id="resultDiv"></div>


<script>

function sendAjaxRequest(data) {
        var orderNum = $('#orderNum').val();
        var buyerName = $('#buyerName').val();
        var productNum = $('#productNum').val();
        var state0 = $('#state0').is(':checked') ? 1 : 0;
        var state1 = $('#state1').is(':checked') ? 1 : 0;
        var state2 = $('#state2').is(':checked') ? 1 : 0;
        var state3 = $('#state3').is(':checked') ? 1 : 0;
        var period0 = $('#period0').is(':checked') ? 1 : 0;
        var period1 = $('#period1').is(':checked') ? 1 : 0;
        var period2 = $('#period2').is(':checked') ? 1 : 0;
      
 		  $.ajax({
 	           type: "POST",
 	           url: "/order/map-data",
 	           data:JSON.stringify({
 	        	orderNum:orderNum,
 	        	buyerName:buyerName,
	        	productNum:productNum,
	        	state0:state0,
	        	state1:state1,
	        	state2:state2,
	        	state3:state3,
	        	period0:period0,
	        	period1:period1,
	        	period2:period2
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








