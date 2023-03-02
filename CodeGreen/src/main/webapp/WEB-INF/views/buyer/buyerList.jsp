<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소비자 목록 보기</title>
<style>
   .table{
        border-collapse : collapse;
        width: 100%;
    }
    .tr {
        border: 1px solid #aaaaaa;
        text-align: center;
    }
</style>
</head>
<body>
<!-- 상단 메뉴 -->
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
	<div class="container">
		<div>
			<h2>소비자 목록</h2>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="warning">
					<th class="col-sm-1	text-center">아이디</th>
					<th class="col-sm-2	text-center">비밀번호</th>
					<th class="col-sm-1	text-center">이름</th>
					<th class="col-sm-2	text-center">생년월일</th>
					<th class="col-sm-2	text-center">이메일</th>
					<th class="col-sm-3	text-center">주소</th>
					<th class="col-sm-2	text-center">등급</th>
					<th class="col-sm-2	text-center">가입일자</th>
					<th class="col-sm-5	text-center">핸드폰번호</th>
					<th class="col-sm-3	text-center">누적 금액</th>
					</tr>
			</thead>
			<tbody>
				<c:forEach var="buyer" items="${buyerList }">
					<tr>
						<td align="right">${buyer.b_id }</td>
						<td align="center">${buyer.b_pwd}</td>
						<td align="center">${buyer.b_name }</td>
						<td align="right">${buyer.b_birth}</td>
						<td align="right">${buyer.b_email}</td>
						<td align="right">${buyer.b_address2}&nbsp;${buyer.b_address3}</td>
						<td align="right">${buyer.b_grade}</td>
						<td align="right"><fmt:formatDate value="${buyer.b_joindate}" pattern="yyyy.MM.dd  hh:mm"/></td>
						<td align="right">${buyer.b_phone}</td>
						<td align="right"><fmt:formatNumber value="${buyer.b_amount }" pattern="#,###"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div align="center">
			<div class="form-group">
			<div class= "col-sm-offset-4 col-sm-2">
			<select id="searchType" class="form-control">
				<option>검색종류</option>
				<option value="b_id" <c:if test="${searchType== b_id}">selected</c:if>>아이디</option>
				<option value="b_name" <c:if test="${searchType== b_name}">selected</c:if>>이 름</option>
			</select>
			</div>
			<div class="col-sm-2">
			<input type="text" id="searchKeyword" value="${keyword }"/>
			</div>
			<div class="col-sm-1">
			<button id = "searchBtn" class="btn btn-danger">검색</button>
			</div>
		</div>
	</div>	
		<div align="center">
			<ul class="btn-group pagination">
				<c:if test="${pageMaker.prev }">
					<li>
						<a href='<c:url value="/buyer/buyerList?page=${pageMaker.startPage-1}&searchType=${searchType }&keyword=${keyword }"/>'>
							<span class="glyphicon glyphicon-chevron-left"></span>
						</a>
					</li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end = "${ pageMaker.endPage}" var="pageNum">
					<li>
						<a href='<c:url value="/buyer/buyerList?page=${pageNum }&searchType=${searchType }&keyword=${keyword } "/>'>
						<i>${pageNum }</i></a>	
					</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next }">
					<li>
						<a href='<c:url value="/buyer/buyerList?page=${pageMaker.endPage+1}&searchType=${searchType }&keyword=${keyword }"/>'>
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</li>
				</c:if>
			</ul>
		</div>	
		
		<form id="formList" action="/buyer/buyerList" method="get">
			<input type="hidden" name="searchType" value="${ searchType}"/>
			<input type="hidden" name="keyword" value="${keyword}"/>
		</form>
	</div>
	
<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"/>
<script src="/resources/js/buyer.js"></script>
</body>
</html>