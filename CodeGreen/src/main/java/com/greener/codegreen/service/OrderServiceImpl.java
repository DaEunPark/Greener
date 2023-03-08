package com.greener.codegreen.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.common.Criteria;
import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dao.OrderDAO;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	
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
