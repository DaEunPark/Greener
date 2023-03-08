package com.greener.codegreen.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.common.Criteria;
import com.greener.codegreen.common.SearchCriteria;
import com.greener.codegreen.dto.ProductOrderBuyerDTO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);
	
	private	static final String Namespace = "com.greener.codegreen.order";

	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 목록 불러오기 (전체 주문)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> orderListAll(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListAll() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListAll", scri);	
	}

	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderList(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderList() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListCheck", scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(onlyDay)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyDay(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO orderListOnlyDay()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListOnlyDay", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(Onlyweek)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyWeek(SearchCriteria scri) throws DataAccessException {
			
		logger.info("orderDAO에서 orderListOnlyWeek()로 조건에 맞는 주문내역 조회하기");
			
		return sqlSession.selectList(Namespace + ".orderListOnlyWeek", scri);
			
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 조건에 맞는 주문내역 목록 불러오기(Onlymonth)
	//-----------------------------------------------------------------------------------------------------------
	public List<HashMap<String, String>> orderListOnlyMonth(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderListOnlyMonth()로 조건에 맞는 주문내역 조회하기");
		
		return sqlSession.selectList(Namespace + ".orderListOnlyMonth", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNum)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNum(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNum()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCount", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNum()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountTwo", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public ProductOrderBuyerDTO orderDetail(int orderNum) throws DataAccessException {
		logger.info("orderDAO orderDetail() 시작");
		
		return sqlSession.selectOne(Namespace + ".orderDetailCheck", orderNum);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int orderListCancle(int oNum) throws DataAccessException {
		logger.info("orderDAO 주문내역 취소하기 orderListCancle()...");
		
		return sqlSession.delete(Namespace + ".orderListCancle", oNum); 
	}

}
