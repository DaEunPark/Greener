package com.greener.codegreen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.dao.ManagerDAO;
import com.greener.codegreen.dao.OrderDAO;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;
import com.greener.codegreen.service.ManagerService;
import com.greener.codegreen.service.OrderService;

@Controller("orderController")
@RequestMapping(value = "/order/*")
public class OrderController {
private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDAO orderDAO;
	//-----------------------------------------------------------------------------------------------------------
	// 주문 목록 메인 화면 불러오기
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/orderManage")
	public String orderForm() {
		
		System.out.println("orderController의 order를 거쳐갑니다.");
		return "/order/orderManage";
	
	}
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 목록 불러오기 (전체&조건지정시)
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/map-data", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView handleMapData(@RequestBody Map<String, Object> mapData) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		HashMap<String, String> paramMap = new HashMap<>();
	
	
		// 아무것도 지정하지 않고 조회버튼 클릭 시 주문 전체 목록 보여주기 //
		if(mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") 
				&& mapData.get("productNum").equals("")) {
			List<HashMap<String, String>> orderListAll = orderService.getOrderListAll();
			mav.addObject("orderListAll", orderListAll);
		logger.info("=======================1=======================");
		} else if (!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
				mapData.get("productNum").equals("")){
			paramMap.put("orderNum1", (String) mapData.get("orderNum"));
			logger.info("=======================2=======================");
		} else if (!mapData.get("buyerName").equals("") && mapData.get("orderNum").equals("") &&
				mapData.get("productNum").equals("")) {
			paramMap.put("buyerName1", (String) mapData.get("buyerName"));
			logger.info("=======================3=======================");
		} else if(!mapData.get("productNum").equals("") && mapData.get("orderNum").equals("") && 
				mapData.get("buyerName").equals("")) {
			paramMap.put("productNum1", (String) mapData.get("productNum"));
			logger.info("=======================4======================");
		} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
				!mapData.get("productNum").equals("")) {
			paramMap.put("orderNum2", (String) mapData.get("orderNum"));
			paramMap.put("buyerName2", (String) mapData.get("buyerName"));
			paramMap.put("productNum2", (String) mapData.get("productNum"));
			logger.info("=======================5=======================");
		} else if(mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
				!mapData.get("productNum").equals("")) {
			paramMap.put("buyerName3", (String) mapData.get("buyerName"));
			paramMap.put("productNum3", (String) mapData.get("productNum"));
			logger.info("=======================6=======================");
		} else if(!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
				!mapData.get("productNum").equals("")) {if(mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") 
				&& mapData.get("productNum").equals("")) {
			List<HashMap<String, String>> orderListAll = orderService.getOrderListAll();
			mav.addObject("orderListAll", orderListAll);
		logger.info("=======================1=======================");
		} else if (!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
				mapData.get("productNum").equals("")){
			paramMap.put("orderNum1", (String) mapData.get("orderNum"));
			logger.info("=======================2=======================");
		} else if (!mapData.get("buyerName").equals("") && mapData.get("orderNum").equals("") &&
				mapData.get("productNum").equals("")) {
			paramMap.put("buyerName1", (String) mapData.get("buyerName"));
			logger.info("=======================3=======================");
		} else if(!mapData.get("productNum").equals("") && mapData.get("orderNum").equals("") && 
				mapData.get("buyerName").equals("")) {
			paramMap.put("productNum1", (String) mapData.get("productNum"));
			logger.info("=======================4======================");
		} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
				!mapData.get("productNum").equals("")) {
			paramMap.put("orderNum2", (String) mapData.get("orderNum"));
			paramMap.put("buyerName2", (String) mapData.get("buyerName"));
			paramMap.put("productNum2", (String) mapData.get("productNum"));
			logger.info("=======================5=======================");
		} else if(mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
				!mapData.get("productNum").equals("")) {
			paramMap.put("buyerName3", (String) mapData.get("buyerName"));
			paramMap.put("productNum3", (String) mapData.get("productNum"));
			logger.info("=======================6=======================");
		} else if(!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
				!mapData.get("productNum").equals("")) {
			paramMap.put("orderNum4", (String) mapData.get("orderNum"));
			paramMap.put("productNum4", (String) mapData.get("productNum"));
			logger.info("=======================7=======================");
		} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
				mapData.get("productNum").equals("")) {
			paramMap.put("orderNum5", (String) mapData.get("orderNum"));
			paramMap.put("buyerName5", (String) mapData.get("buyerName"));
			logger.info("=======================8=======================");
		}
			paramMap.put("orderNum4", (String) mapData.get("orderNum"));
			paramMap.put("productNum4", (String) mapData.get("productNum"));
			logger.info("=======================7=======================");
		} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
				mapData.get("productNum").equals("")) {
			paramMap.put("orderNum5", (String) mapData.get("orderNum"));
			paramMap.put("buyerName5", (String) mapData.get("buyerName"));
			logger.info("=======================8=======================");
		}

	
		List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
		mav.addObject("orderList", orderList);
			
		mav.setViewName("/order/orderListCheck");
		
	    return mav;
	}

	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/orderDetail")
	public String orderDetailController(Model model, HttpServletRequest request) throws Exception {
		  
		  logger.info("orderController에서 orderListDetail() 실행..");
		  logger.info(""+request.getParameter("o_number"));
		  
		  int orderNum = Integer.valueOf((String)request.getParameter("o_number"));
		  
		  ProductOrderBuyerDTO productOrderBuyerDTO = orderService.getOrderDetail(orderNum);
		  model.addAttribute("orderDetail", productOrderBuyerDTO);
		  
		  logger.info(""+orderNum);
		  
		  return "/order/orderListDetail";
		  
	  }	
}
