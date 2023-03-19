<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%	request.setCharacterEncoding("UTF-8"); %>
<%@ page import="com.greener.codegreen.dto.ProductAvgCntDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">

	// Load the Visualization API
	google.charts.load('visualization', '1', {'packages':['bar']});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
		var jsonData = $.ajax({
			url: "/admin/dash/productavgdata",
			dataType: "json",
			async: false
		}).responseText;
		var jdata = new google.visualization.DataTable(jsonData);
/*		var dt = new google.visualization.DataTable({
				    cols: [{id: 'task', label: 'Task', type: 'string'},
				           {id: 'hours', label: 'Hours per Day', type: 'number'}],
				    rows: [{c:[{v: 'Work'}, {v: 11}]},
				           {c:[{v: 'Eat'}, {v: 2}]},
				    }, 0.6);
*/
			var length = Object.keys(jsonData).length;
			var height;
			if (length > 700) {
				document.getElementById("product_avg_chart").style.cssText = "width: 1200px; height: 1100px;";
			} else {
				document.getElementById("product_avg_chart").style.cssText = "width: 1200px; height: 600px;";
			}
		
			var options = {
				chart : {
					title : '상품별 구매 개수 평균',
					subtitle : '',
				},
				bars : 'horizontal', // Required for Material Bar Charts.
				animation : {
					startup : true,
					duration: 20,
			        easing: 'out'
			    }
			};			
			var chart = new google.charts.Bar(document.getElementById('product_avg_chart'));
			chart.draw(jdata, google.charts.Bar.convertOptions(options));

	}
</script>

<style type="text/css">
	#product_avg_chart {
		padding: 10px 0px;
	}
	text {
	    max-width: 150px; /** Adjust width to your needs */
	    display:inline-block;
	    vertical-align: middle;
	    overflow: hidden;
	    white-space: nowrap;
	    text-overflow: ellipsis !important;	
	}
</style>

<meta charset="UTF-8">
<title>구매 수량 평균</title>
</head>
<body>
	<jsp:include page="../include/nav.jsp" flush="false"/>
	<div class="container">
		<div id="product_avg_chart"></div>
	</div>
	
</body>
</html>