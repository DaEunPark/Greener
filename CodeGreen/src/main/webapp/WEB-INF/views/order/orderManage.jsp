<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	#labelname1, #labelname2, #labelname3 {
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

	.title {
		padding: 25px 0px 0px 420px;
	}
	#orderCheck {
		margin : 0 auto;
	}
		.txt:hover {
		font-weight: bold;
		color: #5CAAEF;
		webkit-transform: scale(1.1,1.1);
    	moz-transform: scale(1.1,1.1);
    	o-transform: scale(1.1,1.1);
    	ms-transform: scale(1.1,1.1);
    	transform: scale(1.1,1.1);
	}
	
	#title {
		background-color: #F2FFED;
	}
	
	#contents {
		background-color: transparent;
	}
	#table {
		width:	100%;
		font-size:	14px;
	}
	#contents {
		height:	35px;
	}
	#paging {
		width:100%;
		margin : 0 auto;
	}
	.listWrap {
	width : 90%;
	margin : 0 auto;
}
.inputArea{
margin-left : 50px;
}
</style>

<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
<div class="container">

<h2 class="adminTitle">주문내역 조회</h2>
	<form class="form-horizontal listWrap" method="GET" name="formname1" id="formname1">
<hr/>
<div class="inputArea">
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
				<label for="productState" class="control-label" id="labelname1">조회기간</label>&nbsp;&nbsp;&nbsp;
				<label class="checkbox-inline">
					<input type="checkbox" class="period0" id="period0" name="period" value="0"> 하루&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="period1" id="period1" name="period" value="1"> 일주일&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="period2" id="period2" name="period" value="2"> 한달&nbsp;&nbsp;&nbsp;
				</label>
		</div>
		<div class="form-inline form-group">
				<label for="payState" class="control-label" id="labelname2">배송상태</label>&nbsp;&nbsp;&nbsp;
				<label class="checkbox-inline">
					<input type="checkbox" class="state0" id="state0" name="state" value="0"> 결제완료&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state1" id="state1" name="state" value="1"> 배송준비&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state2" id="state2" name="state" value="2"> 배송중&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state3" id="state3" name="state" value="3"> 배송완료&nbsp;&nbsp;&nbsp;
				</label>
		</div>
		<div class="form-inline form-group">
				<label for="viewList" class="control-label" id="labelname3">정렬기준</label>&nbsp;&nbsp;&nbsp;
				<label class="checkbox-inline">
					<input type="checkbox" class="dateAsc" id="dateAsc" name="viewList" value="0"> 주문일자(오름차순)&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="dateDes" id="dateDes" name="viewList" value="1"> 주문일자(내림차순)&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="priceAsc" id="priceAsc" name="viewList" value="2"> 결제금액(오름차순)&nbsp;&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="priceDes" id="priceDes" name="viewList" value="3"> 결제금액(내림차순)&nbsp;&nbsp;&nbsp;
				</label>
				</div>
		</div>
				<hr/>
				
	</form>
				<button type="button" id="orderCheck" class="btn btn-success btn-sm" onclick="sendAjaxRequest()">조회</button>
	<div id="resultDiv"></div>
</div>





<script>
$(".checkbox-inline input[type='checkbox']").on("click", function(){
    if (!$(this).prop("checked")) {
        $(this).removeAttr("checked");
    }
});
</script>
<script>
$(".checkbox-inline input[type='checkbox']").on("click", function(){
    var isChecked = $(this).prop("checked");
    var checkboxes = $("input[name='" + $(this).attr("name") + "']");

    if (isChecked) {
        checkboxes.not(this).prop("checked", false);
    }
});
</script>
<script>
function sendAjaxRequest(data) {
        var orderNum = $('#orderNum').val();
        var buyerName = $('#buyerName').val();
        var productNum = $('#productNum').val();
        var period0 = $('#period0').is(':checked') ? 1 : 0;
        var period1 = $('#period1').is(':checked') ? 1 : 0;
        var period2 = $('#period2').is(':checked') ? 1 : 0;
        var state0 = $('#state0').is(':checked') ? 1 : 0;
        var state1 = $('#state1').is(':checked') ? 1 : 0;
        var state2 = $('#state2').is(':checked') ? 1 : 0;
        var state3 = $('#state3').is(':checked') ? 1 : 0;
        var dateAsc = $('#dateAsc').is(':checked') ? 1 : 0;
        var dateDes = $('#dateDes').is(':checked') ? 1 : 0;
        var priceAsc = $('#priceAsc').is(':checked') ? 1 : 0;
        var priceDes = $('#priceDes').is(':checked') ? 1 : 0;
      
 		  $.ajax({
 	           type: "POST",
 	           url: "/order/map-data",
 	           data:JSON.stringify({
 	        	orderNum:orderNum,
 	        	buyerName:buyerName,
	        	productNum:productNum,
	        	period0:period0,
	        	period1:period1,
	        	period2:period2,
	        	state0:state0,
	        	state1:state1,
	        	state2:state2,
	        	state3:state3,
	        	dateAsc:dateAsc,
	        	dateDes:dateDes,
	        	priceAsc:priceAsc,
	        	priceDes:priceDes
  	            }),
 	           contentType:"application/json;charset=UTF-8",
  	           success: function(response) {
  	        	   $('#resultDiv').html(response);
	 	       },

 				error: function(xhr, status, error) {
 	             alert ("주문 조회 오류");
 	           }
 	      });
}
</script>

</body>
</html>








