package com.greener.codegreen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.dto.ProductAvgCntDTO;
import com.greener.codegreen.service.DashboardService;

@Controller("dashboardController")
@RequestMapping("/dashboard")
public class DashboardController {
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private DashboardService dashboardService;
	
	
	/*
	 * 구매 상품 주문 수량 평균
	 */
	@RequestMapping("/dash")
	public ModelAndView ProductAvg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/dash/productAvg");
		List<ProductAvgCntDTO> dtoList = dashboardService.getProductAvgCntInfo(15);
		return mav;
	}
}
