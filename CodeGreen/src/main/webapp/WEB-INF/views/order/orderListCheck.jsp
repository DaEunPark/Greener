<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="../../resources/css/admin/nav.css" rel="stylesheet"/>
<style>
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
	.listWrap {
	width : 90%;
	margin : 0 auto;
	}
	#contents {
		height:	35px;
	}
	#orderStateButton {
		border:	none;
		text-size:	14px;
		font-weight:	bold;
	}
	#orderCheck {
		align: center;
	}
	.orderList {
		padding:	100px;
	}
	#paging{
	width: 100%;
	margin : 0 auto;
	display: flex;
            justify-content: center;
	}
</style>

</head>
<body>
	<hr style="border: 1px; color:#FFFFFF;">
	<hr style="border: 1px; color:#FFFFFF;">
	<hr style="border: 1px; color:#FFFFFF;">
<div id="container" class="container listWrap">
	<table class="table table-bordered table-hover" id="table">
		<thead>
				<tr class="orderList">
	  				<th class="col-sm-2 text-center" id="title">주문일자</th> 
					<th class="col-sm-1 text-center" id="title">주문번호</th>
					<th class="col-sm-1 text-center" id="title">회원번호</th>
					<th class="col-sm-1 text-center" id="title">아이디	</th>
					<th class="col-sm-1 text-center" id="title">주문자명</th>
					<th class="col-sm-1 text-center" id="title">결제금액</th>
  					<th class="col-sm-1 text-center" id="title">주문상태</th>
				</tr>
		</thead>
	   	<tbody>
		    <c:forEach var="order" items="${orderList}">
			      <tr class="orderList">
			   	    <td class="col-sm-2 text-center" id="contents">${order['o_date']}</td>
			        <td onClick="location.href='/order/orderDetail?o_number=${order['o_number']}'" class="col-sm-1 text-center txt" id="contents">${order['o_number']}</td>
			        <td class="col-sm-1 text-center" id="contents">${order['b_num']}</td>
			        <td class="col-sm-1 text-center" id="contents">${order['b_id']}</td>
			        <td class="col-sm-1 text-center" id="contents">${order['b_name']}</td>
			        <td class="col-sm-1 text-center" id="contents">
						<fmt:formatNumber value="${order['o_price']}" pattern="#,###" />
					</td>
					<td class="col-sm-1 text-center" id="contents">${order['o_state']}</td>
			      </tr>
		    </c:forEach>
		    <c:forEach var="list" items="${orderListAll}">
			      <tr class="orderList">
			   	    <td class="col-sm-2 text-center" id="contents">${list['o_date']}</td>
			        <td onClick="location.href='/order/orderDetail?o_number=${list['o_number']}'"  class="col-sm-1 text-center txt" id="contents">${list['o_number']}</td>
			        <td class="col-sm-1 text-center" id="contents">${list['b_num']}</td>
			        <td class="col-sm-1 text-center" id="contents">${list['b_id']}</td>
			        <td class="col-sm-1 text-center" id="contents">${list['b_name']}</td>
			        <td class="col-sm-1 text-center" id="contents">
			        	<fmt:formatNumber value="${list['o_price']}" pattern="#,###" />
			        </td>
			        <td class="col-sm-1 text-center" id="contents">${list['o_state']}</td>
			      </tr>
		    </c:forEach>
		 </tbody>
	  </table>
	  <br>
</div>
	<div id="paging">
		<ul class="btn-group pagination" >
			<c:if test="${pageMaker.prev}">
				<li>
					<a href='<c:url value="/order/map-data?page=${pageMaker.startPage-1}"/>'><span class="glyphicon glyphicon-chevron-left"></span></a>
				</li>
			</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
							<li><a onclick="sendAjaxRequest(${pageNum})" href='#'>${pageNum}</a></li>&nbsp;&nbsp;&nbsp;
						</c:forEach>
			<c:if test="${pageMaker.next}">
				<li>
					<a href='<c:url value="/order/map-data?page=${pageMaker.endPage+1}"/>'><span class="glyphicon glyphicon-chevron-right"></span></a>
				</li>
			</c:if>
		</ul>
	</div>
<script>
function sendAjaxRequest(pageNum) {
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
    var pageNum = pageNum;
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
	        	pageNum:pageNum,
	        	state0:state0,
	        	state1:state1,
	        	state2:state2,
	        	state3:state3,
	        	dateAsc:dateAsc,
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
<script>
function sendAjaxRequest(pageNum, varName) {
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
    var pageNum = pageNum;
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
	        	pageNum:pageNum,
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






