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

import com.greener.codegreen.common.PageMaker;
import com.greener.codegreen.common.SearchCriteria;
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
	@RequestMapping(value = "/map-data")
	@ResponseBody
	public ModelAndView handleMapData(@RequestBody HashMap<String, Object> mapData, SearchCriteria scri) throws Exception {
		
		ModelAndView mav = new ModelAndView("/order/orderListCheck");
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(scri);
		
		pageMaker.calculratePage();
		
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
			pageMaker.setTotalCount(orderService.orderTotalOnlyDay(scri));
			logger.info("=======================<< 5 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyWeek(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalOnlyWeek(scri));
			logger.info("=======================<< 6 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListOnlyMonth(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalOnlyMonth(scri));
			logger.info("=======================<< 7 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 2개) without period >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListTwo(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalThree(scri));
			logger.info("=======================<< 8 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListTwo(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalThree(scri));
			logger.info("=======================<< 9 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListTwo(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalThree(scri));
			logger.info("=======================<< 10 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 2개) day >> ************************* //
		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalDay(scri));
			logger.info("=======================<< 11 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalDay(scri));
			logger.info("=======================<< 12 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListDay(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalDay(scri));
			logger.info("=======================<< 13 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 2개) week >> ************************* //
		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWeek(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWeek(scri));
			logger.info("=======================<< 14 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWeek(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWeek(scri));
			logger.info("=======================<< 15 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWeek(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWeek(scri));
			logger.info("=======================<< 16 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 2개) Month >> ************************* //
		else if (!orderNum.equals("") && buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalMonth(scri));
			logger.info("=======================<< 17 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalMonth(scri));
			logger.info("=======================<< 18 >>======================");
		}
		else if (orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalMonth(scri));
			logger.info("=======================<< 19 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) without period >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListThree(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalFour(scri));
			logger.info("=======================<< 20 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) day >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListDayTwo(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalDayTwo(scri));
			logger.info("=======================<< 21 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListDayTwo(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalDayTwo(scri));
			logger.info("=======================<< 22 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListDayTwo(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalDayTwo(scri));
			logger.info("=======================<< 23 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) week >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWeek(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWeekTwo(scri));
			logger.info("=======================<< 24 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWeek(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWeekTwo(scri));
			logger.info("=======================<< 25 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWeek(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWeekTwo(scri));
			logger.info("=======================<< 26 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 3개) month >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalMonthTwo(scri));
			logger.info("=======================<< 27 >>======================");
		}
		else if (!orderNum.equals("") && buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalMonthTwo(scri));
			logger.info("=======================<< 28 >>======================");
		}
		else if (orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListMonth(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalMonthTwo(scri));
			logger.info("=======================<< 29 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 4개) day >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && !period0.equals("0") && 
				period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWhole(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWhole(scri));
			logger.info("=======================<< 30 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 4개) week >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				!period1.equals("0") && period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWhole(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWhole(scri));
			logger.info("=======================<< 31 >>======================");
		}
		
		// ********************<< 복수 조건 주문건 조회 (조건 4개) month >> ************************* //
		else if (!orderNum.equals("") && !buyerName.equals("") && !productNum.equals("") && period0.equals("0") && 
				period1.equals("0") && !period2.equals("0")) {
			List<HashMap<String, String>> orderList = orderService.getOrderListWhole(scri);
			mav.addObject("orderList", orderList);
			pageMaker.setTotalCount(orderService.orderTotalWhole(scri));
			logger.info("=======================<< 32 >>======================");
		}

		
		mav.addObject("pageMaker", pageMaker);
		
	    return mav;
	}

	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	@GetMapping("/orderDetail")
	public String orderDetailController(Model model, HttpServletRequest request) throws Exception {

		logger.info("orderController에서 orderListDetail() 실행..");
		logger.info("" + request.getParameter("o_number"));

		int orderNum = Integer.valueOf((String) request.getParameter("o_number"));

		ProductOrderBuyerDTO productOrderBuyerDTO = orderService.getOrderDetail(orderNum);
		model.addAttribute("orderDetail", productOrderBuyerDTO);

		return "/order/orderListDetail";

	}

	// -----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	// -----------------------------------------------------------------------------------------------------------
	@GetMapping("/orderCancle")
	public String orderListCancle(@RequestParam("o_number") String o_number) throws Exception {

		int oNum = Integer.valueOf(o_number);

		logger.info("orderController에서 주문 내역취소 orderListCancle()시작..");
		orderService.setOrderCancle(oNum);

		return "/order/orderManage";
	}
	  
	  
}
