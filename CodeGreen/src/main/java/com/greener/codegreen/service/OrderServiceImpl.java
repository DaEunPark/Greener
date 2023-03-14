package com.greener.codegreen.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dao.OrderDAO;
import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);
	
	@Autowired
	private BuyerDTO buyerDTO;
	
	@Autowired
	private OrderDAO orderDAO;

	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 목록 불러오기 (전체 주문)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListAll(SearchCriteria scri) throws DataAccessException {
		logger.info("orderService에서 getOrderListAll()로 전체 주문내역 조회하기");
		
		return orderDAO.orderListAll(scri);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderList(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderList(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyDay)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyDay(SearchCriteria scri) throws DataAccessException {
			
		logger.info("orderService에서 getOrderListOnlyDay()로 조건에 맞는 주문내역 조회하기");
			
		return orderDAO.orderListOnlyDay(scri);
			
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyWeek)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyWeek(SearchCriteria scri) throws DataAccessException {
				
		logger.info("orderService에서 getOrderListOnlyMonth()로 조건에 맞는 주문내역 조회하기");
				
		return orderDAO.orderListOnlyWeek(scri);
				
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyMonth)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListOnlyMonth(SearchCriteria scri) throws DataAccessException {
					
		logger.info("orderService에서 getOrderListOnlyMonth()로 조건에 맞는 주문내역 조회하기");
					
		return orderDAO.orderListOnlyMonth(scri);
					
	}

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListTwo)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListTwo()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListTwo(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListDay)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListDay(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListDay()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListDay(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListWeek)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListWeek(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListWeek()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListWeek(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListMonth)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListMonth(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListMonth()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListMonth(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListThree)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListThree(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListThree()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListThree(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListDayTwo)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListDayTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListDayTwo()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListDayTwo(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListWeekTwo)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListWeekTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListWeekTwo()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListWeek(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListMonthTwo)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListMonthTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 getOrderListMonthTwo()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListMonth(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(getOrderListWhole)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> getOrderListWhole(SearchCriteria scri) throws DataAccessException{
	
		logger.info("orderService에서 getOrderListWhole()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderListWhole(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalWhole)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalWhole(SearchCriteria scri) throws DataAccessException{
		
		logger.info("orderService에서 orderTotalWhole()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderTotalNumWhole(scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotal)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotal(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotal()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNum(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotal()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumTwo(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalOnlyDay)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalOnlyDay(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalOnlyDay()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumOnlyDay(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalOnlyWeek)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalOnlyWeek(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalOnlyWeek()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumOnlyWeek(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalOnlyMonth)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalOnlyMonth(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalOnlyMonth()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumOnlyMonth(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalThree)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalThree(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalThree()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumThree(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalDay)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalDay(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalDay()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumDay(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalWeek)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalWeek(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalWeek()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumWeek(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalMonth)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalMonth(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalMonth()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumMonth(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalFour)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalFour(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalFour()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumFour(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalDayTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalDayTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalDayTwo()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumDayTwo(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalWeekTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalWeekTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalWeekTwo()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumWeekTwo(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalMonthTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalMonthTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderService에서 orderTotalMonthTwo()로 전체 주문내역 개수 구하기");
		
		return orderDAO.orderTotalNumMonthTwo(scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public ProductOrderBuyerDTO getOrderDetail(int orderNum) throws DataAccessException {
		logger.info("orderService에서 orderDetail()로 상세 조회시작");
		
		return orderDAO.orderDetail(orderNum);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int setOrderCancle(int oNum) throws DataAccessException {
		logger.info("orderService에서 setOrderCancle() 실행...");
		
		return orderDAO.orderListCancle(oNum);
	}

	
		
	}

