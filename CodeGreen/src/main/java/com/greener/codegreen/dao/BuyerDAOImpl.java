package com.greener.codegreen.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.BuyerDTO;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 서비스
//-----------------------------------------------------------------------------------------------------------
@Repository("buyerDAO")
public class BuyerDAOImpl implements BuyerDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final Logger logger 
			= LoggerFactory.getLogger(BuyerDAOImpl.class);
	
	private	static final String Namespace = "com.greener.codegreen";
	
	
	@Override
	public BuyerDTO loginByID(BuyerDTO buyerDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addBuyer(BuyerDTO buyerDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idCheck(BuyerDTO buyerDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
