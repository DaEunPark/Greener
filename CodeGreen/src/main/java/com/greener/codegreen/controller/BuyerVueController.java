package com.greener.codegreen.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.PaymentCartDTO;
import com.greener.codegreen.service.BuyerService;


@RestController
//@RequestMapping("/buyer")
public class BuyerVueController {
 
	private static final Logger logger = LoggerFactory.getLogger(BuyerVueController.class);
	@Autowired
	private	BuyerDTO	buyerDTO;
	
	@Inject
	private BuyerService buyerService;
	

	@PostMapping(value="/buyer/CancelList")
	@CrossOrigin(origins="http://localhost:8080")
	public @ResponseBody String mypage(@RequestBody BuyerDTO mypage) throws Exception {
		// 현재 구매자 정보 반환
		buyerDTO = buyerService.getmypage(mypage);
		// 현재 구매자의 결제 예정 장바구니 목록 반환
		List<BuyerDTO> mypagelist = buyerService.getmypagelist(mypage);
		logger.info("PaymentController paymentInfo() 장바구니 목록 확인 : " + mypagelist);
		
		
		Gson gson = new GsonBuilder().create();
		HashMap<String, Object> mypagemap = new HashMap<String, Object>();
		mypagemap.put("mypage", buyerDTO);
		mypagemap.put("mypageList", mypagelist);
		
		logger.info("Controller  GSON 변환 : " + gson.toJson(mypagemap));
		logger.info(gson.toJson(mypagemap));
		//System.out.println(mypagemap);
		return gson.toJson(mypagemap);
	}
}
	
	
 	//-----------------------------------------------------------------------------------------------------------
	// �Խ��� ��� ��������
	//-----------------------------------------------------------------------------------------------------------
//	@GetMapping("/buyer/mypage")
//	public List<BuyerDTO> buyerList() throws Exception {
//		
////		List<BuyerDTO> buyerList = buyerService.buyerList();
//		return null;
//		
//	} // End - �Խ��� ��� ��������
//
//	//-----------------------------------------------------------------------------------------------------------
//	// �Խñ� ��ȣ�� �ش��ϴ� �Խñ� ������ ��������
//	//-----------------------------------------------------------------------------------------------------------
//	@GetMapping("/buyer/{b_id}")
//	public BuyerDTO buyerDetail(@PathVariable String b_id) throws Exception {
//
//		logger.info("VueBoardController boardDetail() bno ==> " + b_id);
//
//		return null; /*buyerService.buyerDetail(b_id);*/
//	}
//}