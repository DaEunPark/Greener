<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html> 
<html>
<head>
	<meta charset="UTF-8">
	<title>카테고리 상품별 누적 조회수 현황</title>
	<!--  부트스트랩 5.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<!-- 제이쿼리 넣어주기 -->  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <!-- 부트스트랩 사이드바 css  -->
   <link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet">
   <!-- 게시판관리 js 적용 -->
	<script src="${contextPath}/resources/js/Eboard.js"></script>
	<!-- chart.js 그래프적용 -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	
	
</head>
<body>
<!-- 사이드바 -->
<jsp:include page="../../admin/include/nav.jsp"></jsp:include>
<!-- 관리자화면 구성용 -->
<div class="container"  style="margin-right:120px; width: 70%; margin-top: 5%;" >

<div align="center">
<h2><strong>카테고리 상품별 누적 조회수 현황</strong></h2>
<h6>Y:누적 조회수 X:카테고리 상품별 누적조회순위</h6>
</div>

<!-- chart.js 그래프적용 -->
<div class="myCanvas">
    <canvas id="line-chart" width="100%" height="40%"></canvas>
</div>
<script>
/** 데이터 연동 실패
$.ajax({
	 url:"dashproductview",
	 async: false,
	 type: "GET",
	 //data: "DashProductview",
	 dataType: "json",
	 contentType: "application/json; charset=utf-8",
	 success:function(data){
		 console.log(data);
		 alert(data);
		},
		error:			function(data) {
			alert("문제발생");
		},
		done:			function(data) {
			alert("성공");
		},
		fail:			function(data) {
			alert("실패");
		},
		always:			function(data) {
			alert("완료");
		}	
	});			 
*/
  const ctx = document.getElementById('myChart');
  
  var mychart = $('#line-chart');
  var mylinechart = new Chart(mychart, {
    type:'line',
    data:{
  labels: '1'+ '2'+'3'+'4'+'5',
  datasets: [{
    label: '쌀·잡곡',
    data: [5641, 5641, 5564 ,5065 , 1300],
    fill: false,
    borderColor:  'rgb(255, 99, 132)',
    tension: 0.1
  },{
   label: '과일·견과·건과',
    data: [3452 , 2943 , 1789, 1548, 250],
    fill: false,
    borderColor:   'rgb(255, 159, 64)',
    tension: 0.1
    },{
   label: '수산·건어물',
    data: [50,40,30,20,10],
    fill: false,
    borderColor:  'rgb(255, 205, 86)',
    tension: 0.1
    },{
   label: '정육·계란류',
    data: [155 ,123, 102, 203, 156],
    fill: false,
    borderColor:  'rgb(75, 192, 192)',
    tension: 0.1
    },{
   label: '건강식품',
    data: [1200, 233, 140, 124, 123],
    fill: false,
    borderColor:  'rgb(54, 162, 235)',
    tension: 0.1
    },{
   label: '차·음료·생수·유제품',
    data: [642 , 641, 640, 639, 638 ],
    fill: false,
    borderColor:  'rgb(153, 102, 255)',
    tension: 0.1
    },{
   label: '과자·간식·빵·빙과',
    data: [95,85,65,55, 45],
    fill: false,
    borderColor: 'rgb(201, 203, 207)',
    tension: 0.1
    }]
  }
  });
</script>


</div>

</body>
</html>