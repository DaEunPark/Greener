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
	// �Խ��� ��� ��������
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/buyer/mypage")
	public List<BuyerDTO> buyerList() throws Exception {
		
//		List<BuyerDTO> buyerList = buyerService.buyerList();
		return null;
		
	} // End - �Խ��� ��� ��������

	//-----------------------------------------------------------------------------------------------------------
	// �Խñ� ��ȣ�� �ش��ϴ� �Խñ� ������ ��������
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/buyer/{b_id}")
	public BuyerDTO buyerDetail(@PathVariable String b_id) throws Exception {

		logger.info("VueBoardController boardDetail() bno ==> " + b_id);

		return null; /*buyerService.buyerDetail(b_id);*/
	}
}