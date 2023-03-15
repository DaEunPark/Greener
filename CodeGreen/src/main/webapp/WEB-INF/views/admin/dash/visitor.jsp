<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery.min.js"></script>
<!-- google charts -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
<div id="chart_div" class="container"></div>
  <script type="text/javascript">
  
  $(document).ready(function(){
	  getGraph();
  });
  
  function getGraph(){
	  let timeList = [];
	  let countList = [];
	  
	  $.ajax({
		  url:"${cpath}/visitcount.do",
		  type:"get",
		  data:{v_time:"${now()}"},
		  dataType:"json",
		  success:function(data){
			  for(let i = 0, i < data.length;i++){
				  timeList.push(data[i].WEEK_NAME);
				  countList.push(data[i].C)
			  }
			  now Chart(document.getElementById("line-chart"),{
				  type : 'line',
				  data : {
					  labels : timeList,
					  datasets:[{
						  data : countList,
						  borderColer : "#3e95cd",
						  fill: false
					  }]
				  },
				  options:{
					  title:{
						  display: true,
						  text : '주간 방문자 수'
					  }
				  }
				  
			  });
		  },
		  error:function(){
			  alert("실패");
		  }
	  })
  }
   
  </script>
</body>
</html>