<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
	<link href="../../resources/css/admin/product.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- 사이드 바 -->
<jsp:include page="../include/nav.jsp"></jsp:include>
	<div class="container">
		<h2>상품 정보 수정</h2>
		<form role = "form" method="post" autocomplete="off">
		
		<input type = "hidden" name="p_number" value="${product.p_number}"/>
		
			<div class = "inputArea">
				<label>1차 분류</label>
				<select class="category1">
					<option value=""></option>
				</select>
				<br>
				<label>2차 분류</label>
				<select class="category2" name="c_code">
					<option value=""></option>
				</select>
			</div>	
			<div class="inputArea">
				 <label for="productName">상품명</label>
				 <input type="text" id="p_name" name="p_name" value="${product.p_name}"/>
			</div>
				
			<div class="inputArea">
				 <label for="productPrice">상품가격</label>
				 <input type="text" id="p_price" name="p_price" value="${product.p_price}"/>
			</div>
				
			<div class="inputArea">
				 <label for="productContent">상품소개</label>
				 <textarea rows="5" cols="50" id="p_content" name="p_content">${product.p_content}</textarea>
			</div>
				
			<div class="inputArea">
				 <label for="productStock">상품수량</label>
				 <input type="text" id="p_stock" name="p_stock" value="${product.p_stock}"/>
			</div>
				
			<div class="inputArea">
				 <label for="productMade">원산지</label>
				 <input type="text" id="p_made" name="p_made" value="${product.p_made}"/>
			</div>
				
			<div class="inputArea">
				 <label for="productUsedate">유통/소비기한</label>
				 <input type="text" id="p_usedate" name="p_usedate" value="${product.p_usedate}"/>
			</div>
				
				
			<div class="inputArea">
				 <button type="submit" id="update_Btn" class="btn btn-primary">완료</button>
				 <button type="submit" id="back_Btn" class="btn btn-primary">취소</button>
				 
				<script>
					$("#back_Btn").click(function(){
						//history.back();
						location.href = "/admin/product/view?n=" + ${product.p_number};
					});
				</script>
			</div>	
		</form>
	</div>
	
<script>
//컨트롤러에서 데이터 받기
var jsonData = JSON.parse('${category}');
console.log(jsonData);

var cate1Arr = new Array();
var cate1Obj = new Object();

// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
for(var i = 0; i < jsonData.length; i++) {
 
 if(jsonData[i].c_level == "1") {
  cate1Obj = new Object();  //초기화
  cate1Obj.c_code = jsonData[i].c_code;
  cate1Obj.c_name = jsonData[i].c_name;
  console.log(cate1Obj);
  cate1Arr.push(cate1Obj);
 }
}

// 1차 분류 셀렉트 박스에 데이터 삽입
var cate1Select = $("select.category1")

for(var i = 0; i < cate1Arr.length; i++) {
 cate1Select.append("<option value='" + cate1Arr[i].c_code + "'>"
      + cate1Arr[i].c_name + "</option>"); 
}

$(document).on("change", "select.category1", function(){

	 var cate2Arr = new Array();
	 var cate2Obj = new Object();
	 
	 // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
	 for(var i = 0; i < jsonData.length; i++) {
	  
	  if(jsonData[i].c_level == "2") {
	   cate2Obj = new Object();  //초기화
	   cate2Obj.c_code = jsonData[i].c_code;
	   cate2Obj.c_name = jsonData[i].c_name;
	   cate2Obj.c_code_ref = jsonData[i].c_code_ref;
	   
	   cate2Arr.push(cate2Obj);
	  }
	 }
	 
	 var cate2Select = $("select.category2");
	 
	 /*
	 for(var i = 0; i < cate2Arr.length; i++) {
	   cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
	        + cate2Arr[i].cateName + "</option>");
	 }
	 */
	 
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
	 
	});
	
	var select_c_code = '${product.product_c_code}';
	var select_c_code_ref = '${product.c_code_ref}';
	var select_c_name = '${product.c_name}';
	
	if(select_c_code_ref != null && select_c_code_ref != ''){
		$(".category1").val(select_c_code_ref);
		$(".category2").val(select_c_code);
		$(".category1").children().remove();
		$(".category2").append("<option value='"
			       + select_c_code + "'>" + select_c_name + "</option>");
		
	} else {
		$(".category1").select_c_code;
		$(".category2").append("<option value="' + select_c_code + '" selected='selected'>전체</option>");
	}


</script>
</body>
</html>