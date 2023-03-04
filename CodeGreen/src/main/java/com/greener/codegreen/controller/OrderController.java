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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.dto.ProductOrderBuyerDTO;
import com.greener.codegreen.service.OrderService;

@Controller("orderController")
@RequestMapping(value = "/order/*")
public class OrderController {
private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문 목록 메인 화면 불러오기
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/orderManage")
	public String orderForm() {
		logger.info("==============================================================");
		logger.info("orderController의 orderManage() 메인화면 불러오기");
		logger.info("==============================================================");
		
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
	
		String orderNum = String.valueOf(mapData.get("orderNum"));
		String buyerName = String.valueOf(mapData.get("buyerName"));
		String productNum = String.valueOf(mapData.get("productNum"));
		String state0 = String.valueOf(mapData.get("state0"));
		String state1 = String.valueOf(mapData.get("state1"));
		String state2 = String.valueOf(mapData.get("state2"));
		String state3 = String.valueOf(mapData.get("state3"));
		String period0 = String.valueOf(mapData.get("period0"));
		String period1 = String.valueOf(mapData.get("period1"));
		String period2 = String.valueOf(mapData.get("period2"));
		
		// ********************<< 전체 주문건 조회(조건없을시) >> ************************* //
		if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderListAll = orderService.getOrderListAll();
			mav.addObject("orderListAll", orderListAll);
			int mapCount =orderListAll.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 1 >>======================");
		}
		
		// ********************<< 단일 조건 주문건 조회 >> ************************* //
		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum1", orderNum);
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 2 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("buyerName1", buyerName);
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 3 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("productNum1", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 4 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyDay();
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 5 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyWeek();
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 6 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyMonth();
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 7 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 2개) without period >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum2", orderNum);
			paramMap.put("buyerName2", buyerName);
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 8 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum3", orderNum);
			paramMap.put("productNum3", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 9 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("buyerName4", buyerName);
			paramMap.put("productNum4", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 10 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 2개) day >> ************************* //
		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum1", orderNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 11 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("buyerName1", buyerName);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 12 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("productNum1", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 13 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 2개) week >> ************************* //
		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum1", orderNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 14 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			paramMap.put("buyerName1", buyerName);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 15 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			paramMap.put("productNum1", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 16 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) without period >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum5", orderNum);
			paramMap.put("buyerName5", buyerName);
			paramMap.put("productNum5", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 17 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) day >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum2", orderNum);
			paramMap.put("buyerName2", buyerName);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 18 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum3", orderNum);
			paramMap.put("productNum3", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 19 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("buyerName4", buyerName);
			paramMap.put("productNum4", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 20 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) week >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum2", orderNum);
			paramMap.put("buyerName2", buyerName);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 21 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum3", orderNum);
			paramMap.put("productNum3", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 22 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			paramMap.put("buyerName4", buyerName);
			paramMap.put("productNum4", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 23 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) month >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			paramMap.put("orderNum2", orderNum);
			paramMap.put("buyerName2", buyerName);
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 24 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			paramMap.put("orderNum3", orderNum);
			paramMap.put("productNum3", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 25 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			paramMap.put("buyerName4", buyerName);
			paramMap.put("productNum4", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 26 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 4개) day >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum5", orderNum);
			paramMap.put("buyerName5", buyerName);
			paramMap.put("productNum5", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 27 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 4개) week >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			paramMap.put("orderNum5", orderNum);
			paramMap.put("buyerName5", buyerName);
			paramMap.put("productNum5", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 28 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 4개) month >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			paramMap.put("orderNum5", orderNum);
			paramMap.put("buyerName5", buyerName);
			paramMap.put("productNum5", productNum);
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
			mav.addObject("orderList", orderList);
			int mapCount =orderList.size();
			mav.addObject("mapCount", mapCount);
			logger.info("=======================<< 29 >>======================");
		}
		
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

		  
		  return "/order/orderListDetail";
		  
	  }	
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	  @GetMapping("/orderCancle")
	  public String orderListCancle(@RequestParam("o_number") String o_number) throws Exception {
			  
		  int oNum = Integer.valueOf(o_number);

		  logger.info("orderController에서 주문 내역취소 orderListCancle()시작..");
		  orderService.setOrderCancle(oNum);
			  
		  return "/order/orderManage";
	  }
}
