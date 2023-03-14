<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUpChart</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js"></script>
</head>
<body>
	<jsp:include page="../include/nav.jsp" flush="false"/>
	<div class="container">
		<h1>월간 일별 회원가입자 수</h1>
		<canvas id="myChart" style="width:80%; max-width:500px"></canvas>
	
	</div>
	

	<script>
		$.ajax({
			type:'get',
			url:'',
			success:function(json){
//				console.log(json);
				
				//5,7,3,5,3,3,4,5,5,5,2,3
				let myData = [5,7,3,5,3,3,4,5,5,5,2,3];
				myData.push(json.jan22);
				myData.push(json.feb22);
				myData.push(json.mar22);
				myData.push(json.apr22);
				myData.push(json.may22);
				myData.push(json.jun22);
				myData.push(json.jul22);
				myData.push(json.aug22);
				myData.push(json.sep22);
				myData.push(json.oct22);
				myData.push(json.nov22);
				myData.push(json.dec22);
				
				// chart.js
				const ctx = document.getElementById('myChart').getContext('2d');
				const myChart = new Chart(ctx, {
				    type: 'bar',
				    data: {
				        labels: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				        datasets: [{
				            label: '# 월별 가입자수',
				            data: myData,
				            backgroundColor: [
				                'rgba(255, 99, 132, 0.2)',
				                'rgba(54, 162, 235, 0.2)',
				                'rgba(255, 206, 86, 0.2)',
				                'rgba(75, 192, 192, 0.2)',
				                'rgba(153, 102, 255, 0.2)',
				                'rgba(255, 159, 64, 0.2)',
				                'rgba(255, 99, 132, 0.2)',
				                'rgba(54, 162, 235, 0.2)',
				                'rgba(255, 206, 86, 0.2)',
				                'rgba(75, 192, 192, 0.2)',
				                'rgba(153, 102, 255, 0.2)',
				                'rgba(255, 159, 64, 0.2)'
				            ],
				            borderColor: [
				                'rgba(255, 99, 132, 1)',
				                'rgba(54, 162, 235, 1)',
				                'rgba(255, 206, 86, 1)',
				                'rgba(75, 192, 192, 1)',
				                'rgba(153, 102, 255, 1)',
				                'rgba(255, 159, 64, 1)',
				                'rgba(255, 99, 132, 0.2)',
				                'rgba(54, 162, 235, 0.2)',
				                'rgba(255, 206, 86, 0.2)',
				                'rgba(75, 192, 192, 0.2)',
				                'rgba(153, 102, 255, 0.2)',
				                'rgba(255, 159, 64, 0.2)'
				            ],
				            borderWidth: 1
				        }]
				    },
				    options: {
				        scales: {
				            y: {
				                beginAtZero: true
				            }
				        }
				    }
				});
				
			}
		});
	</script>
</body>

<!-- h1>getChart</h1>
	<div id="output"></div>
	
	<script>
		$.ajax({
			type:'get',
			url:'/dashBoard/SignUpChart',
		
			success:function(json){
				console.log($('#output'));
				
				console.log(json);
				$('#output').append("1월 : "+json.jan22+'<br>');
				$('#output').append("2월 : "+json.feb22+'<br>');
				$('#output').append("3월 : "+json.mar22+'<br>');
				$('#output').append("4월 : "+json.apr22+'<br>');
				$('#output').append("5월 : "+json.may22+'<br>');
				$('#output').append("6월 : "+json.jun22+'<br>');
				$('#output').append("7월 : "+json.jul22+'<br>');
				$('#output').append("8월 : "+json.aug22+'<br>');
				$('#output').append("9월 : "+json.sep22+'<br>');
				$('#output').append("10월 : "+json.oct22+'<br>');
				$('#output').append("11월 : "+json.nov22+'<br>');
				$('#output').append("12월 : "+json.dec22+'<br>');
			}
		});
	</script-->

</html>
