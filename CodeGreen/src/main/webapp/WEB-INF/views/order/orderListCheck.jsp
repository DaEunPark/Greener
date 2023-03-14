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
<%-- <c:if test="${empty orderList}">
  <script>
    alert('조회 결과가 없습니다.');
  </script>
</c:if> --%>
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
	    <div>
		   	<c:if test="${ph.showPrev} ">
		   		<a href="<c:url value='/order/map-data?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>">&lt;</a>
		   	</c:if>
		    <c:forEach var="i"  begin="${ph.beginPage}" end="${ph.endPage}">
		    	<a href="<c:url value='/order/map-data?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
	    </c:forEach>
		    <c:if test="${ph.showNext} ">
		   		<a href="<c:url value='/order/map-data?page=${ph.endPage+1}&pageSize=${ph.pageSize}'/>">&gt;</a>
		   	</c:if>
	   </div>
</body>
</html>