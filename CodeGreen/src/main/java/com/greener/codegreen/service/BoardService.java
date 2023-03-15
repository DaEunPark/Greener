package com.greener.codegreen.service;

import java.util.List;

import com.greener.codegreen.dto.BoardDTO;


public interface BoardService {
	

//----------------------------------------------------------------------------	
// 공지사항, FAQ 등록처리 
//----------------------------------------------------------------------------		
	
	//공지사항 작성등록
	public int NoticeUpForm(BoardDTO boardDTO) throws Exception;
	//FAQ 작성등록
	public int FaqUpForm(BoardDTO boardDTO) throws Exception;
	
	
//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 목록보기 
//----------------------------------------------------------------------------		

	//공지사항 전체 목록 
	public List<BoardDTO> NoticeList(int n_bc_code) throws Exception;
	//FAQ 전체 목록
	public List<BoardDTO> FaqList(int f_bc_code) throws Exception;
	//1:1 전체목록
	public List<BoardDTO> InquiryList(int i_bc_code ) throws Exception;
	
//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 상세보기 (조회) 
//----------------------------------------------------------------------------
	
	//공지사항 조회(상세보기)
	public BoardDTO NoticeDetail(int n_no) throws Exception;
	//FAQ 조회(상세보기)
	public BoardDTO FaqDetail(int f_no) throws Exception;  
	//1:! 조회(상세보기)
	public BoardDTO InquiryDetail(int i_no) throws Exception;
		
//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 게시글 번호에 해당하는 게시글 삭제하기 
//----------------------------------------------------------------------------	
	public int NoticeDelete(int n_no);  
	public int FaqDelete(int f_no); 
	public int InquiryDelete(int i_no); 
	
//----------------------------------------------------------------------------	
// 공지사항, FAQ ,1:1 게시글 번호에 해당하는 게시글 내용(넣어준 컬럼들) 수정
//----------------------------------------------------------------------------	
	public int NoticeUpdate(BoardDTO boardDTO); 
	public int FaqUpdate(BoardDTO boardDTO); 
	public int InquiryUpdate(BoardDTO boardDTO); 


	
}//public interface BoardService
