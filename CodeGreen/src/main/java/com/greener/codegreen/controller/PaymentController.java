package com.greener.codegreen.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.PaymentCartDTO;
import com.greener.codegreen.service.PaymentService;

@Controller("paymentController")
@RequestMapping("/payment")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private	BuyerDTO	buyerDTO;
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping(value="/paymentInfo")
	@CrossOrigin(origins="http://localhost:8080")
	public @ResponseBody String paymentInfo(@RequestBody BuyerDTO buyerId) throws Exception {
		// 현재 구매자 정보 반환
		buyerDTO = paymentService.getBuyerInfo(buyerId);
		// 현재 구매자의 결제 예정 장바구니 목록 반환
		List<PaymentCartDTO> cartList = paymentService.getPaymentCartList(buyerId);
		logger.info("PaymentController paymentInfo() 장바구니 목록 확인 : " + cartList);
		
		Gson gson = new GsonBuilder().create();
		HashMap<String, Object> payInfo = new HashMap<String, Object>();
		payInfo.put("bInfo", buyerDTO);
		payInfo.put("cartList", cartList);
		
		logger.info("PaymentController paymentInfo() GSON 변환 : " + gson.toJson(payInfo));
		return gson.toJson(payInfo);
	}
}
