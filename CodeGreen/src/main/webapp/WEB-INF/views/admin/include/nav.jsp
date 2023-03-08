<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Code Green Admin Side-bar</title>

     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
     <link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"/>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sidebars/">
    <!-- Custom styles for this template -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	<link href="../../resources/css/admin/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="../../resources/css/admin/nav.css" rel="stylesheet">
  </head>
  <body>

<main class="d-flex flex-nowrap">
<nav>
  <div class="d-flex flex-column flex-shrink-0 p-3 sidebar">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <i class="fa-solid fa-leaf fs-2"></i>
      <span class="fs-2">&nbsp;Code Green</span>
    </a>
    <hr>
    <ul class="nav flex-column mb-auto">
      <li class="nav-item">
        <a href="#" class="nav-link text-white current" aria-current="page">
            <i class="fa-solid fa-house"></i>
          Home
        </a>
      </li>
      <li>
        <a href="${contextPath}/order/orderManage" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-credit-card"></i>
          주문 관리
        </a>
      </li>
      <li>
        <a href="${contextPath}/admin/product/register" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-box-open"></i>
          상품 등록
        </a>
      </li>
      <li>
        <a href="${contextPath}/admin/product/list" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-box-open"></i>
          상품 목록
        </a>
      </li>
      <li>
        <a href="${contextPath}/buyer/buyerList" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-user"></i>
          구매자 목록
        </a>
      </li>
      <li>
        <a href="${contextPath}/seller/sellerList.do" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-user"></i>
          판매자 목록
        </a>
      </li>
      <li>
        <a href="${contextPath}/CS/board/NoticeList?n_bc_code=0" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-headset"></i>
          고객센터
        </a>
      </li>
    </ul>
    <hr>
    <div class="dropdown">
      
      <c:choose>
		<c:when test="${isLogOn == true && manager != null}">
			<strong style="color: white;"><b>${manager.m_name}님, 즐거운 시간되십시오.</b></strong>
			<a href="${contextPath}/manager/logout.do" class="btn btn-danger">
				<span class="glyphicon glyphicon-log-out"></span> 로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="${contextPath}/manager/manager_loginForm.do" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
       			<img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
        		<strong>Manager LogIn</strong>
      		</a>
		</c:otherwise>
	</c:choose>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
        <li><a class="dropdown-item" href="#">Settings</a></li>
        <li><a class="dropdown-item" href="#">Profile</a></li>
        <li><hr class="dropdown-divider"></li>
        <li><a class="dropdown-item" href="#">Sign out</a></li>
      </ul>
    </div>
  </div>
</nav>
</main>

  <script src="https://kit.fontawesome.com/a995061e9a.js" crossorigin="anonymous"></script>

</body>
</html>
