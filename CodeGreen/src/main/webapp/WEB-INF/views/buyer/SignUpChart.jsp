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
	<h1>SignUpChart</h1>
	<canvas id="myChart" width="100" height="50"></canvas>
	
	<script>
		$.ajax({
			type:'get',
			url:'',
			success:function(json){
				//console.log(json);
				//5,7,3,5,3,3,4,5,5,5,2,3
				let myData = [{map}];
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


</html>
