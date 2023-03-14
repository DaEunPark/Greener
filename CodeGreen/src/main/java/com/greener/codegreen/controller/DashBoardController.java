package com.greener.codegreen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashBoardDTO;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;
import com.greener.codegreen.service.BuyerService;
import com.greener.codegreen.service.DashBoardService;

//Controller("dashBoardController")
@RestController
public class DashBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerControllerImpl.class);
	@Autowired
	private	DashBoardDTO	dashBoardDTO;
	@Autowired
	private	DashBoardService	dashBoardService;
	
	
	
	
	@GetMapping("/dashBoard/SignUpChart")
	public ModelAndView getchart() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> map = new HashMap();
		//Map<String, Object> map = buyerService.getChart();
		List<Map<String, Object>> result= dashBoardService.getChart(map);
		
		
		 
		 mav.addObject("result", result);
		//mav.addObject("getChart", map);
		mav.setViewName("/dashBoard/SignUpChart");
		return mav;
	}
}
