package com.greener.codegreen.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.BoardDAO;
import com.greener.codegreen.dto.BoardDTO;




@Service  //bean에 인식
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);


	@Inject //의존주입
	private BoardDAO boardDAO;

	
//----------------------------------------------------------------------------	
// 공지사항, FAQ 등록처리 
//----------------------------------------------------------------------------		
		
	//공지사항 등록처리
	@Override
	public int NoticeUpForm(BoardDTO baordDTO) throws Exception {
	
		logger.info("NoticeUpForm Serviceimpl 지나가는중....  "+ baordDTO );	
		
		return boardDAO.NoticeUpForm(baordDTO);
		
	}
	//FAQ 등록처리
	@Override
	public int FaqUpForm(BoardDTO baordDTO) throws Exception {
	
		logger.info("FaqUpForm Serviceimpl 지나가는중....  " + baordDTO);	
		
		return boardDAO.FaqUpForm(baordDTO);
	}

//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 목록보기 
//----------------------------------------------------------------------------		

	//공지사항 전체 목록
	@Override
	public List<BoardDTO> NoticeList() throws Exception {
		//ManagerDTO 를 List형태로 만들면 목록을 리스트로 받을수있음
		
		logger.info("NoticeList Serviceimpl 지나가는중....  ");	
		
		return boardDAO.NoticeList(); 
		//리턴한 값을 컨트롤러로 가져가서 model로 받아온다?
	}
	//FAQ 전체 목록
	@Override
	public List<BoardDTO> FaqList() throws Exception {

		logger.info("FaqList Serviceimpl 지나가는중....  ");	
		
		return boardDAO.FaqList(); 
	}
	//1:1 전체목록
	@Override
	public List<BoardDTO> InquiryList() throws Exception {

		logger.info("InquiryList Serviceimpl 지나가는중....  ");	
		
		return boardDAO.InquiryList();
	}
	
///----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 상세보기 (조회) + 수정후 중복 처리도 같이
//----------------------------------------------------------------------------
		
	//공지사항 조회(상세보기)
	@Override
	public BoardDTO NoticeDetail(int n_no ) throws Exception {   //, int flag)
		logger.info("NoticeDetail Serviceimpl 상세조회시작  ");	
		
//		//증복처리 
//		if(flag == 0 ) {
//			managerDAO.nupdateCount(n_no);
//		}
	 return boardDAO.NoticeDetail(n_no);
	}
	//FAQ 조회(상세보기)
	@Override
	public BoardDTO FaqDetail(int f_no) throws Exception {       // ,int flag
		logger.info("FaqDetail Serviceimpl 상세조회시작  ");
		
//		//증복처리 
//			if(flag == 0 ) {
//				managerDAO.fupdateCount(f_no);
//			}
	     return boardDAO.FaqDetail(f_no);
		
	}
	//1:1 조회(상세보기)
	@Override
	public BoardDTO InquiryDetail(int i_no) throws Exception {
		logger.info("InquiryDetail Serviceimpl 상세조회시작  ");	
		
		
		return boardDAO.InquiryDetail(i_no);
	}
	
//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 게시글 번호에 해당하는 게시글 삭제하기 
//----------------------------------------------------------------------------	
	@Override
	public int NoticeDelete(int n_no) {
		
		return boardDAO.NoticeDelete(n_no);
	}
	@Override
	public int FaqDelete(int f_no) {
		
		return boardDAO.NoticeDelete(f_no);
	}
	@Override
	public int InquiryDelete(int i_no) {
		
		return boardDAO.NoticeDelete(i_no);
	}
//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 게시글 번호에 해당하는 게시글 내용(넣어준 컬럼들) 수정
//----------------------------------------------------------------------------	
	@Override
	public int NoticeUpdate(BoardDTO baordDTO) {
		
		return boardDAO.NoticeUpdate(baordDTO);
	}
	@Override
	public int FaqUpdate(BoardDTO baordDTO) {
		
		return boardDAO.FaqUpdate(baordDTO);
	}
	@Override
	public int InquiryUpdate(BoardDTO baordDTO) {
		
		return boardDAO.InquiryUpdate(baordDTO);
	}
//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1  페이징처리 
//----------------------------------------------------------------------------		
	// 공지사항 게시물 총갯수
	@Override
	public int ncount() throws Exception {
		
		return boardDAO.ncount();
	}
	// 공기사항 게시물 목록 + 페이징
	@Override
	public List<BoardDTO> NoticeListPage(int displayPost, int postNum) throws Exception {
		
		return boardDAO.NoticeListPage(displayPost, postNum);
	}
	
	// FAQ 게시물 총갯수
	@Override
	public int fcount() throws Exception {
		
		return boardDAO.fcount();
	}
	// FAQ 게시물 목록 + 페이징
	@Override
	public List<BoardDTO> FaqListPage(int displayPost, int postNum) throws Exception {
		
		return boardDAO.FaqListPage(displayPost, postNum);
	}
	
	
	
	
	
	
	
	
	

	
}//public class ManagerServiceImpl implements ManagerService
