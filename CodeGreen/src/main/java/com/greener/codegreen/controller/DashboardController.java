package com.greener.codegreen.controller;

import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.greener.codegreen.dto.ProductAvgCntDTO;
import com.greener.codegreen.service.DashboardService;
import com.greener.codegreen.dto.ProductViewDTO;
import com.greener.codegreen.service.AdminService;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.DashBoardCategoryDTO;
import com.greener.codegreen.dto.DashboardAgeDTO;
import com.greener.codegreen.service.BuyerService;

@Controller("dashboardController")
@RequestMapping("/admin/*")
public class DashboardController {
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private DashboardService dashboardService;
  
	@Inject 
	AdminService adminService;	
 	
	@Inject
	private BuyerService buyerservice;
	
	/*
	 * 구매 상품 주문 수량 평균 - 박다은
	 */
	@RequestMapping(value = "/dash/productAvg", method = RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/dash/productAvg");

		return mav;
	}
  
	/*
	 * 구매 상품 주문 수량 평균 - 박다은
	 */	
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
  
	//목록 불러오기 - 정경희
	@RequestMapping(value="/dashproductview", method = RequestMethod.GET)
	public String DashProductview(Model model)throws Exception{
    logger.info("화면불러오기");
		  
		return "/admin/dash/DashProductView";
	 }

	// 목록 불러오기 - 정경희
	@ResponseBody
	@RequestMapping(value = "/dashproductview", method = RequestMethod.POST)
	public String dashproductviewpost(Model model) throws Exception {

		List<ProductViewDTO> list = adminService.DashProductview();
		// gson객체 생성
		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();

		Iterator<ProductViewDTO> it = list.iterator();
		while (it.hasNext()) {
			ProductViewDTO productViewDTO = it.next();
			JsonObject object = new JsonObject();
			String c_name = productViewDTO.getC_name();
			int p_view = productViewDTO.getP_view();

			object.addProperty("c_name", c_name);
			object.addProperty("p_view", p_view);
			jArray.add(object);
		}

		String json = gson.toJson(jArray);
		logger.info("json변환: " + json);

		return json;
	}
  
	// 대시보드 - 김민준
	@RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
	public void Dash() throws Exception {
	}

	// 대시보드 - 김민준
	@RequestMapping(value = "/Dashboard22", method = RequestMethod.GET)
	@ResponseBody
	public List<DashboardAgeDTO> Dashboard() throws Exception {

		List<DashboardAgeDTO> dashboard = dashboardService.Dash();

		return dashboard;
	}

	// 대시보드 - 이정하
	@GetMapping("/dashBoard/SignUpChart")
	public ModelAndView getchart() throws Exception {
		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();
		// Map<String, Object> map = buyerService.getChart();
		List<Map<String, Object>> result = dashboardService.getChart(map);

		mav.addObject("result", result);
		// mav.addObject("getChart", map);
		mav.setViewName("/admin/dashBoard/SignUpChart");
		return mav;
	}

	/* -----------------------------
	 * *********** 유현지 **********
	 * -----------------------------
	 */
	@GetMapping("/dash/dashBoardCategory")
	public ModelAndView dashBoardController() {

		logger.info("dashboardController() 실행....");
		
		ModelAndView mav = new ModelAndView("/admin/dash/dashBoardCategory");
		
		DashBoardCategoryDTO dashBoardDTO = dashboardService.getGrain();
		DashBoardCategoryDTO dashBoardDTOF = dashboardService.getFruit();
		DashBoardCategoryDTO dashBoardDTOS = dashboardService.getFish();
		DashBoardCategoryDTO dashBoardDTOM = dashboardService.getMeat();
		DashBoardCategoryDTO dashBoardDTOH = dashboardService.getHealthy();
		DashBoardCategoryDTO dashBoardDTOW = dashboardService.getWater();
		DashBoardCategoryDTO dashBoardDTON = dashboardService.getSnack();
		
		mav.addObject("dashBoardDTO", dashBoardDTO);
		mav.addObject("dashBoardDTOF", dashBoardDTOF);
		mav.addObject("dashBoardDTOS", dashBoardDTOS);
		mav.addObject("dashBoardDTOM", dashBoardDTOM);
		mav.addObject("dashBoardDTOH", dashBoardDTOH);
		mav.addObject("dashBoardDTOW", dashBoardDTOW);
		mav.addObject("dashBoardDTON", dashBoardDTON);
		
		return mav;
	}
}

