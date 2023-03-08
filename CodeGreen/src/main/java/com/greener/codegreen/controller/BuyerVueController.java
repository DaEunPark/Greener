package com.greener.codegreen.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.service.BuyerService;

@CrossOrigin
@RestController
public class BuyerVueController {
 
	private static final Logger logger = LoggerFactory.getLogger(BuyerVueController.class);
	
	@Inject
	private BuyerService buyerService;
	

 	//-----------------------------------------------------------------------------------------------------------
	// 게시판 목록 가져오기
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/buyer/mypage")
	public List<BuyerDTO> buyerList() throws Exception {
		
		List<BuyerDTO> buyerList = buyerService.buyerList();
		return buyerList;
		
	} // End - 게시판 목록 가져오기

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 정보를 가져오기
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/buyer/{b_id}")
	public BuyerDTO buyerDetail(@PathVariable String b_id) throws Exception {

		logger.info("VueBoardController boardDetail() bno ==> " + b_id);

		return buyerService.buyerDetail(b_id);
	}
}