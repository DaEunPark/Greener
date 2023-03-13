package com.greener.codegreen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	//-----------------------------------------------------------------------------------------------------------
	//대시보드 테스트
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = {"/visit.do", "/visit"}, method = RequestMethod.POST)
	public String managerMain() {
		
		System.out.println("대시보드 테스트 진행 중입니다.");
		return "visit";
	}
}
