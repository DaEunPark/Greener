<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<!-- google charts -->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="./include/nav.jsp"></jsp:include>
<%
String currentVisitIp = request.getRemoteAddr();

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = null;
ResultSet rs = null;
Statement stmt = null;

String url = "jdbc:mysql://mydb.cpwszsubjtfw.ap-northeast-2.rds.amazonaws.com/awsdb?serverTimezone=Asia/Seoul&useSSL=false";
con = DriverManager.getConnection(url, "admin", "awsdb1234!");
stmt = con.createStatement();
stmt.executeUpdate("insert into visitor (v_time) values (now())");
rs = stmt.executeQuery("SELECT COUNT(*) FROM visitor");

rs.close();
stmt.close();
con.close();
%>


</body>
</html>