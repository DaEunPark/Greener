<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 게시글 등록폼</title>
<!--  부트스트랩 5.2.3 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
   <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
 	<script src="${contextPath}/resources/js/CSboard.js"></script>
  
</head>
<!-- <jsp :include page="../common/topMenu.jsp" flush="false"/>-->
<body>


<!--관리자의 게시글 등록화면 : 새로 만들어야함 -->
<div class="container">
	<form class="form-horizontal" name="boardRegisterForm">
		<div class="form-group">
			<div class="col-sm-12">
				<h2 align="center">공지사항 관리자 등록폼</h2>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">제  목</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="m_title" name="m_title" maxlength="200" placeholder="제목 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">관리자</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="m_writer" name="m_writer" maxlength="20" placeholder="글쓴이 입력"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">타입</label>
		<select class="form-select form-select-sm" aria-label="Default select example" title="문의유형을 선택하세요" id="m_type" name="m_type" >
			  <option value="0" selected>공지사항/이벤트</option>
			  <option value="1">회원/멤버십</option>
			  <option value="2">주문/결제</option>
			  <option value="3">배송</option>
			  <option value="4">상품</option>	
		</select>
	 </div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">내  용</label>
			<div class="col-sm-8">
				<textarea class="form-control" id="m_content" name="m_content" rows="10" cols="160"  placeholder="내용 입력"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 left">
				<button type="reset"  class="btn btn-warning">다시 입력</button>
				<button type="button" class="btn btn-primary" onclick="fn_formInsert();">게시글 등록</button>
			</div>
		</div>	
	</form>
</div>


</body>
</html>




 

  
