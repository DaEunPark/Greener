<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역 상세조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
</head>
<style>
	#table1 {
		font-size:	15px;
		margin:	20px 70px;
		border-collapse: collapse;
	}
	table tr th {
		padding:	10px 10px;
		border-bottom:	dotted black 0.5px;
		border-right:	dotted black 0.5px;
	}
	table tr td {
		padding:	0px 30px;
		border-bottom:	dotted black 0.5px;
	}
	#title {
		padding: 25px 0px 0px 420px;
	}
	#list {
		position:	absolute;
		margin-left:	820px; 
	}
	#orderCancle {
		position:	relative;
		margin-left:	1000px; 
	}
	#borderRight {
		border:	dotted black 0.5px;
	}
	#o_count {
		align:	center;
	}
</style>
<body>
<div class="container">
	<h2><p id="title">주문내역 상세조회</p></h2>
	<button type="button" class="btn btn-secondary btn-sm" id="orderCancle" name="orderCancle" onclick="fn_orderCancle()">주문취소</button>
	<hr/>
	<table id="table1">
	  <tr>
	    <th>주문번호</th>
	    <td>${orderDetail.o_number}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>주문일시</th>
	    <td>${orderDetail.o_date}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>결제금액</th>
	    <td id="borderRight">${orderDetail.o_price}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>주문자</th>
	    <td id="borderRight">${orderDetail.b_name}</td><td>${orderDetail.b_grade}</td><td></td>
	  </tr>
	  <tr>
	    <th>아이디</th>
	    <td>${orderDetail.b_id}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>구매자 이메일</th>
	    <td>${orderDetail.b_email}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>구매자 전화번호</th>
	    <td>${orderDetail.o_receiver_phone}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>수령인</th>
	    <td>${orderDetail.o_receiver_name}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>우편번호</th>
	    <td>${orderDetail.o_address1}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>수령지 주소</th>
	    <td>${orderDetail.o_address2} ${orderDetail.o_address3}</td><td></td><td></td>
	  </tr>
	  <tr>
	    <th>상품명</th>
	    <td id="borderRight">${orderDetail.p_name} </td><td id="o_count">수량 : ${orderDetail.o_count}개</td><td></td>
	  </tr>
	</table>
	</div>
	<hr/>
	<input type="button" id="list" value="목록" onclick="history.back(-1)">&nbsp;&nbsp;&nbsp;
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