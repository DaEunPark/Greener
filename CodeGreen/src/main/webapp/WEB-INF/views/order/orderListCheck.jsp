<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

</style>
</head>
<body>
	    <c:forEach var="order" items="${orderList}">
	    	<table class="table table-bordered table-hover table-xs">
	    	<tbody>
		      <tr class="orderList">
		   	    <td class="col-sm-2 text-center">${order['o_date']}</td>
		        <td onClick="location.href='/order/orderDetail?o_number=${order['o_number']}'" class="col-sm-2 text-center txt" >${order['o_number']}</td>
		        <td class="col-sm-1 text-center">${order['b_num']}</td>
		        <td class="col-sm-2 text-center">${order['b_id']}</td>
		        <td class="col-sm-1 text-center">${order['b_name']}</td>
		        <td class="col-sm-2 text-center">${order['o_price']}</td>
		      </tr>
		     </tbody>
	   	   </table>
	    </c:forEach>
	    <c:forEach var="order" items="${orderListAll}">
	    	<table class="table table-bordered table-hover table-xs">
	    	<tbody>
		      <tr class="orderList">
		   	    <td class="col-sm-2 text-center">${order['o_date']}</td>
		        <td onClick="location.href='/order/orderDetail?o_number=${order['o_number']}'"  class="col-sm-2 text-center txt" >${order['o_number']}</td>
		        <td class="col-sm-1 text-center">${order['b_num']}</td>
		        <td class="col-sm-2 text-center">${order['b_id']}</td>
		        <td class="col-sm-1 text-center">${order['b_name']}</td>
		        <td class="col-sm-2 text-center">${order['o_price']}</td>
		      </tr>
		     </tbody>
	   	   </table>
	    </c:forEach>
</body>
</html>