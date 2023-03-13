package com.greener.codegreen.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/dash/productAvg");
		
		return mav;
	}
	
	@RequestMapping(value = "/productavg", method = RequestMethod.GET)
	@ResponseBody
	public String productAvg() throws Exception {
		List<ProductAvgCntDTO> dtoList = dashboardService.getProductAvgCntInfo(10);
		logger.info("DashboardController ProductAvg() => " + dtoList);
		
		Gson gson = new GsonBuilder().create();
		JsonObject colEle1 = new JsonObject();
		JsonObject colEle2 = new JsonObject();
		JsonArray colArr = new JsonArray();
		colEle1.addProperty("id", "product_avg_title");
		colEle1.addProperty("label", "상품명");
		colEle1.addProperty("type", "string");
		colArr.add(colEle1);
		colEle2.addProperty("id", "product_avg");
		colEle2.addProperty("label", "구매 수량 평균");
		colEle2.addProperty("type", "number");
		colArr.add(colEle2);		
		
		
		
		JsonArray rowArr = new JsonArray();
		for (ProductAvgCntDTO productAvgCntDTO : dtoList) {
			JsonObject vObj1 = new JsonObject();
			JsonObject vObj2 = new JsonObject();
			JsonArray cArr = new JsonArray();
			JsonObject cObj = new JsonObject();	
			vObj1.addProperty("v", productAvgCntDTO.getP_name());
			cArr.add(vObj1);
			vObj2.addProperty("v", productAvgCntDTO.getProduct_order_avg());			
			cArr.add(vObj2);
			cObj.add("c", cArr);
			rowArr.add(cObj);
		}
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("cols", colArr);
		jsonObject.add("rows", rowArr);
		logger.info("DashboardController ProductAvg() JSON => " + gson.toJson(jsonObject));
		return gson.toJson(jsonObject);
	}
}
