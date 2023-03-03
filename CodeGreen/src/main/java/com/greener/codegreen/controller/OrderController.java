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

import com.greener.codegreen.dao.OrderDAO;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;
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
		
		int totalCnt = orderService.getOrderCount();

		for(int i=0; i<mapData.size(); i++) {
			paramMap.put("period"+i, String.valueOf(mapData.get("period"+i)));
		}
		
		//바깥 if
		if(paramMap.get("period0").equals("1") && !paramMap.get("period1").equals("1") &&
				!paramMap.get("period2").equals("1"))
		{	
			if(mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
				mapData.get("productNum").equals("")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyDay(paramMap);
			mav.addObject("orderList", orderList);
			logger.info("=======================0=======================");
			} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
					!mapData.get("productNum").equals("")) {

				paramMap.put("orderNum2", (String) mapData.get("orderNum"));
				paramMap.put("buyerName2", (String) mapData.get("buyerName"));
				paramMap.put("productNum2", (String) mapData.get("productNum"));
				List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================1=======================");
		  	} else if (!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
					mapData.get("productNum").equals("")){

				paramMap.put("orderNum1", (String) mapData.get("orderNum"));
				List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================2=======================");
			} else if (!mapData.get("buyerName").equals("") && mapData.get("orderNum").equals("") &&
					mapData.get("productNum").equals("")){

				paramMap.put("buyerName1", (String) mapData.get("buyerName"));
				List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================3=======================");
			} else if(!mapData.get("productNum").equals("") && mapData.get("orderNum").equals("") && 
					mapData.get("buyerName").equals("")) {
				
				paramMap.put("productNum1", (String) mapData.get("productNum"));
				List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================4======================");
			} else if(mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
					!mapData.get("productNum").equals("")) {
					
				paramMap.put("buyerName3", (String) mapData.get("buyerName"));
				paramMap.put("productNum3", (String) mapData.get("productNum"));
				List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================5=======================");
			} else if(!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
					!mapData.get("productNum").equals("")) {
				
				paramMap.put("orderNum4", (String) mapData.get("orderNum"));
				paramMap.put("productNum4", (String) mapData.get("productNum"));
				List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================6=======================");
			} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
					mapData.get("productNum").equals("")) {
					
				paramMap.put("orderNum5", (String) mapData.get("orderNum"));
				paramMap.put("buyerName5", (String) mapData.get("buyerName"));
				List<HashMap<String, String>> orderList = orderService.getOrderListDay(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================7=======================");
			} // End - else if
			 
		} else if(paramMap.get("period1").equals("1") && !paramMap.get("period0").equals("1") &&
				!paramMap.get("period2").equals("1")) {
			if(mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
					mapData.get("productNum").equals("")) {
				List<HashMap<String, String>> orderList = orderService.getOrderListOnlyWeek(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================8=======================");
				} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
						!mapData.get("productNum").equals("")) {

					paramMap.put("orderNum2", (String) mapData.get("orderNum"));
					paramMap.put("buyerName2", (String) mapData.get("buyerName"));
					paramMap.put("productNum2", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================9=======================");
			  	} else if (!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
						mapData.get("productNum").equals("")){

					paramMap.put("orderNum1", (String) mapData.get("orderNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================10=======================");
				} else if (!mapData.get("buyerName").equals("") && mapData.get("orderNum").equals("") &&
						mapData.get("productNum").equals("")) {

					paramMap.put("buyerName1", (String) mapData.get("buyerName"));
					List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================11=======================");
				} else if(!mapData.get("productNum").equals("") && mapData.get("orderNum").equals("") && 
						mapData.get("buyerName").equals("")) {
					
					paramMap.put("productNum1", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================12======================");
				} else if(mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
						!mapData.get("productNum").equals("")) {
						
					paramMap.put("buyerName3", (String) mapData.get("buyerName"));
					paramMap.put("productNum3", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================13=======================");
				} else if(!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
						!mapData.get("productNum").equals("")) {
					
					paramMap.put("orderNum4", (String) mapData.get("orderNum"));
					paramMap.put("productNum4", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================14=======================");
				} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
						mapData.get("productNum").equals("")) {
						
					paramMap.put("orderNum5", (String) mapData.get("orderNum"));
					paramMap.put("buyerName5", (String) mapData.get("buyerName"));
					List<HashMap<String, String>> orderList = orderService.getOrderListWeek(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================15=======================");
				}
		} else if(paramMap.get("period2").equals("1") && !paramMap.get("period0").equals("1") &&
				!paramMap.get("period1").equals("1")) {
			if(mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
					mapData.get("productNum").equals("")) {
				List<HashMap<String, String>> orderList = orderService.getOrderListOnlyMonth(paramMap);
				mav.addObject("orderList", orderList);
				logger.info("=======================16=======================");
				} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
						!mapData.get("productNum").equals("")) {

					paramMap.put("orderNum2", (String) mapData.get("orderNum"));
					paramMap.put("buyerName2", (String) mapData.get("buyerName"));
					paramMap.put("productNum2", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================17=======================");
			  	} else if (!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
						mapData.get("productNum").equals("")){

					paramMap.put("orderNum1", (String) mapData.get("orderNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================18=======================");
				} else if (!mapData.get("buyerName").equals("") && mapData.get("orderNum").equals("") &&
						mapData.get("productNum").equals("")) {

					paramMap.put("buyerName1", (String) mapData.get("buyerName"));
					List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================19=======================");
				} else if(!mapData.get("productNum").equals("") && mapData.get("orderNum").equals("") && 
						mapData.get("buyerName").equals("")) {
					
					paramMap.put("productNum1", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================20======================");
				} else if(mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
						!mapData.get("productNum").equals("")) {
						
					paramMap.put("buyerName3", (String) mapData.get("buyerName"));
					paramMap.put("productNum3", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================21=======================");
				} else if(!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
						!mapData.get("productNum").equals("")) {
					
					paramMap.put("orderNum4", (String) mapData.get("orderNum"));
					paramMap.put("productNum4", (String) mapData.get("productNum"));
					List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================22=======================");
				} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
						mapData.get("productNum").equals("")) {
						
					paramMap.put("orderNum5", (String) mapData.get("orderNum"));
					paramMap.put("buyerName5", (String) mapData.get("buyerName"));
					List<HashMap<String, String>> orderList = orderService.getOrderListMonth(paramMap);
					mav.addObject("orderList", orderList);
					logger.info("=======================23=======================");
				}
		} else if(!paramMap.get("period0").equals("1") && !paramMap.get("period1").equals("1") && 
				!paramMap.get("period2").equals("1")){
			if(mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") 
					&& mapData.get("productNum").equals("")) {
				List<HashMap<String, String>> orderListAll = orderService.getOrderListAll();
				mav.addObject("orderListAll", orderListAll);
				logger.info("=======================24=======================");
			} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
					!mapData.get("productNum").equals("")) {
				paramMap.put("orderNum2", (String) mapData.get("orderNum"));
				paramMap.put("buyerName2", (String) mapData.get("buyerName"));
				paramMap.put("productNum2", (String) mapData.get("productNum"));
				logger.info("=======================25=======================");
		  	} else if (!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
					mapData.get("productNum").equals("")){
				paramMap.put("orderNum1", (String) mapData.get("orderNum"));
				logger.info("=======================26=======================");
			} else if (!mapData.get("buyerName").equals("") && mapData.get("orderNum").equals("") &&
					mapData.get("productNum").equals("")) {
				paramMap.put("buyerName1", (String) mapData.get("buyerName"));
				logger.info("=======================27=======================");
			} else if(!mapData.get("productNum").equals("") && mapData.get("orderNum").equals("") && 
					mapData.get("buyerName").equals("")) {
				paramMap.put("productNum1", (String) mapData.get("productNum"));
				logger.info("=======================28======================");
			} else if(mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
					!mapData.get("productNum").equals("")) {
				paramMap.put("buyerName3", (String) mapData.get("buyerName"));
				paramMap.put("productNum3", (String) mapData.get("productNum"));
				logger.info("=======================29=======================");
			} else if(!mapData.get("orderNum").equals("") && mapData.get("buyerName").equals("") &&
					!mapData.get("productNum").equals("")) {
				paramMap.put("orderNum4", (String) mapData.get("orderNum"));
				paramMap.put("productNum4", (String) mapData.get("productNum"));
				logger.info("=======================30=======================");
			} else if(!mapData.get("orderNum").equals("") && !mapData.get("buyerName").equals("") &&
					mapData.get("productNum").equals("")) {
				paramMap.put("orderNum5", (String) mapData.get("orderNum"));
				paramMap.put("buyerName5", (String) mapData.get("buyerName"));
				logger.info("=======================31=======================");
				List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			}
			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
			mav.addObject("orderList", orderList);
			
		} // End : 바깥 if-else

			mav.setViewName("orderListCheck");
		
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
		  
		  return "orderListDetail";
		  
	  }
	  
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	  @GetMapping("/orderCancle")
	  public String orderListCancle(@RequestParam("o_number") String o_number) throws Exception {
		  
		  int oNum = Integer.valueOf(o_number);

		  logger.info("orderController에서 주문 내역취소 orderListCancle()시작..");
		  orderService.setOrderCancle(oNum);
		  
		  return "orderManage";
	  }
	  
	  
}
