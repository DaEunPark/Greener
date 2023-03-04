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
	#table {
		width:	1100px;
		font-size:	14px;
	}
	#contents {
		height:	35px;
	}

</style>

</head>
	<c:if test="${mapCount == null}">
	    <c:set var="mapCount" value="0" />
	</c:if>
	<script>
		alert("조회된 주문 건이 "+${mapCount}+"개 있습니다.");
	</script>
<body>
<div class="container" id="container">
	<div class="form-group">	
		<div class="dropdown">
			<button class="btn dropdown-toggle btn-sm" type="button" id="orderMenuButton" data-bs-toggle="dropdown"> 정렬기준
			</button>
			<ul class="dropdown-menu" aria-labelledby="orderMenuButton">
				<li><button class="dropdown-item" type="button" onclick="fn_odateAscending()">주문일자(오름차순)</button></li>
				<li><button class="dropdown-item" type="button" onclick="fn_odateDescending()">주문일자(내림차순)</button></li>
				<li><button class="dropdown-item" type="button" onclick="fn_opriceAscending()">결제금액순(오름차순)</button></li>
				<li><button class="dropdown-item" type="button" onclick="fn_opriceDescending()">결제금액순(내림차순)</button></li>
			</ul>
		</div>
	</div>
</div>
 
<div class="container" id="container">
	<table class="table table-bordered table-hover" id="table">
		<thead>
				<tr class="orderList">
	  				<th class="col-sm-2 text-center" id="title">주문일자</th> 
					<th class="col-sm-2 text-center" id="title">주문번호</th>
					<th class="col-sm-1 text-center" id="title">회원번호</th>
					<th class="col-sm-2 text-center" id="title">아이디	</th>
					<th class="col-sm-1 text-center" id="title">주문자명</th>
					<th class="col-sm-2 text-center" id="title">결제금액</th>
<!--  					<th class="col-sm-2 text-center">주문상태</th>-->
				</tr>
		</thead>
	    <c:forEach var="order" items="${orderList}">
	    	<tbody>
		      <tr class="orderList">
		   	    <td class="col-sm-2 text-center" id="contents">${order['o_date']}</td>
		        <td onClick="location.href='/order/orderDetail?o_number=${order['o_number']}'" class="col-sm-2 text-center txt" id="contents">${order['o_number']}</td>
		        <td class="col-sm-1 text-center" id="contents">${order['b_num']}</td>
		        <td class="col-sm-2 text-center" id="contents">${order['b_id']}</td>
		        <td class="col-sm-1 text-center" id="contents">${order['b_name']}</td>
		        <td class="col-sm-2 text-center" id="contents">
					<fmt:formatNumber value="${order['o_price']}" pattern="#,###" />
				</td>
		      </tr>
		     </tbody>
	    </c:forEach>
	    <c:forEach var="list" items="${orderListAll}">
	    	<tbody>
		      <tr class="orderList">
		   	    <td class="col-sm-2 text-center" id="contents">${list['o_date']}</td>
		        <td onClick="location.href='/order/orderDetail?o_number=${list['o_number']}'"  class="col-sm-2 text-center txt" id="contents">${list['o_number']}</td>
		        <td class="col-sm-1 text-center" id="contents">${list['b_num']}</td>
		        <td class="col-sm-2 text-center" id="contents">${list['b_id']}</td>
		        <td class="col-sm-1 text-center" id="contents">${list['b_name']}</td>
		        <td class="col-sm-2 text-center" id="contents">
		        	<fmt:formatNumber value="${list['o_price']}" pattern="#,###" />
		        </td>
		      </tr>
		     </tbody>
	    </c:forEach>
	  </table>
</div>

<script>

</script>
</body>
</html>






