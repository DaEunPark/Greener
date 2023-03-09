package com.greener.codegreen.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.greener.codegreen.dto.BuyerDTO;

@Repository("paymentDAO")
public class PaymentDAOImpl implements PaymentDAO {
	private static final Logger logger = LoggerFactory.getLogger(PaymentDAOImpl.class);
	@Autowired
	private SqlSession sqlSession;
	
	private	static final String Namespace = "com.greener.codegreen.payment";
	
	@Override
	public BuyerDTO getBuyerInfo(BuyerDTO buyerId) throws DataAccessException {
		BuyerDTO buyerDTO = sqlSession.selectOne(Namespace + ".buyerInfo", buyerId);
		return buyerDTO;
	}

}
