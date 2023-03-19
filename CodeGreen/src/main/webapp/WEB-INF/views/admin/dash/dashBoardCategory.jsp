<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대시보드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

</head>
<!--  
<style>
.highcharts-figure,
.highcharts-data-table table {
    min-width: 360px;
    max-width: 800px;
    margin: 1em auto;
}

.highcharts-data-table table {
    font-family: Verdana, sans-serif;
    border-collapse: collapse;
    border: 1px solid #ebebeb;
    margin: 10px auto;
    text-align: center;
    width: 100%;
    max-width: 500px;
}

.highcharts-data-table caption {
    padding: 1em 0;
    font-size: 1.2em;
    color: #555;
}

.highcharts-data-table th {
    font-weight: 600;
    padding: 0.5em;
}

.highcharts-data-table td,
.highcharts-data-table th,
.highcharts-data-table caption {
    padding: 0.5em;
}

.highcharts-data-table thead tr,
.highcharts-data-table tr:nth-child(even) {
    background: #f8f8f8;
}

.highcharts-data-table tr:hover {
    background: #f1f7ff;
}
#explain {
	font-size:	11px;
	position:	absolute;
	margin-left:200px;
	margin-top: 20px;
}
</style>
-->
<body>
	<jsp:include page="../include/nav.jsp" flush="false"/>
    <div class="container">
    <div class="adminTitle">지난주 일별 카테고리 판매량</div>
	<figure class="highcharts-figure">
		<div id="myChart" style="width:80%; margin:0 auto;"></div>
	    <p id="explain" style="width : 80%; margin:0 auto;">1 : 월요일, 2 : 화요일, 3 : 수요일, 4 : 목요일, 5 : 금요일, 6 : 토요일, 7 : 일요일</p>
	</figure>
    </div>


<script>
Highcharts.chart('myChart', {

    title: {
        text: '',
        align: 'center'
    },

    subtitle: {
        text: 'Source: <a href="https://irecusa.org/programs/solar-jobs-census/" target="_blank">IREC</a>',
        align: 'left'
    },

    yAxis: {
        title: {
            text: '판매량'
        }
    },

    xAxis: {
        accessibility: {
            rangeDescription: 'Range: 1 to 7'
        }
    },

    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle'
    },

    plotOptions: {
        series: {
            label: {
                connectorAllowed: false
            },
            pointStart: 1
        }
    },

    series: [{
        name: '쌀·잡곡',
        data: [${dashBoardDTO.grainMon}, ${dashBoardDTO.grainTue}, ${dashBoardDTO.grainWen}, ${dashBoardDTO.grainThur}, 
        	${dashBoardDTO.grainFri}, ${dashBoardDTO.grainSat}, ${dashBoardDTO.grainSun}]
    }, {
        name: '과일·견과·건과',
        data: [${dashBoardDTOF.fruitMon}, ${dashBoardDTOF.fruitTue}, ${dashBoardDTOF.fruitWen}, ${dashBoardDTOF.fruitThur}, 
        	${dashBoardDTOF.fruitFri}, ${dashBoardDTOF.fruitSat}, ${dashBoardDTOF.fruitSun}]
    }, {
        name: '수산·건어물',
        data: [${dashBoardDTOS.fishMon}, ${dashBoardDTOS.fishTue}, ${dashBoardDTOS.fishWen}, ${dashBoardDTOS.fishThur}, 
        	${dashBoardDTOS.fishFri}, ${dashBoardDTOS.fishSat}, ${dashBoardDTOS.fishSun}]
    }, {
        name: '정육·계란류',
        data: [${dashBoardDTOM.meatMon}, ${dashBoardDTOM.meatTue}, ${dashBoardDTOM.meatWen}, ${dashBoardDTOM.meatThur}, 
        	${dashBoardDTOM.meatFri}, ${dashBoardDTOM.meatSat}, ${dashBoardDTOM.meatSun}]
    }, {
        name: '건강식품',
        data: [${dashBoardDTOH.healthyMon}, ${dashBoardDTOH.healthyTue}, ${dashBoardDTOH.healthyWen}, ${dashBoardDTOH.healthyThur}, 
        	${dashBoardDTOH.healthyFri}, ${dashBoardDTOH.healthySat}, ${dashBoardDTOH.healthySun}]
    }, {
        name: '차·음료·생수·유제품',
        data: [${dashBoardDTOW.waterMon}, ${dashBoardDTOW.waterTue}, ${dashBoardDTOW.waterWen}, ${dashBoardDTOW.waterThur}, 
        	${dashBoardDTOW.waterFri}, ${dashBoardDTOW.waterSat}, ${dashBoardDTOW.waterSun}]
    },  {
        name: '과자·간식·빵·빙과',
        data: [${dashBoardDTON.snackMon}, ${dashBoardDTON.snackTue}, ${dashBoardDTON.snackWen}, ${dashBoardDTON.snackThur}, 
        	${dashBoardDTON.snackFri}, ${dashBoardDTON.snackSat}, ${dashBoardDTON.snackSun}]
    }],

    responsive: {
        rules: [{
            condition: {
                maxWidth: 500
            },
            chartOptions: {
                legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                }
            }
        }]
    }

});

</script>
</body>
</html>