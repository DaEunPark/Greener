 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<%--
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인화면</title>
</head>
<body>

<!-- 상단 메뉴 -->
<jsp:include page="./common/topMenu.jsp"></jsp:include>

<!-- 메뉴바 하단에 페이지의 소개를 보여준다. -->
<div class="container">
	<div class="jumbotron">
		<div class="container text-center">
			<h1>도서 쇼핑몰</h1>
			<p>방문을 환영합니다.</p>
		</div>
	</div>
</div>

<!-- 화면 중앙에 이미지를 보여준다. -->
<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<!-- class="img-responsive center-block" : 반응형 이미지를 가운데에 정렬한다. -->
				<img class="img-responsive center-block" src="${contextPath}/resources/images/books01.jpg" 
				width="80%" height="200px"/>
				<!-- carousel에 설명을 보여준다. -->
				<div class="carousel-caption">
					<h2>책방 내부 시설 1</h2>
				</div>
			</div>
			<div class="item">
				<!-- class="img-responsive center-block" : 반응형 이미지를 가운데에 정렬한다. -->
				<img class="img-responsive center-block" src="${contextPath}/resources/images/books02.jpg" 
				width="80%" height="200px"/>
				<!-- carousel에 설명을 보여준다. -->
				<div class="carousel-caption">
					<h2>책방 내부 시설 2</h2>
				</div>
			</div>
			<div class="item">
				<!-- class="img-responsive center-block" : 반응형 이미지를 가운데에 정렬한다. -->
				<img class="img-responsive center-block" src="${contextPath}/resources/images/books03.jpg" 
				width="80%" height="200px"/>
				<!-- carousel에 설명을 보여준다. -->
				<div class="carousel-caption">
					<h2>책방 내부 시설 32</h2>
				</div>
			</div>
		</div>
		
		<!-- 좌측, 우측으로 그림을 움직일 수 있도록 좌/우버튼을 설정한다. -->
		<a class="left  carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
		
	</div>
</div>

</body>
</html>

--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="./admin/include/nav.jsp"></jsp:include>
<div class="container">
	<div class="jumbotron">
		<div class="container text-center">
			<h1>관리자 페이지</h1>
		</div>
	</div>
</div>
</body>
</html>