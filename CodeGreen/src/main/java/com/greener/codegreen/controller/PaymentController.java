package com.greener.codegreen.controller;

import java.util.HashMap;

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
		BuyerDTO buyerDTO = paymentService.getBuyerInfo(buyerId);
		Gson gson = new GsonBuilder().create();
		HashMap<String, Object> payInfo = new HashMap<String, Object>();
		payInfo.put("bInfo", buyerDTO);
		
		logger.info("PaymentController paymentInfo() GSON 변환 : " + gson.toJson(payInfo));
		return gson.toJson(payInfo);
	}
}
