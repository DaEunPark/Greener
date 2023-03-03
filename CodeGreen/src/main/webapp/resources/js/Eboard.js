/**
 * 게시글 관련 스크립트
 * 제이쿼리가 있는 파일에서 사용해야함 
*/
 
 //-------------------------------------
 // 공지사항 등록
 //-------------------------------------
 function fn_NoticeUpForm() {
 
	alert("게시글 등록 버튼 누름 확인용");   
 
 	//jsp 파일의 name과 같아야함
 	let n_title 	= $("#n_title").val();
 	let n_bc_code   = $("#n_bc_code").val();
 	let	n_m_id		= $("#n_m_id").val();
	let	n_content	= $("#n_content").val();
	
	alert(n_title + ":" + n_bc_code + ":" +  n_m_id + ":" + n_content + "확인함");
	
	// 제목 항목에 값이 없으면 입력하도록 한다.
	if($("#n_title").val() == "") {
		alert("제목은 필수 입력 항목입니다.");
		$("#n_title").focus();
		return false;
	}
	
	// 타입 항목에 값이 없으면 입력하도록 한다.
	if($("#n_bc_code").val() == "") {
		alert("문의사항은 필수 입력 항목입니다.");
		$("#n_bc_code").focus();
		return false;
	}
	
	// 관리자 항목에 값이 없으면 입력하도록 한다.
	if($("#n_m_id").val() == "") {
		alert("작성자의 ID는 필수 입력 항목입니다.");
		$("#n_m_id").focus();
		return false;
	}
	
	// 내용 항목에 값이 없으면 입력하도록 한다.
	if($("#n_content").val() == "") {
		alert("내용은 필수 입력 항목입니다.");
		$("#n_content").focus();
		return false;
	}
	
	$.ajax({
		type: "POST",
		url:  "NoticeUpForm",
		data:  { n_title : n_title, n_bc_code : n_bc_code , n_m_id : n_m_id , n_content : n_content },
		success:  function(data) {
			if(data == "Y") {
			alert("등록되었습니다");
			location.href = "/CS/board/NoticeList";
		}
	},
	error:  function(data) {
		alert("등록 실패");
		}
	});
 }// 공지사항 등록 끝
	//-------------------------------------
	// FAQ 등록
	//-------------------------------------
	 function fn_FaqUpForm() {
 	
		 alert("클릭");
 
			let f_title 	= $("#f_title").val();
		 	let f_bc_code   = $("#f_bc_code").val();
		 	let	f_m_id		= $("#f_m_id").val();
			let	f_content	= $("#f_content").val();
			
			alert(f_title + ":" + f_bc_code + ":" +  f_m_id + ":" + f_content + "확인함");
			
			// 제목 항목에 값이 없으면 입력하도록 한다.
			if($("#f_title").val() == "") {
				alert("제목은 필수 입력 항목입니다.");
				$("#f_title").focus();
				return false;
			}
			
			// 타입 항목에 값이 없으면 입력하도록 한다.
			if($("#f_bc_code").val() == "") {
				alert("문의사항은 필수 입력 항목입니다.");
				$("#f_bc_code").focus();
				return false;
			}
			
			// 관리자 항목에 값이 없으면 입력하도록 한다.
			if($("#f_m_id").val() == "") {
				alert("작성자의 ID는 필수 입력 항목입니다.");
				$("#f_m_id").focus();
				return false;
			}
			
			// 내용 항목에 값이 없으면 입력하도록 한다.
			if($("#f_content").val() == "") {
				alert("내용은 필수 입력 항목입니다.");
				$("#f_content").focus();
				return false;
			}
			
			$.ajax({
				type: "POST",
				url:  "FaqUpForm",
				data:  { f_title : f_title, f_bc_code : f_bc_code , f_m_id : f_m_id , f_content : f_content },
				success:  function(data) {
					if(data == "Y") {
					alert("등록되었습니다");
					location.href = "/CS/board/FaqList";
				}
			},
			error:  function(data) {
				alert("등록 실패");
				}
			});
		 }//FAQ 등록 끝 
	 
	 //----------------------------------------------------------------------------------------------------------
	 // 공지사항 수정 -  GET인 NoticeDetail 에서 수정을 클릭했을때 넘어가는 NoticeUpdate 페이지의 요청url POST 페이지
	 //----------------------------------------------------------------------------------------------------------
	 function fn_NoticeUpdateForm(n_no) { 

		 var f = $("#frm");
		 f.attr("action","/CS/board/NoticeUpdateForm?flag=1");
		 f.attr("method","POST");
		//<input type="hidden" name="n_no" value="${NoticeDetail.n_no}" />
		f.append($('<input/>', {type:'hidden',name: 'n_no', value:n_no}));
		f.appendTo('body');
		f.submit();


	 }//End -fn_NoticeUpdateForm
	 
	 //----------------------------------------------------------------------------------------------------------
	 // 공지사항 수정 요청  - POST페이지에서 수정을 클릭했을때 성공하면 넘어가는 POST 인 NoticeUpdate 페이지
	 //----------------------------------------------------------------------------------------------------------
	function fn_NoticeUpdate() {

		alert("test1");

		let n_no   			 = $("#n_no").val(); 	   //게시글 번호 hidden처리됨
		let n_bc_code	     = $("#n_bc_code").val();  //카테고리
		let n_title	  		 = $("#n_title").val();    //제목
		let n_m_id  		 = $("#n_m_id").val();     //작성자id
		let n_content  		 = $("#n_content").val();  //내용
		
		alert(n_no + ":" + n_title + ":" + n_bc_code + ":" + n_m_id + ":" + n_content);

		$.ajax({
				type:			"POST",
				url:			"NoticeUpdate",
				//보내줄 데이터
				data:			{ n_no: n_no,n_bc_code : n_bc_code , n_title : n_title , n_m_id : n_m_id , n_content : n_content},   
				success:		function(data) {
					if(data == "Y") {
						alert("게시글 수정이 완료되었습니다.");
						fn_noticeDetail(n_no);   //완료되면 상세페이지로 이동시킴
					} else {
						alert("게시글 수정이 되지 않았습니다.\n\n잠시후 다시 해주세여.");
					}
				},
				error:			function(data) {
					alert("게시글 수정하는데 문제가 발생하였습니다.");
					console.log(data);
				}
			});

	}//End - fn_NoticeUpdate
	 //----------------------------------------------------------------------------------------------------------
	 // 수정이 완료되었을 경우 게시글 번호에 해당하는 상세페이지로 이동하기 
	 //----------------------------------------------------------------------------------------------------------
		function fn_noticeDetail(n_no) { 
		location.href = "/CS/board/NoticeDetail?n_no=" + n_no + "&flag=1";
		
		
	}//END- fn_noticeDetail
	 //----------------------------------------------------------------------------------------------------------
	 // FAQ 수정 -  GET인 FaqDetail 에서 수정을 클릭했을때 넘어가는 FaqUpdate 페이지의 요청url POST 페이지
	 //----------------------------------------------------------------------------------------------------------
	 function fn_FaqUpdateForm(f_no) { 

		 var f = $("#frm");
		 f.attr("action","/CS/board/FaqUpdateForm?flag=1");
		 f.attr("method","POST");
		 f.append($('<input/>', {type:'hidden',name: 'f_no', value:f_no}));
		 f.appendTo('body');
		 f.submit();


	 }//End -fn_FaqUpdateForm
	 
	 //----------------------------------------------------------------------------------------------------------
	 // FAQ 수정 요청  - POST페이지에서 수정을 클릭했을때 성공하면 넘어가는 POST 인 NoticeUpdate 페이지
	 //----------------------------------------------------------------------------------------------------------
	 function fn_FaqUpdate() {

		alert("test1");

		let f_no   			 = $("#f_no").val(); 	   //게시글 번호 hidden처리됨
		let f_bc_code	     = $("#f_bc_code").val();  //카테고리
		let f_title	  		 = $("#f_title").val();    //제목
		let f_m_id  		 = $("#f_m_id").val();     //작성자id
		let f_content  		 = $("#f_content").val();  //내용
		
		alert(f_no + ":" + f_bc_code + ":" + f_title + ":" + f_m_id + ":" + f_content);

		$.ajax({
			type:			"POST",
			url:			"FaqUpdate",
			//보내줄 데이터
			data:			{ f_no: f_no , f_bc_code : f_bc_code , f_title : f_title , f_m_id : f_m_id , f_content : f_content },   
			success:		function(data) {
				if(data == "Y") {
					alert("게시글 수정이 완료되었습니다.");
					fn_faqDetail(f_no);   //완료되면 상세페이지로 이동시킴
				} else {
					alert("게시글 수정이 되지 않았습니다.\n잠시후 다시 해주세요.");
				}
			},
			error:			function(data) {
				alert("게시글 수정하는데 문제가 발생하였습니다.");
				console.log(data);
			}
		});

	}//End - fn_FaqUpdate
	 //----------------------------------------------------------------------------------------------------------
	 // 수정이 완료되었을 경우 게시글 번호에 해당하는 상세페이지로 이동하기 
	 //----------------------------------------------------------------------------------------------------------
		function fn_faqDetail(f_no) { 
		location.href = "/CS/board/FaqDetail?f_no=" + f_no + "&flag=1";
		
		
	}//END- fn_faqDetail
			
	 //----------------------------------------------------------------------------------------------------------
	 // 공지사항 삭제
	 //----------------------------------------------------------------------------------------------------------
		function fn_NoticeDelete(bno) {
			
			//삭제여부 확인 
			if(!confirm("\n게시글을 삭제하시겠습니까?\n\n삭제하려면 [확인] , 아니면 [취소] 버튼을 누르십시오.")) {
				alert("게시글 삭제를 취소하셨습니다");
			} else {
				$.ajax({
					type: 	"POST",
					url: 	"NoticeDelete",
					data:   {n_no : n_no },
					success: function(data) {
						if(data == "Y") {
							alert("게시글의 삭제가 완료되었습니다");
							location.href ="/CS/board/NoticeList";
					}
				},
				error:	  function(data) {
						alert("게시글을 삭제하는데 문제가 발생하였습니다.");
				},
				done: 	   function(data) {
						alert("요청 성공");
				},
				fail:	   function(data) {
						alert("요청 실패");
				},
				always: 	function(data) {
						alert("요청 완료");
				}
				
			});
		}
	}//공지사항 삭제 끝
		
		
		
		
		

//	
//	function    fn_goCashList(){
//		
//	}
//	function	fn_goDeliveryList(){
//		
//	}
//	function	fn_goProductList(){
//		
//	}
//	function	fn_goEventList(){
//		
//	}
//
//	
	
	
	
	
