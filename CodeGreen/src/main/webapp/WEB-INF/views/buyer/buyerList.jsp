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
<link rel ="stylesheet" href= "/resources/css/admin/nav.css"/>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>

	#paging a{
			text-decoration: none;
			margin: 10px;
			font-family:inherit;
			font-size: medium;
			font-weight: bold;
	}
	.listWrap {
	width : 90%;
	margin : 0 auto;
}
	th, td{
	text-align:center; vertical-align: middle;
	}
</style>
</head>
<body>
<!-- 상단 메뉴 -->
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>
		<div class="container">
		<div class="listWrap">
		<div>
			<h2 class="adminTitle">소비자 목록</h2>
		</div>
		<table class="table table-striped table-hover align-middle table-bordered" style="border-spacing:0;">
	   	<thead class="table-dark" style="text-align:center; vertical-align: middle;">
	    	<tr>
					<th style="width:fit-content;">아이디</th>
					<th style="width:fit-content;">이름</th>
					<th style="width:fit-content;">생년월일</th>
					<th style="width:fit-content;">이메일</th>
					<th style="width:200px;">주소</th>
					<th style="width:fit-content;">등급</th>
					<th style="width:fit-content;">가입일자</th>
					<th style="width:fit-content;">핸드폰번호</th>
					<th style="width:fit-content;">누적 금액</th>
					</tr>
			</thead>
			<tbody style="text-align:center; vertical-align: middle;">
				<c:forEach var="buyer" items="${buyerList }">
					<tr>
						<td align="right" ><a href="${contextPath}/buyer/buyerDetail?b_id=${buyer.b_id}&flag=0">${buyer.b_id}</a></td>	
						<td align="right">${buyer.b_name }</td>					
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
		
		<div class="row justify-content-center">
		  <div class="col-sm-2">
		    <select id="searchType" class="form-select">
		      <option selected disabled>검색종류</option>
		      <option value="b_id" ${searchType == 'b_id' ? 'selected' : ''}>아이디</option>
		      <option value="b_name" ${searchType == 'b_name' ? 'selected' : ''}>이름</option>
		    </select>
		  </div>
		  <div class="col-sm-2">
		    <input type="text" id="searchKeyword" class="form-control" value="${keyword }"/>
		  </div>
		  <div class="col-sm-1">
		    <button id="searchBtn" class="btn btn-danger w-100">검색</button>
		  </div>

			<div class="row justify-content-center" id="paging">
		  <div class="col-sm-8">
		    <ul class="btn-group pagination d-flex justify-content-center">
		      <c:if test="${pageMaker.prev}">
		        <li>
		          <a href='<c:url value="/buyer/buyerList?page=${pageMaker.startPage-1}&searchType=${searchType}&keyword=${keyword}"/>'>
		            <span class="glyphicon glyphicon-chevron-left"></span>
		          </a>
		        </li>
		      </c:if>
		      <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
		        <li>
		          <a href='<c:url value="/buyer/buyerList?page=${pageNum}&searchType=${searchType}&keyword=${keyword}"/>'>
		            <i>${pageNum}</i>
		          </a> 
		        </li>
		      </c:forEach>
		      <c:if test="${pageMaker.next}">
		        <li>
		          <a href='<c:url value="/buyer/buyerList?page=${pageMaker.endPage+1}&searchType=${searchType}&keyword=${keyword}"/>'>
		            <span class="glyphicon glyphicon-chevron-right"></span>
		          </a>
		        </li>
		      </c:if>
		    </ul>
		  </div>
		</div>
				</div>
		
		<form id="formList" action="/buyer/buyerList" method="get">
			<input type="hidden" name="searchType" value="${ searchType}"/>
			<input type="hidden" name="keyword" value="${keyword}"/>
		</form>
		</div>	
		</div>

	
<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"/>
<script src="/resources/js/buyer.js"></script>
</body>
</html>