<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<!-- google charts -->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<%
		
	%>
</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="./include/nav.jsp"></jsp:include>
<div id="chart_div" class="container" width="300" height="250"></div>
  <script type="text/javascript">
   google.charts.load('current', {packages: ['corechart', 'bar']});
   google.charts.setOnLoadCallback(drawBasic);

   function drawBasic() {
    var data = new google.visualization.DataTable();
    data.addColumn('string', '요일');
    data.addColumn('number', '방문자수(명)');

    data.addRows([
     ['일', 1],
     ['월', 2],
     ['화', 3],
     ['수', 4],
     ['일', 5],
     ['금', 6],
     ['토', 7],
    ]);

    var options = {
     title: '이번주 일별 방문자 현황',
     hAxis: {
      title: '요일',
      viewWindow: {
       min: [7, 30, 0],
       max: [17, 30, 0]
      }
     },
     vAxis: {
      title: '방문자수(명)'
     }
    };

    var chart = new google.visualization.ColumnChart(
    document.getElementById('chart_div'));

    chart.draw(data, options);
   }
  </script>

</body>
</html>