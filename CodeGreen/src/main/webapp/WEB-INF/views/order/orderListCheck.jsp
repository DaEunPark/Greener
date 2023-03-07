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
	#paging {
		position:	absolute;
		left:	780px;
	}
	#orderStateButton {
		border:	none;
		text-size:	14px;
		font-weight:	bold;
	}
	#paging {
		align:	center;
	}
	#orderCheck {
		align: cennter;
	}
</style>
</head>
<body>
<div class="container" id="container">
	<div class="form-group">	
		<div class="dropdown">
			<button class="btn dropdown-toggle btn-sm" type="button" id="orderMenuButton" data-bs-toggle="dropdown"> 정렬기준
			</button>
			<ul class="dropdown-menu" aria-labelledby="orderMenuButton">
				<li><button class="dropdown-item" type="button">주문일자순(오름차순)</button></li>
				<li><button class="dropdown-item" type="button">주문일자순(내림차순)</button></li>
				<li><button class="dropdown-item" type="button">결제금액순(오름차순)</button></li>
				<li><button class="dropdown-item" type="button" id="priceDs">결제금액순(내림차순)</button></li>
			</ul>
		</div>
	</div>
</div>
<div class="container" id="container">
	<table class="table table-bordered table-hover" id="table">
		<thead>
				<tr class="orderList">
	  				<th class="col-sm-2 text-center" id="title">주문일자</th> 
					<th class="col-sm-1 text-center" id="title">주문번호</th>
					<th class="col-sm-1 text-center" id="title">회원번호</th>
					<th class="col-sm-1 text-center" id="title">아이디	</th>
					<th class="col-sm-1 text-center" id="title">주문자명</th>
					<th class="col-sm-1 text-center" id="title">결제금액</th>
  					<th class="col-sm-1 text-center" id="title">
  					<button class="btn dropdown-toggle btn-sm" type="button" id="orderStateButton" data-bs-toggle="dropdown"> 주문상태
					</button>
					<ul class="dropdown-menu" aria-labelledby="orderStateButton">
						<li><button class="dropdown-item" type="button" id="state">결제완료</button></li>
						<li><button class="dropdown-item" type="button" id="state">배송준비</button></li>
						<li><button class="dropdown-item" type="button" id="state">배송중</button></li>
						<li><button class="dropdown-item" type="button" id="state">배송완료</button></li>
					</ul>
  					</th>
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
		<ul class="btn-group pagination">
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
    var pageNum = pageNum;
      
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
	        	pageNum:pageNum
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
$('.dropdown-item:contains("결제완료")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = $(a).children('td:eq(6)').text();
        var keyB = $(b).children('td:eq(6)').text();
        if (keyA < keyB) return -1;
        if (keyA > keyB) return 1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        if ($(row).children('td:eq(6)').text() === "결제완료") {
            $('#table tbody').append(row);
        }
    });
});
</script>
<script>
$('.dropdown-item:contains("배송준비")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = $(a).children('td:eq(6)').text();
        var keyB = $(b).children('td:eq(6)').text();
        if (keyA < keyB) return -1;
        if (keyA > keyB) return 1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        if ($(row).children('td:eq(6)').text() === "배송준비") {
            $('#table tbody').append(row);
        }
    });
});
</script>
<script>
$('.dropdown-item:contains("배송중")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = $(a).children('td:eq(6)').text();
        var keyB = $(b).children('td:eq(6)').text();
        if (keyA < keyB) return -1;
        if (keyA > keyB) return 1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        if ($(row).children('td:eq(6)').text() === "배송중") {
            $('#table tbody').append(row);
        }
    });
});
</script>
<script>
$('.dropdown-item:contains("배송완료")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = $(a).children('td:eq(6)').text();
        var keyB = $(b).children('td:eq(6)').text();
        if (keyA < keyB) return -1;
        if (keyA > keyB) return 1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        if ($(row).children('td:eq(6)').text() === "배송완료") {
            $('#table tbody').append(row);
        }
    });
});
</script>
<script>
$('.dropdown-item:contains("주문일자(오름차순)")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = new Date($(a).children('td:eq(0)').text());
        var keyB = new Date($(b).children('td:eq(0)').text());
        if (keyA > keyB) return 1;
        if (keyA < keyB) return -1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        $('#table tbody').append(row);
    });
});
</script>
<script>
$('.dropdown-item:contains("주문일자(내림차순)")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = new Date($(a).children('td:eq(0)').text());
        var keyB = new Date($(b).children('td:eq(0)').text());
        if (keyA > keyB) return -1;
        if (keyA < keyB) return 1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        $('#table tbody').append(row);
    });
});
</script>
<script>
$('.dropdown-item:contains("결제금액순(오름차순)")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = parseInt($(a).children('td:eq(5)').text().replace(/,/g,''));
        var keyB = parseInt($(b).children('td:eq(5)').text().replace(/,/g,''));
        if (keyA > keyB) return 1;
        if (keyA < keyB) return -1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        $('#table tbody').append(row);
    });
});
</script>
<script>
$('.dropdown-item:contains("결제금액순(내림차순)")').click(function() {
    var rows = $('#table tbody tr').get();
    rows.sort(function(a, b) {
        var keyA = parseInt($(a).children('td:eq(5)').text().replace(/,/g,''));
        var keyB = parseInt($(b).children('td:eq(5)').text().replace(/,/g,''));
        if (keyA > keyB) return -1;
        if (keyA < keyB) return 1;
        return 0;
    });
    
    // tbody 내부의 모든 tr 요소들을 삭제합니다.
    $('#table tbody').empty();
    
    // 정렬된 rows 배열을 tbody 내부에 추가합니다.
    $.each(rows, function(index, row) {
        $('#table tbody').append(row);
    });
});
</script>
</body>
</html>






