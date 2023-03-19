<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html> 
<html>
<head>
	<meta charset="UTF-8">
	<title>상품별 누적조회수 순위 현황</title>
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
<div class="container">

<div class="adminTitle">
<h2>상품별 누적조회수 순위 현황</h2>
</div>

<!-- chart.js 그래프적용 -->
<div class="myCanvas" style="width:90%;">
    <canvas id="line-chart"></canvas>
</div>
<script>
$(function() {
	var jsonData;
	$.ajax({
		 url:"/admin/dash/dashproductviewJSON",
		 async: false,
		 type: "GET",
		 //data: "DashProductview",
		 dataType: "json",
		 contentType: "application/json; charset=utf-8",
		 success:function(data){
			 console.log(data);
//			 alert(data);
			 jsonData = data;
//			 alert(jsonData);
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

	  const ctx = document.getElementById('myChart');
//	  alert(jsonData[0].c_name);
//	  alert(jsonData[0].p_view);
//	  alert(jsonData[0].c_code);
//	  alert(jsonData[0]c_code_ref);
	  
	  var mychart = $('#line-chart');
	  var mylinechart = new Chart(mychart, {
	    type:'line',
	    data:{
	  labels: ['1위\n' + jsonData[0].p_name ,
		 	   '2위\n' + jsonData[1].p_name ,
			   '3위\n' + jsonData[2].p_name ,
			   '4위\n' + jsonData[3].p_name ,
		 	   '5위\n' + jsonData[4].p_name , 
		 	   '6위\n' + jsonData[5].p_name , 
		 	   '7위\n' + jsonData[6].p_name , 
		 	   '8위\n' + jsonData[7].p_name , 
		 	   '9위\n' + jsonData[8].p_name , 
		 	   '10위\n'+ jsonData[9].p_name ], 
	  datasets: [{
	    label: ['누적 조회수'],
	    data: [	jsonData[0].p_view ,
		    	jsonData[1].p_view ,
		    	jsonData[2].p_view ,
		    	jsonData[3].p_view ,
		    	jsonData[4].p_view ,
		    	jsonData[5].p_view ,
		    	jsonData[6].p_view ,
		    	jsonData[7].p_view ,
		    	jsonData[8].p_view ,
		    	jsonData[9].p_view ],
	    fill: true,
	    borderColor:  'rgb(255, 205, 86)',
	    tension: 0.1,
	  }]
	  }
	  });
});
</script>


</div>

</body>
</html>