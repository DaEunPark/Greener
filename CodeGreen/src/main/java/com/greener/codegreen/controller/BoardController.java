package com.greener.codegreen.controller;


import java.util.List;
import java.util.Locale;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;


import com.greener.codegreen.dao.BoardDAO;
import com.greener.codegreen.dto.BoardDTO;
import com.greener.codegreen.service.BoardService;



//----------------------------------------------------
//게시글 관리 컨트롤러
//----------------------------------------------------

@Controller
@RequestMapping(value="/CS/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject 
	private BoardService boardService;
	@Inject
	private BoardDAO boardDAO;


	//----------------------------------------------------------------------
	// 공지사항 작성하기화면불러오기 NoticeForm.jsp
	//----------------------------------------------------------------------
	@RequestMapping(value = "/NoticeForm", method = RequestMethod.GET)
	public String NoticeForm( ) throws Exception {
		
		logger.info("boardController 게시글 화면 불러오기() 시작");
		
		return"/CS/board/NoticeForm";
	}//공지사항 작성화면을 불러오기
	
	//공지사항 등록하기
	@ResponseBody
	@RequestMapping(value = "/NoticeUpForm", method = RequestMethod.POST)	
		
	public String NoticeUpForm(BoardDTO boardDTO) throws Exception {
	
		logger.info("boardController 게시글 작성등록하기() 시작");
		logger.info("boardDTO 값 : " + boardDTO);
		
		if(boardService.NoticeUpForm(boardDTO) == 1) {	// 게시글 등록 완료
			return "Y";
		} else {	// 게시글 등록 실패
			return "N";
		}
		
	}//공지사항 작성한걸 등록하기 
	
	//----------------------------------------------------------------------
	// FAQ 작성하기화면불러오기 FaqForm.jsp
	//----------------------------------------------------------------------
	@RequestMapping(value = "/FaqForm", method = RequestMethod.GET)
	public String FaqForm( ) throws Exception {
	   
		return"/CS/board/FaqForm";
	}//FAQ작성화면을 불러오기
	
	//FAQ 등록하기
	@ResponseBody
	@RequestMapping(value = "/FaqUpForm", method = RequestMethod.POST)	
		
	public String FaqUpForm(BoardDTO boardDTO) throws Exception {
	
		logger.info("boardController 게시글 작성등록하기() 시작");
		logger.info("BoardDTO 값 : " + boardDTO);
		
		if(boardService.FaqUpForm(boardDTO) == 1) {	// 게시글 등록 완료 -- JS와연결됨
			return "Y";
		} else {	// 게시글 등록 실패
			
			return "N";
		}
		
	}//FAQ 작성한걸 등록하기 
	
//------------------------------------------------------------------------------------------------	
	
	//----------------------------------------------------------------------
	// vue 에서 faq전체 목록 뿌려주기 
	//----------------------------------------------------------------------
	
	@CrossOrigin
	@ResponseBody
	@GetMapping ("/Ffaqlist")
	public List<BoardDTO> FaqListVue(int f_bc_code) throws Exception {
		
		List<BoardDTO> FaqList = boardService.FaqList(f_bc_code);
		return FaqList;
	} 
	
	
//	//----------------------------------------------------------------------
//	// vue 에서 faq전체 목록 뿌려주기 - 게시글 번호에 해당하는 게시글 정보가져오기
//	//----------------------------------------------------------------------
//	@GetMapping("/Ffaqlist/{f_no}")
//	public BoardDTO FaqDetail(@PathVariable int f_no) throws Exception {
//
//		logger.info("BoardController FaqDetail() f_no ==> " + f_no);
//
//		return boardService.FaqDetail(f_no);
//	}
//	//----------------------------------------------------------------------
//	// vue 에서 Notice 전체 목록 뿌려주기 
//	//----------------------------------------------------------------------
//	
//	@CrossOrigin
//	@ResponseBody
//	@GetMapping ("/Nnoticelist/{n_bc_code}")
//	public List<BoardDTO> NoticeList(@PathVariable int n_bc_code) throws Exception {
//		
//		List<BoardDTO> NoticeList = boardService.NoticeList(n_bc_code);
//		return NoticeList;
//		
//	} 
//	//----------------------------------------------------------------------
//	// vue 에서 Notice 전체 목록 뿌려주기  - 게시글 번호에 해당하는 게시글 정보가져오기
//	//----------------------------------------------------------------------
//	@GetMapping("/Nnoticelist/{n_no}")
//	public BoardDTO NoticeDetail(@PathVariable int n_no) throws Exception {
//
//		logger.info("BoardController NoticeDetail() n_no ==> " + n_no);
//
//		return boardService.NoticeDetail(n_no);
//	}

	
//------------------------------------------------------------------------------------------------	


	
	//----------------------------------------------------------------------
	// 공지사항 전체 목록보기 NoticeList.jsp 
	//----------------------------------------------------------------------
	@RequestMapping( value="/NoticeList" , method= RequestMethod.GET)
	public void NoticeList(Model model , Locale locale ,HttpServletRequest request) throws Exception {
		
		int n_bc_code = Integer.parseInt((String) request.getParameter("n_bc_code"));
		
		List<BoardDTO> NoticeList = boardService.NoticeList(n_bc_code);
		
		logger.info("NoticeList() Controller" + NoticeList );	
		
		model.addAttribute("NoticeList",NoticeList);
		//NoticeList 에 데이터가 저장되어있다 이걸로 NoticeList.jsp에서데이터값뿌려줌
		
	}//공지사항 전체 목록보기
	
	//----------------------------------------------------------------------
	// FAQ 전체 목록보기 FaqList.jsp   : 앞으로의 전체목록보기는 
	// FaqList?f_bc_code=0 형식으로 보아야함  
	//----------------------------------------------------------------------
	@RequestMapping( value="/FaqList" , method= RequestMethod.GET)
	public void FaqList(Model model,Locale locale, HttpServletRequest request) throws Exception {
		
		int f_bc_code = Integer.parseInt((String) request.getParameter("f_bc_code"));
		
		List<BoardDTO> FaqList = boardService.FaqList(f_bc_code);
		
		logger.info("FaqList( )   Controller " + FaqList);
		
		model.addAttribute("FaqList",FaqList);
		
	}//FAQ 전체 목록보기
	//----------------------------------------------------------------------
	// 1:1 문의 전체 목록보기 InquiryList.jsp
	//----------------------------------------------------------------------
	@RequestMapping( value="/InquiryList" , method= RequestMethod.GET)
	public void InquiryList(Model model,Locale locale , HttpServletRequest request) throws Exception {
		
		int i_bc_code = Integer.parseInt((String) request.getParameter("i_bc_code"));
		
		List<BoardDTO> InquiryList = boardService.InquiryList(i_bc_code);
		
		logger.info("InquiryList( ) Controller " + InquiryList );	
		
		model.addAttribute("InquiryList",InquiryList);
		
	}//1:1 문의 전체 목록보기

//--------------------------------------------------------------------------------------------------	
	
	
	//----------------------------------------------------------------------
	// 	공지사항 조회(상세보기) NoticeDetail.jsp
	//----------------------------------------------------------------------
	@RequestMapping(value="/NoticeDetail", method=RequestMethod.GET)
	public String NoticeDetail(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 공지사항 상세조회 " +
				Integer.parseInt((String) request.getParameter("n_no")));
		
		//수정후 조회수 중복에 대한 처리  - B
		int n_no = Integer.parseInt((String) request.getParameter("n_no"));
		//int flag = Integer.parseInt((String) request.getParameter("flag"));
		
		//게시글 번호에 해당하는 게시글의 정보를 가져온다 
		BoardDTO boardDTO  = boardService.NoticeDetail(n_no); //,flag);
		
		//넘겨주는 모델의 이름이 NoticeDetail 로 설정
		model.addAttribute("NoticeDetail", boardDTO);
		return"/CS/board/NoticeDetail";
	}

	//----------------------------------------------------------------------
	// 	FAQ 조회(상세보기) FaqDetail.jsp
	//----------------------------------------------------------------------
	@RequestMapping(value="/FaqDetail", method=RequestMethod.GET)
	public String FaqDetail(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController FAQ 상세조회 " +
				Integer.parseInt((String) request.getParameter("f_no")));
		
		int f_no = Integer.parseInt((String) request.getParameter("f_no"));
		//int flag = Integer.parseInt((String) request.getParameter("flag"));
		
		//게시글 번호에 해당하는 게시글의 정보를 가져온다 
		BoardDTO boardDTO  = boardService.FaqDetail(f_no);  //,flag);
		
		model.addAttribute("FaqDetail", boardDTO);
		return"/CS/board/FaqDetail";
	}

	//----------------------------------------------------------------------
	// 	1:1 문의 조회(상세보기) InquiryDetail.jsp
	//----------------------------------------------------------------------
	@RequestMapping(value="/InquiryDetail", method=RequestMethod.GET)
	public String InquiryDetail(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 1:1 상세조회 " +
				Integer.parseInt((String) request.getParameter("i_no")));
		
		int i_no = Integer.parseInt((String) request.getParameter("i_no"));
	
		
		//게시글 번호에 해당하는 게시글의 정보를 가져온다 
		BoardDTO boardDTO  = boardService.InquiryDetail(i_no);
		
		model.addAttribute("InquiryDetail", boardDTO);
		return"/CS/board/InquiryDetail";
	}
	
	
//---------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------
	// 공지사항 게시글 번호에 해당하는 게시글 삭제하기 
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/NoticeDelete" ,  method=RequestMethod.POST)
	public String NoticeDelete(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 게시글 번호에 해당하는 게시글 삭제하기  " +
				
				request.getParameter("n_no"));
		
		if(boardService.NoticeDelete(Integer.parseInt((String)request.getParameter("n_no")))  == 1) {
			return "Y";
		}else {
			return "N";
		}
		
	}//게시글 번호에 해당하는 게시글 삭제하기()
	
	//-----------------------------------------------------------------------------------------------------------
	// FAQ 게시글 번호에 해당하는 게시글 삭제하기 
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/FaqDelete" ,  method=RequestMethod.POST)
	public String FaqDelete(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 게시글 번호에 해당하는 게시글 삭제하기  " +
				
				request.getParameter("f_no"));
		
		if(boardService.FaqDelete(Integer.parseInt((String)request.getParameter("f_no")))  == 1) {
			return "Y";
		}else {
			return "N";
		}
		
	}//게시글 번호에 해당하는 게시글 삭제하기()
	//-----------------------------------------------------------------------------------------------------------
	// 1:1 게시글 번호에 해당하는 게시글 삭제하기 
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/InquiryDelete" ,  method=RequestMethod.POST)
	public String InquiryDelete(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 게시글 번호에 해당하는 게시글 삭제하기  " +
				
				request.getParameter("i_no"));
		
		if(boardService.InquiryDelete(Integer.parseInt((String)request.getParameter("i_no")))  == 1) {
			return "Y";
		}else {
			return "N";
		}
		
	}//게시글 번호에 해당하는 게시글 삭제하기()
	
	
//------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------
	// 공지사항 수정화면 불러오기  : 조회수 증가 안됨
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/NoticeUpdateForm" ,  method=RequestMethod.POST)
	public String NoticeUpdateForm(Model model, HttpServletRequest request) throws Exception {
	
		logger.info("BoardController 수정화면 불러오기() 시작 "); 
		//수정후 조회수 중복에 대한 처리  - B
		int n_no = Integer.parseInt((String) request.getParameter("n_no"));
		//int flag = Integer.parseInt((String) request.getParameter("flag"));
		
		BoardDTO boardDTO = boardService.NoticeDetail(n_no);   //,flag);
		
		//넘겨줄때 모델에 담아서 가져간다 
		model.addAttribute("NoticeDetail", boardDTO);
		return"/CS/board/NoticeUpdate";
		
	}//게시글 수정화면 불러오기
	
	//-----------------------------------------------------------------------------------------------------------
	// 공지사항 게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/NoticeUpdate", method=RequestMethod.POST)
	public String NoticeUpdate(Model model, BoardDTO boardDTO)  throws Exception {
		logger.info("BoardController 게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기() 시작 "); 
	
		
		if(boardService.NoticeUpdate(boardDTO) == 1) {
			return "Y";
		} else {
			return "N";
		}
		
	}//게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
	
	
	//-----------------------------------------------------------------------------------------------------------
	// FAQ 수정화면 불러오기  : 조회수 증가 안됨
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/FaqUpdateForm" ,  method=RequestMethod.POST)
	public String FaqUpdateForm(Model model, HttpServletRequest request) throws Exception {
	
		logger.info("BoardController 수정화면 불러오기() 시작 "); 
		//수정후 조회수 중복에 대한 처리  - B
		int f_no = Integer.parseInt((String) request.getParameter("f_no"));
		//int flag = Integer.parseInt((String) request.getParameter("flag"));
		
		BoardDTO boardDTO = boardService.FaqDetail(f_no);  //,flag);
		
		//넘겨줄때 모델에 담아서 가져간다 
		model.addAttribute("FaqDetail", boardDTO);
		return"/CS/board/FaqUpdate";
		
	}//게시글 수정화면 불러오기
	
	//-----------------------------------------------------------------------------------------------------------
	// FAQ 게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/FaqUpdate", method=RequestMethod.POST)
	public String FaqUpdate(Model model, BoardDTO boardDTO)  throws Exception {
		logger.info("BoardController 게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기() 시작 "); 
	
		
		if(boardService.FaqUpdate(boardDTO) == 1) {
			return "Y";
		} else {
			return "N";
		}
		
	}//게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
	
	
	//-----------------------------------------------------------------------------------------------------------
	// 1:1  수정화면 불러오기 : 소비자 답변 받는 곳 
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/InquiryUpdateForm" ,  method=RequestMethod.POST)
	public String InquiryUpdateForm(Model model, HttpServletRequest request) throws Exception {
	
		logger.info("BoardController 수정화면 불러오기() 시작 "); 
		//수정후 조회수 중복에 대한 처리  
		int i_no = Integer.parseInt((String) request.getParameter("i_no"));
	
		
		BoardDTO boardDTO = boardService.InquiryDetail(i_no);
		
		//넘겨줄때 모델에 담아서 가져간다 
		model.addAttribute("InquiryDetail", boardDTO);
		return"/CS/board/InquiryUpdate";
		
	}//게시글 수정화면 불러오기
	
	//-----------------------------------------------------------------------------------------------------------
	// 1:1 게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/InquiryUpdate", method=RequestMethod.POST)
	public String InquiryUpdate(Model model, BoardDTO boardDTO)  throws Exception {
		logger.info("boardController 게시글 번호에 해당하는 게시글 내용 수정하기() 시작 "); 
	
		
		if(boardService.InquiryUpdate(boardDTO) == 1) {
			return "Y";
		} else {
			return "N";
			
		}
	}//게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
		
	
	// 리스트 양을 많이 안할거라 우선 페이징 처리 안함 - 따로 빼둠 

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//public class ManagerController 게시판 관리 컨트롤러

