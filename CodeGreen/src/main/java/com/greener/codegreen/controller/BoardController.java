package com.greener.codegreen.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//----------------------------------------------------------------------
	// 1:1 작성하기화면불러오기 InquiryForm.jsp
	//----------------------------------------------------------------------

	//1:1 작성하는것  vue와 연결해줄 부분 
	
	
	
	
	
	
	
	
	
//--------------------------------------------------------------------------------------------------	
	
	
	//----------------------------------------------------------------------
	// 공지사항 전체 목록보기 NoticeList.jsp  - CSbaordform 에서 등록시 fn_formInsert() 의 리턴 / vscode에서 경로 사용됨
	//----------------------------------------------------------------------
	@RequestMapping( value="/NoticeList" , method= RequestMethod.GET)
	public void NoticeList(Model model , Locale locale ) throws Exception {
		
		List<BoardDTO> NoticeList = boardService.NoticeList();
		
		logger.info("NoticeList() Controller" + NoticeList );	
		
		model.addAttribute("NoticeList",NoticeList);
		//NoticeList 에 데이터가 저장되어있다 이걸로 NoticeList.jsp에서데이터값뿌려줌
	}//공지사항 전체 목록보기
	
	//----------------------------------------------------------------------
	// FAQ 전체 목록보기 FaqList.jsp
	//----------------------------------------------------------------------
	@RequestMapping( value="/FaqList" , method= RequestMethod.GET)
	public void FaqList(Model model,Locale locale) throws Exception {
		
		List<BoardDTO> FaqList = boardService.FaqList();
		
		logger.info("FaqList( )   Controller " + FaqList);
		
		model.addAttribute("FaqList",FaqList);
		
	}//FAQ 전체 목록보기
	//----------------------------------------------------------------------
	// 1:1 문의 전체 목록보기 InquiryList.jsp
	//----------------------------------------------------------------------
	@RequestMapping( value="/InquiryList" , method= RequestMethod.GET)
	public void InquiryList(Model model,Locale locale) throws Exception {
		
		List<BoardDTO> InquiryList = boardService.InquiryList();
		
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
		//수정후 조회수 중복에 대한 처리  - B
		int i_no = Integer.parseInt((String) request.getParameter("i_no"));
	
		
		BoardDTO boardDTO = boardService.InquiryDetail(i_no);
		
		//넘겨줄때 모델에 담아서 가져간다 
		model.addAttribute("InquiryDetail", boardDTO);
		return"/board/InquiryUpdate";
		
	}//게시글 수정화면 불러오기
	
	//-----------------------------------------------------------------------------------------------------------
	// 1:1 게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/InquiryUpdate", method=RequestMethod.POST)
	public String InquiryUpdate(Model model, BoardDTO boardDTO)  throws Exception {
		logger.info("boardController 게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기() 시작 "); 
	
		
		if(boardService.InquiryUpdate(boardDTO) == 1) {
			return "Y";
		} else {
			return "N";
		}
		
	}//게시글 번호에 해당하는 게시글 내용(제목, 카테고리, 작성자, 내용) 수정하기
	
	
	//----------------------------------------------------------------------------	
	// 공지사항, FAQ ,1:1  페이징처리 - NoticeListPage.jsp 
	//----------------------------------------------------------------------------	
	
	//공지사항 게시물 목록 + 페이징 추가 : 파람으로 넣어준 num은 페이지 번호임
	@RequestMapping(value="/NoticeListPage" , method=RequestMethod.GET)
	public void NoticeListPage(Model model , @RequestParam("num") int num) throws Exception {
		
		// 1번째 생각할 것 
		//게시물 총 갯수 
		int ncount = boardService.ncount();
		
		//한 페이지에 출력할 게시물 갯수 
		int postNum = 10;
		
		//하단 페이징 번호(게시물 총 갯수 / 한 페이지에 출력할 갯수 의 올림형태)
		int pageNum  = (int)Math.ceil((double)ncount/postNum);
		
		//출력할 게시물 
		int displayPost = (num - 1) * postNum;
		
		// 2번째 생각할 것 
		//한번에 표시할 페이징 번호의 갯수 
		int pageNum_cnt = 3;
		
		//표시되는 페이지 번호 중 마지막 번호 
		int endPageNum  = (int)(Math.ceil((double)num / (double)pageNum_cnt)* pageNum_cnt);
		
		//표시되는 페이지 번호 중 첫번째 번호 
		int startPageNum  = endPageNum - (pageNum_cnt - 1);
		
		//3번째 생각할 것 
		//마지막 번호 재계산 
		int endPageNum_tmp = (int)(Math.ceil((double)ncount / (double)postNum));
		 
		// 계산후 마지막 페이지 번호를 서로 비교
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		
		//이전과 다음 조건문 : 이전링크는 시작페이지가 1일땐 제외하곤 무조건 출력되어야함
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * postNum >= ncount ? false : true;
		
		
		List<BoardDTO> NoticeList = null;
		NoticeList = boardService.NoticeListPage(displayPost, postNum);
		
		model.addAttribute("NoticeList",NoticeList);
		model.addAttribute("pageNum",pageNum);
		
		//시작 및 끝 번호 뷰 출력을 위함 
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		//이전 및 다음 뷰 출력을 위함 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		//현재 페이지 - num을 모델에 select이란 이름으로 보냄 
		model.addAttribute("select",num);
		model.addAttribute("ncount",ncount);
	}
	
	
	// FAQ 게시물 목록 + 페이징 추가 : 파람으로 넣어준 num은 페이지 번호임
		@RequestMapping(value="/FaqListPage" , method=RequestMethod.GET)
		public void FaqListPage(Model model , @RequestParam("num") int num) throws Exception {
			
			// 1번째 생각할 것 
			//게시물 총 갯수 
			int fcount = boardService.fcount();
			
			//한 페이지에 출력할 게시물 갯수 
			int postNum = 10;
			
			//하단 페이징 번호(게시물 총 갯수 / 한 페이지에 출력할 갯수 의 올림형태)
			int pageNum  = (int)Math.ceil((double)fcount/postNum);
			
			//출력할 게시물 
			int displayPost = (num - 1) * postNum;
			
			// 2번째 생각할 것 
			//한번에 표시할 페이징 번호의 갯수 
			int pageNum_cnt = 5;
			
			//표시되는 페이지 번호 중 마지막 번호 
			int endPageNum  = (int)(Math.ceil((double)num / (double)pageNum_cnt)* pageNum_cnt);
			
			//표시되는 페이지 번호 중 첫번째 번호 
			int startPageNum  = endPageNum - (pageNum_cnt - 1);
			
			//3번째 생각할 것 
			//마지막 번호 재계산 
			int endPageNum_tmp = (int)(Math.ceil((double)fcount / (double)postNum));
			 
			// 계산후 마지막 페이지 번호를 서로 비교
			if(endPageNum > endPageNum_tmp) {
			 endPageNum = endPageNum_tmp;
			}
			
			//이전과 다음 조건문 : 이전링크는 시작페이지가 1일땐 제외하곤 무조건 출력되어야함
			boolean prev = startPageNum == 1 ? false : true;
			boolean next = endPageNum * postNum >= fcount ? false : true;
			
			
			List<BoardDTO> FaqList = null;
			FaqList = boardService.FaqListPage(displayPost, postNum);
			
			model.addAttribute("FaqList",FaqList);
			model.addAttribute("pageNum",pageNum);
			
			//시작 및 끝 번호 뷰 출력을 위함 
			model.addAttribute("startPageNum", startPageNum);
			model.addAttribute("endPageNum", endPageNum);
			
			//이전 및 다음 뷰 출력을 위함 
			model.addAttribute("prev", prev);
			model.addAttribute("next", next);
			
			//현재 페이지 - num을 모델에 select이란 이름으로 보냄 
			model.addAttribute("select",num);
			model.addAttribute("fcount",fcount);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


////-------------------------------------------------------------------------------------------	
//	
//	//vue 와 연결하기 위한 컨트롤러 - 따로 컨트롤러이후까지 이동안함
//	//@RestController 사용안하고 일일히 적어줌
//	//-----------------------------------------------------------------------------------------------------------
//	// VUE 연결 공지사항 게시판 목록 가져오기 //noticelist jsp 는 없음, GSON 사용안함
//	//-----------------------------------------------------------------------------------------------------------
//	@CrossOrigin
//	@ResponseBody
//	@GetMapping("/noticelist")   //앞에 /CS/board/ 가 들어가야함
//	public List<BoardDTO> CSboardList() throws Exception {
//		
//		List<BoardDTO> CSboardList = boardService.CSboardList();
//		return CSboardList;
//		
//	} // End - VUE 연결 공지사항 게시판 목록 가져오기
//
//	//-----------------------------------------------------------------------------------------------------------
//	// VUE 연결 공지사항 게시글 번호에 해당하는 게시글 정보를 가져오기
//	//-----------------------------------------------------------------------------------------------------------
//	@CrossOrigin
//	@ResponseBody
//	@GetMapping("/noticelist/{m_bno}")
//	public BoardDTO CSboardDetail(@PathVariable int m_bno) throws Exception {
//
//		logger.info(" vue BoardController CSboardDetail() m_bno ==> " + m_bno);
//
//		return boardService.CSboardDetail(m_bno, 1);
//		
//	}//END - VUE 연결 공지사항 게시글 번호에 해당하는 게시글 정보를 가져오기
//	
//	
	
	
}//public class ManagerController 게시판 관리 컨트롤러

