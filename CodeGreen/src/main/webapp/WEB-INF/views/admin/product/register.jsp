<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
	<link href="../../resources/css/admin/product.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../../resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="../include/nav.jsp"></jsp:include>
	<div class="container">
		<h2>상품등록</h2>
		<form role = "form" method="post" autocomplete="off" enctype="myltipart/form-data">
			<label>1차 분류</label>
			<select class="category1">
				<option selected value="none">전체</option>
			</select>
			<br>
			<label>2차 분류</label>
			<select class="category2" name="c_code">
				<option selected value="none">전체</option>
			</select>
			
			<div class="inputArea">
			 <label for="productName">상품명</label>
			 <input type="text" id="p_name" name="p_name" />
			</div>
			
			<div class="inputArea">
			 <label for="productPrice">상품가격</label>
			 <input type="text" id="p_price" name="p_price" />
			</div>
			
			<div class="inputArea">
			 <label for="productContent">상품소개</label>
			 <textarea rows="5" cols="50" id="p_content" name="p_content"></textarea>
			 <script>
			   var ckeditor_config = {
			     resize_enaleb : false,
			     enterMode : CKEDITOR.ENTER_BR,
			     shiftEnterMode : CKEDITOR.ENTER_P,
			     filebrowserUploadUrl : "/admin/product/ckUpload"
			   };
			   
			   CKEDITOR.replace("p_content", ckeditor_config);
			</script>
			</div>
			
			<div class="inputArea">
			 <label for="productStock">상품수량</label>
			 <input type="text" id="p_stock" name="p_stock" />
			</div>
			
			<div class="inputArea">
			 <label for="productMade">원산지</label>
			 <input type="text" id="p_made" name="p_made" />
			</div>
			
			<div class="inputArea">
			 <label for="productUsedate">유통/소비기한</label>
			 <input type="text" id="p_usedate" name="p_usedate" />
			</div>
			
			
			<div class="inputArea">
			 <button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
			</div>
			
		</form>
	</div>
	
<script>
// 컨트롤러에서 데이터 받기
var jsonData = JSON.parse('${category}');

var cate1Arr = new Array();
var cate2Arr = new Array();
var cate1Obj = new Object();
var cate2Obj = new Object();
var cateSelect1 = $(".category1")
var cateSelect2 = $(".category2");


// 셀렉트 박스에 삽입할 데이터 준비

for(var i = 0; i < jsonData.length; i++) {
	if(jsonData[i].c_level == "1") {
		cate1Obj = new Object();  //초기화
		
		cate1Obj.c_name = jsonData[i].c_name;
		cate1Obj.c_code = jsonData[i].c_code;
		cate1Obj.c_code_ref = jsonData[i].c_code_ref;
		
		cate1Arr.push(cate1Obj);
 	}
}
for(var i = 0; i < jsonData.length; i++) {
	if(jsonData[i].c_level == "2") {
		cate2Obj = new Object();  //초기화
		
		cate2Obj.c_name = jsonData[i].c_name;
		cate2Obj.c_code = jsonData[i].c_code;
		cate2Obj.c_code_ref = jsonData[i].c_code_ref;
		
		cate2Arr.push(cate2Obj);
 	}
}

$(document).ready(function(){
	console.log(cate1Arr);
	console.log(cate2Arr);
});

/* 대분류 <option> 태그 */
for(let i = 0; i < cate1Arr.length; i++){
	cateSelect1.append("<option value='"+cate1Arr[i].c_code+"'>" + cate1Arr[i].c_name + "</option>");
	}

/* 중분류 <option> 태그 */
$(cateSelect1).on("change", function(){
	
	let selectVal = $(this).find("option:selected").val();	
	$("option:selected", this).each(function(){

		cateSelect2.children().remove();
		
		cateSelect2.append("<option value='none'>전체</option>")
	
		for(let i = 0; i < cate2Arr.length; i++){
			if(selectVal == cate2Arr[i].c_code_ref){
				cateSelect2.append("<option value='" + cate2Arr[i].c_code + "'>" + cate2Arr[i].c_name + "</option>");	
			}
		}// for
	});
});
/*
$(document).on("change", ".category1", function(){
	 
	 /*
	 for(var i = 0; i < cate2Arr.length; i++) {
	   cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
	        + cate2Arr[i].cateName + "</option>");
	 }
	 */
	 
	 /*
	 cate2Select.children().remove();

	 $("option:selected", this).each(function(){
	  
	  var selectVal = $(this).val();  
	  
	  cate2Select.append("<option value='" + selectVal + "'>전체</option>");
	  
	  for(var i = 0; i < cate2Arr.length; i++) {
	   if(selectVal == cate2Arr[i].c_code_ref) {
	    cate2Select.append("<option value='" + cate2Arr[i].c_code + "'>"
	         + cate2Arr[i].c_name + "</option>");
	   }
	  }
	  
	});
	 */

</script>

<script>
var regExp = /[^0-9]/gi;

$("#p_price").keyup(function(){ numCheck($(this)); });
$("#p_stock").keyup(function(){ numCheck($(this)); });

function numCheck(selector) {
   var tempVal = selector.val();
   selector.val(tempVal.replace(regExp, ""));
}
</script>
</body>
</html>