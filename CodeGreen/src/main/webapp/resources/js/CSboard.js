/**
 * 게시글 관련 스크립트
*/
 
 //-------------------------------------
 // 관리자 게시글 등록 1 - 게시글 등록
 //-------------------------------------
 function fn_formInsert() {
 
	alert("게시글 등록 버튼 누름 확인용");
 
 	//jsp 파일의 id 값과 같아야 확인 가능
 	let m_title 	= $("#m_title").val();
 	let m_type      = $("#m_type").val();
 	let	m_writer	= $("#m_writer").val();
	let	m_content	= $("#m_content").val();
	
	alert(m_title + ":" + m_type + ":" +  m_writer + ":" + m_content + "확인함");
	
	// 제목 항목에 값이 없으면 입력하도록 한다.
	if($("#m_title").val() == "") {
		alert("제목은 필수 입력 항목입니다.");
		$("#m_title").focus();
		return false;
	}
	
	// 타입 항목에 값이 없으면 입력하도록 한다.
	if($("#m_type").val() == "") {
		alert("문의사항은 필수 입력 항목입니다.");
		$("#m_type").focus();
		return false;
	}
	
	// 작성자 항목에 값이 없으면 입력하도록 한다.
	if($("#m_writer").val() == "") {
		alert("작성자는 필수 입력 항목입니다.");
		$("#m_writer").focus();
		return false;
	}
	
	// 내용 항목에 값이 없으면 입력하도록 한다.
	if($("#m_content").val() == "") {
		alert("내용은 필수 입력 항목입니다.");
		$("#m_content").focus();
		return false;
	}
	
	$.ajax({
		type: "POST",
		url:  "/CS/board/CSboard",
		data:  {m_title:m_title, m_type:m_type, m_writer:m_writer, m_content:m_content},
		success:  function(data) {
			if(data == "Y") {
			alert("등록되었습니다");
			location.href = "/CS/board/CSboardList";
		}
	},
	error:  function(data) {
		alert("등록 실패");
		}
	});
	
	
	//-------------------------------------------------------------------------------
	//CSboardDetail.jsp  게시판 상세보기 에서 
	//게시글 번호에 해당하는 게시글 수정/삭제처리 - 수정하기 위한 input 생성
	//.attr 속성 추가 
	//.append 덧붙이다 
	//수정화면 CSboardDetail.jsp 에서 변경되는 것임
	//-------------------------------------------------------------------------------
	
	function fn_csboardUpdateForm(m_bno) {
	
		 var f = $("#frm");
		 
		 f.attr("action","/CS/board/CSboardUpdateForm?flag=1");
		 f.attr("method","POST");
		//<input type="hidden" name="m_bno" value="${CSboardDetail.m_bno}" />
		f.append($('<input/>', {type:'hidden',name: 'm_bno', value:m_bno}));
		f.appendTo('body');
		f.submit();


 }//End -function fn_csboardUpdateForm(m_bno)

	//-------------------------------------------------------------------------------
	//CSboardDetail.jsp  게시판 상세보기 에서 
	//게시글 번호에 해당하는 게시글 수정/삭제처리 - 수정요청 CSboardUpdate
	//-------------------------------------------------------------------------------
	function fn_csboardUpdate() {

	alert("수정요청이 된건가요");

	let m_bno      		= $("#m_bno").val();
	let m_title	  		= $("#m_title").val();
	let m_type			= $("#m_type").val();
	let m_writer		= $("#m_writer").val();
	let m_content  		= $("#m_content").val();
	
	alert(m_bno + ":" + m_title + ":" + m_type + ":" + m_writer + ":" + m_content);

	$.ajax({
			type:			"POST",
			url:			"/CS/board/CSboardUpdate",
			//보내줄 데이터
			data:			{m_bno : m_bno , m_title : m_title , m_type : m_type , m_writer : m_writer , m_content:m_content},   
			success:		function(data) {
				if(data == "Y") {
					alert("게시글 수정이 완료되었습니다.");
					fn_csboardDetail(m_bno);   //완료되면 상세페이지로 이동시킴 - 아래적음
				} else {
					alert("게시글 수정이 되지 않았습니다.\n\n잠시후 다시 해주세여.");
				}
			},
			error:			function(data) {
					alert("게시글 수정하는데 문제가 발생하였습니다.");
					console.log(data);
			}
		});

}//End - function fn_csboardUpdate() 
	
	 //----------------------------------------------------------------------------------------------------------
	 // 게시글 수정 완료후 게시글 번호에 해당하는 상세페이지로 이동하기 CSboardDetail
	 //----------------------------------------------------------------------------------------------------------
		function fn_csboardDetail(m_bno) { 
		location.href = "/CS/board/CSboardDetail?m_bno=" + m_bno + "&flag=1";
		
		
		}//END- function fn_csboardDetail(m_bno)
		

	

	 //----------------------------------------------------------------------------------------------------------
	 ////CSboardDetail.jsp  게시판 상세보기 에서 
	 //게시글 번호에 해당하는 게시글 수정/삭제처리 - 삭제 처리 CSboardDelete
	 //----------------------------------------------------------------------------------------------------------
	function fn_csboardDelete(m_bno) {
		
		// 삭제를 진행하기 전에 먼저 삭제여부를 확인한다.
		if(!confirm("\n게시글을 삭제하시겠습니까?\n\n삭제하려면 [확인]버튼을 누르시고, 아니면 [취소]버튼을 누르십시오.")) {
			alert("게시글 삭제를 취소하셨습니다.");
		} else {	// [확인]버튼을 눌렀을 경우
			$.ajax({
				type:			"POST",
				url:			"/CS/board/CSboardDelete",
				data:			{m_bno : m_bno},
				success:		function(data) {
					if(data == "Y") {
						alert("게시글의 삭제가 완료되었습니다.");
						location.href = "/CS/board/CSboardList";
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
	
} // End - function fn_csboardDelete(m_bno)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 }//fn_formInsert()