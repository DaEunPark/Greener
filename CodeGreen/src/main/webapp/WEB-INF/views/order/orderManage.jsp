<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 주문관리</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sidebars/">
    <!-- Custom styles for this template -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
<link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
<link href="../../resources/css/admin/nav.css" rel="stylesheet">
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
<jsp:include page="../admin/include/nav.jsp" flush="false"/>

</head>
<body>

<h2><center><p class="title">주문내역 조회</p></center></h2>
<hr/>

<div class="container">
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
					<input type="checkbox" class="state" id="pay0" name="pay0" value="0"> 결제완료&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="pay1" name="pay1" value="1"> 배송대기&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="pay2" name="pay2" value="2"> 배송중&nbsp;&nbsp;
				</label>
				<label class="checkbox-inline">
					<input type="checkbox" class="state" id="pay3" name="pay3" value="3"> 배송완료&nbsp;&nbsp;
				</label>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="productState" class="control-label">조회기간</label>
			</div>
			<div class="col-sm-offset-2">
				<label class="radio-inline">
					<input type="radio" class="state" id="period0" name="period" value="0"> 하루&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
				<label class="radio-inline">
					<input type="radio" class="state" id="period1" name="period" value="1"> 일주일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
				<label class="radio-inline">
					<input type="radio" class="state" id="period2" name="period" value="2"> 한달&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
        var pay0 = $('#pay0').is(':checked') ? 1 : 0;
        var pay1 = $('#pay1').is(':checked') ? 1 : 0;
        var pay2 = $('#pay2').is(':checked') ? 1 : 0;
        var pay3 = $('#pay3').is(':checked') ? 1 : 0;
        var period0 = $('#period0').is(':checked') ? 1 : 0;
        var period1 = $('#period1').is(':checked') ? 1 : 0;
        var period2 = $('#period2').is(':checked') ? 1 : 0;
/*          var radioVar = $('input[name=registerYn]:checked').val();*/
 		  $.ajax({
 	           type: "POST",
 	           url: "/order/map-data",
 	           data:JSON.stringify({
 	        	orderNum:orderNum,
 	        	buyerName:buyerName,
	        	productNum:productNum,
	        	pay0:pay0,
	        	pay1:pay1,
	        	pay2:pay2,
	        	pay3:pay3,
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








