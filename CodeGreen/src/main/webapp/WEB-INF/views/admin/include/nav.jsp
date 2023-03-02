<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Code Green Admin Side-bar</title>

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
        <a href="#" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-credit-card"></i>
          주문 관리
        </a>
      </li>
      <li>
        <a href="/admin/product/list" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-box-open"></i>
          상품 관리
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-user"></i>
          회원 관리
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white sidebar-link">
            <i class="fa-solid fa-headset"></i>
          고객센터
        </a>
      </li>
    </ul>
    <hr>
    <div class="dropdown">
      <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
        <strong>Manager</strong>
      </a>
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
