package com.greener.codegreen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.greener.codegreen.dao.BuyerDAO;
import com.greener.codegreen.dto.BuyerDTO;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 서비스
//-----------------------------------------------------------------------------------------------------------
@Service("buyerService")
public class BuyerServiceImpl implements BuyerService {
	private static final Logger logger 
	= LoggerFactory.getLogger(BuyerServiceImpl.class);
	
	@Autowired
	private BuyerDAO buyerDAO;

	@Override
	public BuyerDTO login(BuyerDTO buyerDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return buyerDAO.loginByID(buyerDTO);
	}

	@Override
	public int addBuyer(BuyerDTO buyerDTO) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int idCheck(BuyerDTO buyerDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
