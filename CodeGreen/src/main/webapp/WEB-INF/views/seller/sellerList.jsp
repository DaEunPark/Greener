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
   #paging a{
			text-decoration: none;
			margin: 10px;
			font-family:inherit;
			font-size: medium;
			font-weight: bold;
	}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<!-- 상단 메뉴 -->
<%-- <jsp:include page="../common/manager_topMenu.jsp" flush="false"/> --%>
	<jsp:include page="../admin/include/nav.jsp" flush="false"/>

	<div class="container">
		<div>
			<h2>판매자 목록</h2>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="warning">
					<th class="col-sm-1	text-center">아이디</th>
					<th class="col-sm-2	text-center">비밀번호</th>
					<th class="col-sm-1	text-center">이름</th>
					<th class="col-sm-2	text-center">주민번호/사업자 번호</th>
					<th class="col-sm-2	text-center">이메일</th>
					<th class="col-sm-3	text-center">주민번호</th>
					<th class="col-sm-2	text-center">가입일자</th>
					<th class="col-sm-5	text-center">핸드폰번호</th>
					</tr>
			</thead>
			<tbody>
				<c:forEach var="seller" items="${sellerList }">
					<tr>
						<td align="right" ><a href="${contextPath}/seller/sellerDetail?s_id=${seller.s_id}&flag=0">${seller.s_id}</a></td>
						<td align="center">${seller.s_pwd}</td>
						<td align="center">${seller.s_name }</td>
						<c:choose>
							<c:when test="${seller.s_RRC != null}">
								<td  align="right">${seller.s_RRC}</td>
							</c:when>
							<c:otherwise>
								<td  align="right">${seller.s_BRN}</td>
							</c:otherwise>
						</c:choose>
						<td align="right">${seller.s_email}</td>
						<td align="right">${seller.s_address2}&nbsp;${seller.s_address3}</td>
						<td align="right"><fmt:formatDate value="${seller.s_joindate}" pattern="yyyy.MM.dd  hh:mm"/></td>
						<td align="right">${seller.s_phone}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		
		<div class="row justify-content-center">
		  <div class="col-sm-2">
		    <select id="searchType" class="form-select">
		      <option selected disabled>검색종류</option>
		      <option value="s_id" ${searchType == 's_id' ? 'selected' : ''}>아이디</option>
		      <option value="s_name" ${searchType == 's_name' ? 'selected' : ''}>이름</option>
		    </select>
		  </div>
		  <div class="col-sm-2">
		    <input type="text" id="searchKeyword" class="form-control" value="${keyword }"/>
		  </div>
		  <div class="col-sm-1">
		    <button id="searchBtn" class="btn btn-danger w-100">검색</button>
		  </div>
		</div>
		
		<div class="row justify-content-center" id="paging">
		  <div class="col-sm-8">
		    <ul class="btn-group pagination d-flex justify-content-center">
		      <c:if test="${pageMaker.prev}">
		        <li>
		          <a href='<c:url value="/seller/serList?page=${pageMaker.startPage-1}&searchType=${searchType}&keyword=${keyword}"/>'>
		            <span class="glyphicon glyphicon-chevron-left"></span>
		          </a>
		        </li>
		      </c:if>
		      <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
		        <li>
		          <a href='<c:url value="/seller/serList?page=${pageNum}&searchType=${searchType}&keyword=${keyword}"/>'>
		            <i>${pageNum}</i>
		          </a> 
		        </li>
		      </c:forEach>
		      <c:if test="${pageMaker.next}">
		        <li>
		          <a href='<c:url value="/seller/serList?page=${pageMaker.endPage+1}&searchType=${searchType}&keyword=${keyword}"/>'>
		            <span class="glyphicon glyphicon-chevron-right"></span>
		          </a>
		        </li>
		      </c:if>
		    </ul>
		  </div>
		</div>
		<form id="formList" action="/seller/sellerList" method="get">
			<input type="hidden" name="searchType" value="${ searchType}"/>
			<input type="hidden" name="keyword" value="${keyword}"/>
		</form>
	
	</div>
<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"/>

<script src="/resources/js/seller.js"></script>
</body>
</html>