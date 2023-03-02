/**
 *  판매자 jsp 스크립트. 
 */

// 조건 검색 스크립트
$(document).ready(function(){
	var	formObj	=	$("#formList");
	
	// 검색 버튼을 눌렀을 경우
	$("#searchBtn").click(function(){
		var typeStr	=	$("#searchType").find(":selected").val();
		var keywordStr	=	$("#searchKeyword").val();
		alert(typeStr + ":" +keywordStr);
		
		// 서버로 전송하기 전에, name 속성에 값을 넣어준다.
		formObj.find("[name='searchType']").val(typeStr);
		formObj.find("[name='keyword").val(keywordStr);
		formObj.find("[name='page").val("1");
		formObj.submit();
	});
});