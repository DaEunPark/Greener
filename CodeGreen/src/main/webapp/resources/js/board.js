/**
 *	게시글 관련 함수
 */
 
 //----------------------------------------------------------------------------------------------------------
 // 게시글 등록
 //----------------------------------------------------------------------------------------------------------
 function fn_boardRegister() {
	
	 alert("게시글 등록 버튼을 눌렀습니다.");

	// 게시글 등록 화면에서 입력한 값을 가져온다.
	let	p_number	  = $("#p_number").val(); 	 
	let	p_name	      = $("#p_name").val();
	let	p_price	      = $("#p_price").val();
	let	p_content     = $("#p_content").val();
	let	p_stock	      = $("#p_stock").val();
	let	p_view	      = $("#p_view").val();
	let	p_made	      = $("#p_made").val();
	let	p_usedate	  = $("#p_usedate").val();
	let	product_c_code= $("#product_c_code").val();
	

	
	$.ajax({
		type:		"POST",
		url:		"/board/boardRegister",
		data:		{p_number:p_number,
					 p_stock:p_stock, 
					 p_view:p_view, 
					 p_made:p_made, 
					 p_usedate:p_usedate, 
					 product_c_code:product_c_code,
					 p_name:p_name, 
					 p_price:p_price, 
					 p_content:p_content},
		success:	function(data) {
			if(data == "Y") {
				alert("게시글을 등록하였습니다.");
				// 게시글 등록이 완료되면, 게시글 목록 화면으로 이동한다.
				location.href = "/board/boardList";
			}
		},
		error:		function(data) {
			alert("게시글을 등록하는데 실패하였습니다!");
		}
	});
	
} // End - function fn_boardRegister()

 /*
//----------------------------------------------------------------------------------------------------------
// 게시글 번호에 해당하는 게시글 삭제하기
//----------------------------------------------------------------------------------------------------------
function fn_boardDelete(bno) {
	
	// 삭제를 진행하기 전에 먼저 삭제여부를 확인한다.
	if(!confirm("\n게시글을 삭제하시겠습니까?\n\n삭제하려면 [확인]버튼을 누르시고, 아니면 [취소]버튼을 누르십시오.")) {
		alert("게시글 삭제를 취소하셨습니다.");
	} else {	// [확인]버튼을 눌렀을 경우
		$.ajax({
			type:			"POST",
			url:			"/board/boardDelete",
			data:			{bno : bno},
			success:		function(data) {
				if(data == "Y") {
					alert("게시글의 삭제가 완료되었습니다.");
					location.href = "/board/boardList";
				}
			},
			error:			function(data) {
				alert("게시글을 삭제하는데 문제가 발생하였습니다.");
			},
			done:			function(data) {
				alert("요청 성공");
			},
			fail:			function(data) {
				alert("요청 실패");
			},
			always:			function(data) {
				alert("요청 완료");
			}
		});
	}
	
} // End - function fn_boardDelete(bno)

 
//----------------------------------------------------------------------------------------------------------
// 게시글 수정 화면 불러오기
// form에 action과 method가 없기 때문에 여기에서 만든다.
// <form action="/board/boardUpdateForm", method="POST">
// 전송할 bno를 담아 놓은 것이 없으므로, input을 만들어서 bno를 서버에 전송한다.
// form.append($('만들태그', {태그에 사용할 속성 : 값, 속성 : 값, ......}));
//----------------------------------------------------------------------------------------------------------
function fn_boardUpdateForm(bno) {
	
	var f = $("#frm");
	f.attr("action", "/board/boardUpdateForm?flag=1");
	f.attr("method", "POST");
	// <input type="hidden"  name="bno" value="${boardDetail.bno}"/>
	f.append($('<input/>', {type: 'hidden', name: 'bno', value: bno}));
	f.appendTo('body');
	f.submit();
	
} // End - function fn_boardUpdateForm(bno)

//----------------------------------------------------------------------------------------------------------
// 게시글 번호에 해당하는 게시글의 내용(제목, 글쓴이, 내용)을 수정 요청하기
//----------------------------------------------------------------------------------------------------------
function fn_boardUpdate() {
	
	let	bno		= $("#bno").val();
	let	subject	= $("#subject").val();
	let	writer	= $("#writer").val();
	let	content	= $("#content").val();
	
	// alert(bno + ":" + subject + ":" + writer + ":" + content);
	
	$.ajax({
		type:			"POST",
		url:			"/board/boardUpdate",
		data:			{bno:bno, subject:subject, writer:writer, content:content},
		success:		function(data) {
			if(data == "Y") {
				alert("게시글 수정이 완료되었습니다.");
				fn_boardDetail(bno);
			} else {
				alert("게시글 수정이 되지 않았습니다.\n\n잠시 후에 다시 해주십시오.");
			}
		},
		error:			function(data) {
			alert("실패");
			console.log(data);
		}
	});
	
} // End - function fn_boardUpdate()

//----------------------------------------------------------------------------------------------------------
// 게시글 번호에 해당하는 상세페이지로 이동하기
//----------------------------------------------------------------------------------------------------------
function fn_boardDetail(bno) {
	location.href = "/board/boardDetail?bno=" + bno + "&flag=1";	
} // End - function fn_boardDetail(bno)
*/











