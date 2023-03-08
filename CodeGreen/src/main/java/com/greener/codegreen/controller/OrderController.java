package com.greener.codegreen.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greener.codegreen.common.Criteria;
import com.greener.codegreen.common.PageMaker;
import com.greener.codegreen.common.SearchCriteria;
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
	@RequestMapping(value = "/map-data")
	@ResponseBody
	public ModelAndView handleMapData(@RequestBody HashMap<String, Object> mapData, SearchCriteria scri, Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView("/order/orderListCheck");
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(scri);
		
		if(mapData.get("pageNum") != null) {
			scri.setPageNum(String.valueOf(mapData.get("pageNum")));
		} else {
			scri.setPageNum("1");
		}

		scri.setOrderNum(String.valueOf(mapData.get("orderNum")));
		scri.setBuyerName(String.valueOf(mapData.get("buyerName")));
		scri.setProductNum(String.valueOf(mapData.get("productNum")));
		scri.setPeriod0(String.valueOf(mapData.get("period0")));
		scri.setPeriod1(String.valueOf(mapData.get("period1")));
		scri.setPeriod2(String.valueOf(mapData.get("period2")));
		
		String orderNum = scri.getOrderNum();
		String buyerName = scri.getBuyerName();
		String productNum = scri.getProductNum();
		String period0 = scri.getPeriod0();
		String period1 = scri.getPeriod1();
		String period2 = scri.getPeriod2();
		
		// ********************<< 전체 주문건 조회(조건없을시) >> ************************* //
		if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 				
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderListAll = orderService.getOrderListAll(scri);
			mav.addObject("orderListAll", orderListAll);
			pageMaker.setTotalCount(orderService.orderTotal(scri));
			logger.info("=======================<< 1 >>======================");
		}
		
		// ********************<< 단일 조건 주문건 조회 >> ************************* //
		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderList(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalTwo(scri));
			
			logger.info("=======================<< 2 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderList(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalTwo(scri));
			logger.info("=======================<< 3 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderList(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalTwo(scri));
			logger.info("=======================<< 4 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyDay(scri);
			mav.addObject("orderList", orderList);
			logger.info("=======================<< 5 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyWeek(scri);
			mav.addObject("orderList", orderList);
			logger.info("=======================<< 6 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyMonth(scri);
			mav.addObject("orderList", orderList);
			logger.info("=======================<< 7 >>======================");
		}
		
//		// ********************<< 복수 조건 주문건 조회 (조건 2개) without period >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum2", orderNum);
//			paramMap.put("buyerName2", buyerName);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 8 >>======================");
//		}
//		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum3", orderNum);
//			paramMap.put("productNum3", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 9 >>======================");
//		}
//		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("buyerName4", buyerName);
//			paramMap.put("productNum4", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 10 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 2개) day >> ************************* //
//		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum6", orderNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 11 >>======================");
//		}
//		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("buyerName7", buyerName);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 12 >>======================");
//		}
//		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("productNum8", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 13 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 2개) week >> ************************* //
//		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
//				!period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum9", orderNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 14 >>======================");
//		}
//		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
//				!period1.equals("0") && period2.equals("0")) {
//			paramMap.put("buyerName10", buyerName);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 15 >>======================");
//		}
//		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				!period1.equals("0") && period2.equals("0")) {
//			paramMap.put("productNum11", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 16 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 2개) Month >> ************************* //
//		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && !period2.equals("0")) {
//			paramMap.put("orderNum12", orderNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 17 >>======================");
//		}
//		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && !period2.equals("0")) {
//			paramMap.put("buyerName13", buyerName);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 18 >>======================");
//		}
//		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && !period2.equals("0")) {
//			paramMap.put("productNum14", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 19 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 3개) without period >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum5", orderNum);
//			paramMap.put("buyerName5", buyerName);
//			paramMap.put("productNum5", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 20 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 3개) day >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum15", orderNum);
//			paramMap.put("buyerName15", buyerName);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 21 >>======================");
//		}
//		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum16", orderNum);
//			paramMap.put("productNum16", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 22 >>======================");
//		}
//		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("buyerName17", buyerName);
//			paramMap.put("productNum17", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 23 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 3개) week >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
//				!period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum18", orderNum);
//			paramMap.put("buyerName18", buyerName);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 24 >>======================");
//		}
//		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				!period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum19", orderNum);
//			paramMap.put("productNum19", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 25 >>======================");
//		}
//		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				!period1.equals("0") && period2.equals("0")) {
//			paramMap.put("buyerName20", buyerName);
//			paramMap.put("productNum20", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 26 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 3개) month >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && !period2.equals("0")) {
//			paramMap.put("orderNum21", orderNum);
//			paramMap.put("buyerName21", buyerName);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 27 >>======================");
//		}
//		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && !period2.equals("0")) {
//			paramMap.put("orderNum22", orderNum);
//			paramMap.put("productNum22", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 28 >>======================");
//		}
//		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && !period2.equals("0")) {
//			paramMap.put("buyerName23", buyerName);
//			paramMap.put("productNum23", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 29 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 4개) day >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
//				period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum24", orderNum);
//			paramMap.put("buyerName24", buyerName);
//			paramMap.put("productNum24", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 30 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 4개) week >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				!period1.equals("0") && period2.equals("0")) {
//			paramMap.put("orderNum25", orderNum);
//			paramMap.put("buyerName25", buyerName);
//			paramMap.put("productNum25", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 31 >>======================");
//		}
//		
//		// ********************<< 복수 조건 주문건 조회 (조건 4개) month >> ************************* //
//		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
//				period1.equals("0") && !period2.equals("0")) {
//			paramMap.put("orderNum26", orderNum);
//			paramMap.put("buyerName26", buyerName);
//			paramMap.put("productNum26", productNum);
//			List<HashMap<String, String>> orderList = orderService.getOrderList(paramMap);
//			mav.addObject("orderList", orderList);
//			logger.info("=======================<< 32 >>======================");
//		}

		
		mav.addObject("pageMaker", pageMaker);
		
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
