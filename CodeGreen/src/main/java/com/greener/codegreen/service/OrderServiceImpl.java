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
		public List<HashMap<String, String>> getOrderListAll() throws Exception {
			
			logger.info("ManagerService에서 getOrderListAll()로 전체 주문내역 조회하기");
			
			return orderDAO.orderListAll();
			
		}
		
		
		//-----------------------------------------------------------------------------------------------------------
		// 조건에 맞는 주문내역 목록 불러오기
		//-----------------------------------------------------------------------------------------------------------
		public List<HashMap<String, String>> getOrderList(HashMap<String, String> paramMap) throws Exception {
			
			logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
			
			return orderDAO.orderList(paramMap);
			
		}
		
		//-----------------------------------------------------------------------------------------------------------
		// 조건에 맞는 주문내역 목록 불러오기(day)
		//-----------------------------------------------------------------------------------------------------------
		public List<HashMap<String, String>> getOrderListDay(HashMap<String, String> paramMap) throws Exception {
			
			logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
			
			return orderDAO.orderListDay(paramMap);
			
		}
		
		//-----------------------------------------------------------------------------------------------------------
		// 조건에 맞는 주문내역 목록 불러오기(onlyDay)
		//-----------------------------------------------------------------------------------------------------------
		public List<HashMap<String, String>> getOrderListOnlyDay(HashMap<String, String> paramMap) throws Exception {
			
			logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
			
			return orderDAO.orderListOnlyDay(paramMap);
			
		}

		//-----------------------------------------------------------------------------------------------------------
		// 조건에 맞는 주문내역 목록 불러오기(week)
		//-----------------------------------------------------------------------------------------------------------
		public List<HashMap<String, String>> getOrderListWeek(HashMap<String, String> paramMap) throws Exception {
				
			logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
				
			return orderDAO.orderListWeek(paramMap);
				
		}
			
		//-----------------------------------------------------------------------------------------------------------
		// 조건에 맞는 주문내역 목록 불러오기(onlyWeek)
		//-----------------------------------------------------------------------------------------------------------
		public List<HashMap<String, String>> getOrderListOnlyWeek(HashMap<String, String> paramMap) throws Exception {
				
			logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
				
			return orderDAO.orderListOnlyWeek(paramMap);
				
		}
		
		//-----------------------------------------------------------------------------------------------------------
		// 조건에 맞는 주문내역 목록 불러오기(month)
		//-----------------------------------------------------------------------------------------------------------
		public List<HashMap<String, String>> getOrderListMonth(HashMap<String, String> paramMap) throws Exception {
					
			logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
					
			return orderDAO.orderListMonth(paramMap);
					
		}
				
		//-----------------------------------------------------------------------------------------------------------
		// 조건에 맞는 주문내역 목록 불러오기(onlyMonth)
		//-----------------------------------------------------------------------------------------------------------
		public List<HashMap<String, String>> getOrderListOnlyMonth(HashMap<String, String> paramMap) throws Exception {
					
			logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
					
			return orderDAO.orderListOnlyMonth(paramMap);
					
		}
			
		//-----------------------------------------------------------------------------------------------------------
		// 주문번호 누르면 상세 주문내역 보여주기
		//-----------------------------------------------------------------------------------------------------------
		public ProductOrderBuyerDTO getOrderDetail(int orderNum) throws Exception {
			
			logger.info("ManagerService에서 orderDetail()로 상세 조회시작");
			
			return orderDAO.orderDetail(orderNum);
			
		}

		//-----------------------------------------------------------------------------------------------------------
		// 전체 주문 개수 불러오기
		//-----------------------------------------------------------------------------------------------------------
		public int getOrderCount() throws Exception {
			
			logger.info("ManagerService에서 전체 주문개수 조회 getOrderCount()...");
			
			return orderDAO.orderCountAll();
		}
		
		//-----------------------------------------------------------------------------------------------------------
		// 주문내역 취소하기
		//-----------------------------------------------------------------------------------------------------------
		public int setOrderCancle(int oNum) throws Exception {
			logger.info("ManagerService에서 setOrderCancle() 실행...");
			
			return orderDAO.orderListCancle(oNum);
		} 
		
		
	}

