<%@page import="com.greener.codegreen.dto.DashboardAgeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연령대</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
  $(function(){
	  
   $.ajax({
	    url: "/admin/dash/Dashboard22",
	    
	    type: "GET",
	    success: function(data) {
	    	
			console.log(data[0].age_group);
	        
	        var chartData = {
	            labels: [], 
	            datasets: [
	                {
	                    data: [], 
	                    backgroundColor: [] // 색상 배열
	                }
	            ]
	        };
	        
	        // JSON 데이터를 차트 데이터로 변환
	        for (var i = 0; i < data.length; i++) {
	            chartData.labels.push(data[i].age_group); // 나이대 라벨 추가
	            chartData.datasets[0].data.push(data[i].total); // 이용자수 데이터 추가
	            chartData.datasets[0].backgroundColor.push(getRandomColor()); // 무작위 색상 추가
	        }
	        
	        // 무작위 색상 반환 함수
	        function getRandomColor() {
	            var letters = '0123456789ABCDEF';
	            var color = '#';
	            for (var i = 0; i < 6; i++) {
	                color += letters[Math.floor(Math.random() * 16)];
	            }
	            return color;
	        }
	        
	        // 차트 생성
	        var ctx = document.getElementById("myChart").getContext("2d");
	        var myChart = new Chart(ctx, {
	            type: 'doughnut',
	            data: chartData,
	            options: {
	            	
	            }
	        });
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
	    	console.log(textStatus, errorThrown);
	    }
	}); 
  
  });
  </script>
 </head>
<body>
	<jsp:include page="../include/nav.jsp" flush="false"/>
	<div class="container">
		<div style="width:50vw; height:30vh;">
			<h1>연령대</h1>
		
		  <canvas id="myChart" ></canvas>
		</div>	
	</div>


 
 

</body>
</html>