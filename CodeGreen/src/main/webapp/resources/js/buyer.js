/**
 *  소비자 jsp 스크립트. 
 */

// 조건 검색 스크립트
$(document).ready(function(){
	var	formObj	=	$("#formList");
	
	// 검색 버튼을 눌렀을 경우
	$("#searchBtn").click(function(){
		var typeStr	=	$("#searchType").find(":selected").val();
		var keywordStr	=	$("#searchKeyword").val();
//		alert(typeStr + ":" +keywordStr);
		
		// 서버로 전송하기 전에, name 속성에 값을 넣어준다.
		formObj.find("[name='searchType']").val(typeStr);
		formObj.find("[name='keyword").val(keywordStr);
		formObj.find("[name='page").val("1");
		formObj.submit();
	});
});

//----------------------------------------------------------------------------------------------------------
// 소비자 번호에 해당하는 상세페이지로 이동하기
//----------------------------------------------------------------------------------------------------------
function fn_buyerDetail(b_id) {
	location.href = "/buyer/buyerDetail?b_id=" +b_id + "&flag=1";	
} // End - function fn_boardDetail(b_id)
