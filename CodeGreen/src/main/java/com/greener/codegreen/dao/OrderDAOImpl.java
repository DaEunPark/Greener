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
	// 주문내역 목록 불러오기 (orderListAll)
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> orderListAll(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListAll() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListAll", scri);	
	}

	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderList)
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
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListTwo)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListTwo(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListTwo() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListCheckTwo", scri);
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListDay)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListDay(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListDay() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListDay", scri);
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListWeek)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListWeek(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListWeek() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListWeek", scri);
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListMonth)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListMonth(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListMonth() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListMonth", scri);
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListThree)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListThree(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListThree() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListCheckThree", scri);
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListDayTwo)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListDayTwo(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListDayTwo() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListDayTwo", scri);
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListWeekTwo)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListWeekTwo(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListWeekTwo() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListWeekTwo", scri);
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListMonth)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListMonthTwo(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListMonthTwo() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListMonthTwo", scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNum)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNum(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNum()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCount", scri);
		
	}
	
	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기(orderListWhole)
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderListWhole(SearchCriteria scri) throws DataAccessException {
		logger.info("orderDAO orderListWhole() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListWhole", scri);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumWhole)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumWhole(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumWhole()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountWhole", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumTwo()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountTwo", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumOnlyDay)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumOnlyDay(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumOnlyDay()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountOnlyDay", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumOnlyWeek)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumOnlyWeek(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumOnlyWeek()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountOnlyWeek", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumOnlyMonth)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumOnlyMonth(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumOnlyMonth()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountOnlyMonth", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumDay)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumDay(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumDay()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountDay", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumWeek)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumWeek(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumWeek()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountWeek", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumMonth)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumMonth(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumMonth()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountMonth", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumThree)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumThree(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumThree()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountThree", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumDayTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumDayTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumDayTwo()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountDayTwo", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumWeekTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumWeekTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumWeekTwo()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountWeekTwo", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumMonthTwo)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumMonthTwo(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumMonthTwo()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountMonthTwo", scri);
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 총 개수 구하기(orderTotalNumFour)
	//-----------------------------------------------------------------------------------------------------------
	public int orderTotalNumFour(SearchCriteria scri) throws DataAccessException {
		
		logger.info("orderDAO에서 orderTotalNumFour()로 전체 주문 내역 개수 구하기");
		
		return sqlSession.selectOne(Namespace + ".orderListCountFour", scri);
		
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
