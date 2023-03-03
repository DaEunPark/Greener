package com.greener.codegreen.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.BuyerDTO;
import com.greener.codegreen.dto.OrderDTO;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private BuyerDTO buyerDTO;
	
	@Autowired
	private OrderDTO orderDTO;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ManagerDAO.class);
	
	private	static final String Namespace = "com.greener.codegreen.order";

	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기
	//----------------------------------------------------------------------------------//
	public List<HashMap<String, String>> orderList(HashMap<String, String> paramMap) throws Exception {
		
		logger.info("ManagerDAO orderList() 시작");

		return sqlSession.selectList(Namespace + ".orderListCheck", paramMap);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(day)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListDay(HashMap<String, String> paramMap) throws Exception {
		
		logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListCheckDay", paramMap);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(Onlyday)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyDay(HashMap<String, String> paramMap) throws Exception {
		
		logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListOnlyDay", paramMap);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(week)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListWeek(HashMap<String, String> paramMap) throws Exception {
		
		logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListCheckWeek", paramMap);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(Onlyweek)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyWeek(HashMap<String, String> paramMap) throws Exception {
		
		logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListOnlyWeek", paramMap);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(month)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListMonth(HashMap<String, String> paramMap) throws Exception {
		
		logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListCheckMonth", paramMap);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(Onlymonth)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyMonth(HashMap<String, String> paramMap) throws Exception {
		
		logger.info("ManagerService에서 getOrderList()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListOnlyMonth", paramMap);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 전체 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListAll() throws Exception {
		
		logger.info("ManagerDAO orderListAll() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListAll");
		
	}
	
	
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	public ProductOrderBuyerDTO orderDetail(int orderNum) throws Exception {
		
		logger.info("managerDAO orderDetail() 시작");
		
		return sqlSession.selectOne(Namespace + ".orderDetailCheck", orderNum);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 전체 주문 개수 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public int orderCountAll() throws Exception {
		
		logger.info("ManagerDAO 전체 주문 개수 불러오기 시작");
		
		return sqlSession.selectOne(Namespace + ".orderAllBno");
		
	}	
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	public int orderListCancle(int oNum) throws Exception {
		
		logger.info("ManagerDAO 주문내역 취소하기 orderListCancle()...");
		
		return sqlSession.delete(Namespace + ".orderListCancle", oNum); 
		
	}
	
}
