package com.greener.codegreen.controller;

import java.util.List;

import javax.inject.Inject;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.greener.codegreen.dto.BoardDTO;
import com.greener.codegreen.service.BoardService;


@CrossOrigin
@RestController
public class VueBoardController {

	
	@Inject
	private BoardService boardService;
	
	//-----------------------------------------------------------------------------------------------------------
	// VUE 연결 faq 게시판 전체 목록 가져오기 f_bc_code=0
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/csfaqlist")   //앞에 /CS/board/ 가 들어가야함
	public List<BoardDTO> FaqList() throws Exception {
//	public String FaqList(HttpServletRequest request, HttpServletResponse response,int f_bc_code)
//		throws Exception {
		
		List<BoardDTO> FaqList = boardService.FaqList(0);
		return FaqList;
	}// gson 사용 안함
//		List<BoardDTO> FaqList = boardService.FaqList(f_bc_code);
//		Gson gson = new GsonBuilder().create();
//		
//		System.out.println("GSon Data Binding......");
//		System.out.println(gson.toJson(FaqList));
//		return gson.toJson(FaqList);
//	} 

	//-----------------------------------------------------------------------------------------------------------
	// VUE 연결 faq 게시글 번호에 해당하는 게시글 정보를 가져오기
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/csfaqlist/{f_no}")
	public BoardDTO FaqDetail(@PathVariable int f_no) throws Exception {

	System.out.println("faqDetail f_no ==> " + f_no);

		return boardService.FaqDetail(f_no);
		
	}




	
	
	
	
	
	
}
