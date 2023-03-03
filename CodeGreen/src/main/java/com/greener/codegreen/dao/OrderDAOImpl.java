package com.greener.codegreen.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.ProductOrderBuyerDTO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ManagerDAO.class);
	
	private	static final String Namespace = "com.greener.codegreen.order";

	//-----------------------------------------------------------------------------------------------------------
	// 전체 주문내역 목록 불러오기
	//-----------------------------------------------------------------------------------------------------------	
	@Override
	public List<HashMap<String, String>> orderListAll() throws DataAccessException {
		logger.info("ManagerDAO orderListAll() 시작");
		
		return sqlSession.selectList(Namespace + ".orderListAll");	
	}

	//----------------------------------------------------------------------------------//
	// 조건에 맞는 주문내역 목록 불러오기
	//----------------------------------------------------------------------------------//	
	@Override
	public List<HashMap<String, String>> orderList(HashMap<String, String> paramMap) throws DataAccessException {
		logger.info("ManagerDAO orderList() 시작");

		return sqlSession.selectList(Namespace + ".orderListCheck", paramMap);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 주문번호 누르면 상세 주문내역 보여주기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public ProductOrderBuyerDTO orderDetail(int orderNum) throws DataAccessException {
		logger.info("managerDAO orderDetail() 시작");
		
		return sqlSession.selectOne(Namespace + ".orderDetailCheck", orderNum);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 주문내역 취소하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int orderListCancle(int oNum) throws DataAccessException {
		logger.info("ManagerDAO 주문내역 취소하기 orderListCancle()...");
		
		return sqlSession.delete(Namespace + ".orderListCancle", oNum); 
	}

}
