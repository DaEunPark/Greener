package com.greener.codegreen.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

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
	// 전체 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderListAll() throws DataAccessException {
		logger.info("ManagerService에서 getOrderListAll()로 전체 주문내역 조회하기");
		
		return orderDAO.orderListAll();
	}

	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> getOrderList(HashMap<String, String> paramMap) throws DataAccessException {
		
		logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return orderDAO.orderList(paramMap);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public ProductOrderBuyerDTO getOrderDetail(int orderNum) throws DataAccessException {
		logger.info("ManagerService에서 orderDetail()로 상세 조회시작");
		
		return orderDAO.orderDetail(orderNum);
	}

	
}
